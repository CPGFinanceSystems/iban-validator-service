package de.cpg.oss.blz.validator;

@ValidatorData
public class Validator93 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new Validator93V1();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator93V2();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
		}
		
		return true;		
	}

}
