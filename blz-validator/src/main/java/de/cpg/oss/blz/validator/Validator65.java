package de.cpg.oss.blz.validator;

@ValidatorData
public class Validator65 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;

		if (extractAsInt(accountNumber.getZeroFilled(), 9) == 9) {
			validator = new Validator65B();
		} else {
			validator = new Validator65A();
		}

		return validator.isValid(accountNumber.getRawNumber());
	}
}
