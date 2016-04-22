package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 9, 10, 5, 8, 4, 2 }, posFrom = 1, posTo = 6, posChecksum = 7)
public class Validator64 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumLeftRight(number, weights);
		Integer rest = sum % modulus;

		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		} else if (rest == 1) {
			String sumStr = checksum.toString();
			checksum = Integer.parseInt(last(sumStr));
		}

		return checksum == last;
	}
}
