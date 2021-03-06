package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 2 }, posFrom = 3, posTo = 9, posChecksum = 10)
public class Validator54 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;

		if (rest == 0 || rest == 1) {
			return false;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
