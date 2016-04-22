package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1 }, posFrom = 2, posTo = 7, posChecksum = 8)
public class Validator63 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (!accountNumber.getZeroFilled().startsWith("0")) {
			return false;
		}

		Integer sum = sumRightLeft(accountNumber.getExtracted(), weights, true);
		int checksum = modulus - Integer.parseInt(last(sum.toString()));
		boolean isValid = checksum == accountNumber.getChecksumAsInt();

		if (!isValid && accountNumber.getZeroFilled().startsWith("000")) {
			return this.isValid(extract(accountNumber.getZeroFilled(), 3, -1)
					+ "00");
		}

		return isValid;
	}

}
