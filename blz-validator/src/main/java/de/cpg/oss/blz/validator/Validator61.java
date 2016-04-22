package de.cpg.oss.blz.validator;

@ValidatorData
public class Validator61 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;

		if (extractAsInt(accountNumber.getZeroFilled(), 9) == 8) {
			validator = new Validator61B();
		} else {
			validator = new Validator61A();
		}

		return validator.isValid(accountNumber.getRawNumber());
	}

}
