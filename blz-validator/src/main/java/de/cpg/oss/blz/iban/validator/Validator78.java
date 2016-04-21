package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator78 extends Validator00 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (accountNumber.getLength() == 8) {
			return false;
		}

		return super.validate(accountNumber);
	}
}
