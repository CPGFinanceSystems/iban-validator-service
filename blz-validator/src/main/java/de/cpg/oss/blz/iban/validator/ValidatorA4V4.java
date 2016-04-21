package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorA4V4 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator93();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
	}

}
