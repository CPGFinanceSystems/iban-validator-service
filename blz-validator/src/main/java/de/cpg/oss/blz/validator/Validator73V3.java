package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 7, weights = { 2, 1, 2, 1, 2 }, posFrom = 5, posTo = 9)
public class Validator73V3 extends Validator73V2 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		Integer sum = sumRightLeft(accountNumber.getExtracted(), weights, true);
		Integer rest = sum % modulus;

		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
