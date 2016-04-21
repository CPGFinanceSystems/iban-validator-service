package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 1, 2, 1, 2, 1, 2 }, posFrom = 2, posTo = 7, posChecksum = 8, crossSumIndexes = {
		1, 3, 5 })
public class Validator17 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumLeftRight(number, weights, true, crossSumIndexes) - 1;
		Integer rest = sum % modulus;

		Integer checksum = 10 - rest;

		if (rest == 0) {
			checksum = 0;
		}

		return checksum == last;
	}
}
