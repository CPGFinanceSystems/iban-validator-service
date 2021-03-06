package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 9, 8, 7, 6, 5, 4, 3, 2, 1 })
public class Validator31 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumRightLeft(number, weights);
		Integer checksum = sum % modulus;

		if (checksum == 10) {
			return false;
		}

		return checksum == last;
	}
}
