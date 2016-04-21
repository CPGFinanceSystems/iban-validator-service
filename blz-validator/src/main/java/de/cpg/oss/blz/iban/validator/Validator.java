package de.cpg.oss.blz.iban.validator;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public abstract class Validator {

	protected static Logger logger;

	protected int[] weights;
	protected int modulus;
	protected int posFrom;
	protected int posTo;
	protected int posChecksum;
	protected int length;
	protected Map<Integer, Boolean> crossSumIndexes;
	protected int[][] transTable;
	protected int[] transTableRows;

	public Validator() {
		super();

		logger = Logger.getLogger(getClass().getName());

		ValidatorData data = getClass().getAnnotation(ValidatorData.class);
		modulus = data.modulus();
		weights = data.weights();
		posFrom = data.posFrom();
		posTo = data.posTo();
		posChecksum = data.posChecksum();
		length = data.length();

		if (data.transTable().length > 0) {
			transTableRows = data.transTableRows();
			int transTableHeight = data.transTable().length
					/ data.transTableWidth();
			transTable = new int[transTableHeight][data.transTableWidth()];
			int j = 0;
			int k = 0;
			for (int i = 0; i < data.transTable().length; i++) {
				transTable[k][j] = data.transTable()[i];
				j = (j + 1) % data.transTableWidth();
				if (j == 0) {
					k++;
				}
			}
		}

		if (data.crossSumIndexes().length > 0) {
			crossSumIndexes = new HashMap<Integer, Boolean>();
			for (int i = 0; i < data.crossSumIndexes().length; i++) {
				crossSumIndexes.put(data.crossSumIndexes()[i], true);
			}
		}

	}

	protected void init() {
	}

	public static int sumTransform(String number, int[][] transTable,
			int[] transTableRows) {

		int sum = 0;
		for (int i = number.length() - 1; i >= 0; i--) {

			Integer extracted = Integer.parseInt(extract(number, i + 1));
			Integer transformed = transTable[transTableRows[i] - 1][extracted];

			sum += transformed;
		}

		return sum;
	}

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		String zeroFilled = zeroFill(accountNumber, length);
		String extracted = extract(zeroFilled, posFrom, posTo);

		if (posChecksum > 1 && posChecksum < extracted.length()) {
			extracted = extract(extracted, 1, posChecksum - 1) + "0"
					+ extract(extracted, posChecksum + 1, -1);
		} else if (posChecksum == 1) {
			extracted = "0" + extract(extracted, 2, -1);
		} else if (posChecksum == extracted.length()) {
			extracted = extract(extracted, 1, -2) + "0";
		}

		PreparedAccountNumber number = new PreparedAccountNumber();
		number.setBankNumber(bankNumber);
		number.setRawNumber(accountNumber);
		number.setExtracted(extracted);
		number.setChecksum(extract(zeroFilled, posChecksum));
		number.setZeroFilled(zeroFilled);
		number.setTrimmed(zeroTrimFront(zeroFilled));

		return number;
	}

	protected abstract boolean validate(PreparedAccountNumber accountNumber);

	public final boolean isValid(String accountNumber) {
		return isValid(accountNumber, null);
	}

	public final boolean isValid(String accountNumber, String bankNumber) {

		init();

		if (accountNumber.length() > length || accountNumber.equals("")
				|| accountNumber == null) {
			return false;
		}

		logger.debug("Prepare: accountNumber[" + accountNumber
				+ "], bankNumber[" + bankNumber + "]");
		PreparedAccountNumber preparedNumber = prepare(accountNumber,
				bankNumber);
		logger.debug("Validate: " + preparedNumber);
		return validate(preparedNumber);
	}

	/**
	 * Computes the cross sum of a given number.
	 * 
	 * @param number
	 * @return Cross sum
	 */
	public static int crossSum(int number) {

		int crossSum = 0;
		while (number != 0) {
			crossSum = crossSum + number % 10;
			number = number / 10;
		}

		return crossSum;
	}

	/**
	 * Computes the cross sum of a given number.
	 * 
	 * @param number
	 * @return Cross sum
	 */
	public static int crossSum(String number) {
		return crossSum(Integer.parseInt(number));
	}

	public static int totalCrossSum(int number) {

		number = crossSum(number);

		if (number > 9) {
			number = totalCrossSum(number);
		}

		return number;
	}

	public static int totalCrossSum(String number) {
		return totalCrossSum(Integer.parseInt(number));
	}

	public static int sumLeftRightAdd(String number, int[] weights, int modulus) {

		int weightsIndex = 0;
		int sum = 0;
		boolean start = false;

		for (int i = 0; i < number.length(); i++) {

			int num = Integer.parseInt(number.substring(i, i + 1));

			if (num > 0 || start) {
				start = true;
				sum += ((num * weights[weightsIndex]) + weights[weightsIndex])
						% modulus;
				weightsIndex = (weightsIndex + 1) % weights.length;
			}
		}

		return sum;
	}

	public static int sumRightLeftLast(String number, int[] weights) {

		int weightsIndex = 0;
		int sum = 0;

		for (int i = number.length() - 1; i >= 0; i--) {

			Integer prod = Integer.parseInt(number.substring(i, i + 1))
					* weights[weightsIndex];

			sum += Integer.parseInt(last(prod.toString()));
			weightsIndex = (weightsIndex + 1) % weights.length;
		}

		return sum;
	}

	public static int sumRightLeftRest(String number, int[] weights, int modulus) {

		int weightsIndex = 0;
		int sum = 0;

		for (int i = number.length() - 1; i >= 0; i--) {

			int rest = ((extractAsInt(number, i + 1) * weights[weightsIndex]) +  weights[weightsIndex]) % modulus;
			sum += rest;
			weightsIndex = (weightsIndex + 1) % weights.length;
		}

		return sum;
	}	
	
	/**
	 * Sums single numbers of number and weights from right to left.
	 * 
	 * @param number
	 * @param weights
	 * @param crossSum
	 * @param crossSumIndexes
	 * @return Sum
	 */
	public static int sumRightLeft(String number, int[] weights,
			boolean crossSum, Map<Integer, Boolean> crossSumIndexes) {

		int weightsIndex = 0;
		int sum = 0;

		for (int i = number.length() - 1; i >= 0; i--) {

			Integer prod = extractAsInt(number, i + 1) * weights[weightsIndex];

			if (prod > 9 && crossSum && crossSumIndexes != null && crossSumIndexes.containsKey(i)) {
				prod = crossSum(prod);
			} else if (prod > 9 && crossSum) {
				prod = crossSum(prod);
			}

			sum += prod;
			weightsIndex = (weightsIndex + 1) % weights.length;
		}

		return sum;
	}

	public static int sumRightLeft(String number, int[] weights,
			boolean crossSum) {
		return sumRightLeft(number, weights, crossSum, null);
	}

	public static int sumRightLeft(String number, int[] weights) {
		return sumRightLeft(number, weights, false, null);
	}

	/**
	 * Sums single numbers of number and weights from left to right.
	 * 
	 * @param number
	 * @param weights
	 * @param crossSum
	 * @param crossSumIndexes
	 * @return Sum
	 */
	public static int sumLeftRight(String number, int[] weights,
			boolean crossSum, Map<Integer, Boolean> crossSumIndexes) {

		int weightsIndex = 0;
		int sum = 0;

		for (int i = 0; i < number.length(); i++) {

			Integer prod = extractAsInt(number, i + 1) * weights[weightsIndex];
			
			if (prod > 9 && crossSum && crossSumIndexes != null && crossSumIndexes.containsKey(i)) {
				prod = crossSum(prod);
			} else if (prod > 9 && crossSum) {
				prod = crossSum(prod);
			}

			sum += prod;
			weightsIndex = (weightsIndex + 1) % weights.length;
		}

		return sum;
	}

	public static int sumLeftRight(String number, int[] weights,
			boolean crossSum) {
		return sumLeftRight(number, weights, crossSum, null);
	}

	public static int sumLeftRight(String number, int[] weights) {
		return sumLeftRight(number, weights, false, null);
	}

	/**
	 * Fills a digit string with zeros.
	 * 
	 * @param number
	 * @param length
	 * @param pos
	 * @return
	 */
	public static String zeroFill(String number, int length, int pos) {

		if (number.length() >= length) {
			return number;
		}

		String zeros = "";
		for (int i = 0; i < length - number.length(); i++) {
			zeros += "0";
		}

		if (pos == 0 || pos < number.length() * -1) {
			return zeros + number;
		} else if (pos == -1 || pos >= number.length()) {
			return number + zeros;
		} else if (pos > 0) {
			String p1 = number.substring(0, pos);
			String p2 = number.substring(pos, number.length());
			return p1 + zeros + p2;
		} else if (pos < 0) {
			String p1 = number.substring(0, number.length() + pos + 1);
			String p2 = number.substring(number.length() + pos + 1,
					number.length());
			return p1 + zeros + p2;
		}

		return number;
	}

	/**
	 * Fills a digit string with zeros.
	 * 
	 * @param number
	 * @param length
	 * @return
	 */
	public static String zeroFill(String number, int length) {
		return zeroFill(number, length, 0);
	}

	public static String zeroTrimFront(String number) {
		return number.replaceAll("^0+([1-9]+[0-9]*)", "$1");
	}

	public static int zeroTrimFrontAsInt(String number) {
		return Integer.parseInt(zeroTrimFront(number));
	}

	/**
	 * Gets the last char of a string.
	 * 
	 * @param number
	 * @return
	 */
	public static String last(String number) {
		return extract(number, -1);
	}

	/**
	 * Extracts a substring of number.
	 * 
	 * @param number
	 * @param from
	 * @param to
	 * @return
	 */
	public static String extract(String number, int from, int to) {

		if (from < 0) {
			from = number.length() + from;
		} else if (from > 0) {
			from = from - 1;
		}

		if (to < 0) {
			to = number.length() + to + 1;
		}

		if (from > to) {
			int tmp = from;
			from = to - 1;
			to = tmp + 1;
		}

		try {
			return number.substring(from, to);
		} catch(IndexOutOfBoundsException error) {
			return null;
		}
	}

	/**
	 * Extract a single character at given position.
	 * 
	 * @param number
	 * @param pos
	 * @return
	 */
	public static String extract(String number, int pos) {
		return extract(number, pos, pos);
	}

	/**
	 * Extracts a substring as integer.
	 * 
	 * @param number
	 * @param pos
	 * @return
	 */
	public static int extractAsInt(String number, int from, int to) {
		return Integer.parseInt(extract(number, from, to));
	}

	/**
	 * Extract a single character at given position as integer.
	 * 
	 * @param number
	 * @param pos
	 * @return
	 */
	public static int extractAsInt(String number, int pos) {
		return extractAsInt(number, pos, pos);
	}

	/**
	 * Extract a single character at given position as integer.
	 * 
	 * @param number
	 * @param pos
	 * @return
	 */
	public static int extractAsInt(int num, int pos) {
		return extractAsInt("" + num, pos, pos);
	}	
	
	/**
	 * Extracts the checksum of the account number.
	 * 
	 * @param number
	 * @param pos
	 * @return
	 */
	public static String extractChecksum(String number, int pos) {
		return extract(number, pos, pos);
	}

	/**
	 * Gets the next half decade of a given sum.
	 * 
	 * @param sum
	 * @return
	 */
	public static int getHalfDecade(int sum) {

		int hd = 0;
		int rest = sum % 5;
		boolean isEven = (sum / 5) % 2 == 0;

		if (rest > 0 && isEven) {
			hd = sum - rest + 5;
		} else if (rest > 0 && !isEven) {
			hd = sum - rest + 10;
		} else if (rest == 0 && isEven) {
			hd = sum + 5;
		} else {
			hd = sum;
		}

		return hd;
	}
}
