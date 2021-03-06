package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator21 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumRightLeft(number, weights, true, null);
		Integer checksum = modulus - totalCrossSum(sum.toString());

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == last;
	}
}
