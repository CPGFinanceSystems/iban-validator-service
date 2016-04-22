package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 6, 5, 4, 3, 2, 1 }, posFrom = 2, posTo = 7, posChecksum = 10)
public class Validator71 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumLeftRight(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		} else if (rest == 1) {
			checksum = 1;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
