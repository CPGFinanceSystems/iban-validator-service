package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 1, 2, 1, 2, 1, 2, 1, 2, 1 })
public class Validator57V1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		int last = accountNumber.getChecksumAsInt();

		Integer sum = sumLeftRight(number, weights, true);
		int checksum = modulus - Integer.parseInt(last(sum.toString()));

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == last;
	}

}
