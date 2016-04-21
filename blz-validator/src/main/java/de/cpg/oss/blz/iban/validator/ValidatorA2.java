package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorA2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new ValidatorA2V1();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new ValidatorA2V2();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
		}
		
		return true;
	}

}
