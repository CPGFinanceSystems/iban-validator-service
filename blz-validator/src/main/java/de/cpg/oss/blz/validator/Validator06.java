package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 2, 3, 4 })
public class Validator06 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		} else if (rest == 1) {
			checksum = extractAsInt(checksum, -1);
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
