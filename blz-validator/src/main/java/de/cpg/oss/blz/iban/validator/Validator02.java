package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8, 9, 2 })
public class Validator02 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		Integer sum = sumRightLeft(accountNumber.getExtracted(), weights);
		Integer rest = sum % modulus;

		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt() && rest != 1;
	}
}
