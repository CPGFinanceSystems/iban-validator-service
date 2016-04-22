package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator09 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		return true;
	}
}
