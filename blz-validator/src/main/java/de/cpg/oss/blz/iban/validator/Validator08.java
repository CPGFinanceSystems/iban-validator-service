package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator08 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		Long number = Long.parseLong(accountNumber.getRawNumber());
		if (number < 60000) {
			return false;
		}

		return super.validate(accountNumber);
	}
}
