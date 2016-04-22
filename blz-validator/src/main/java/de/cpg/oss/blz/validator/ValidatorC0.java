package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorC0 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if(accountNumber.getLength() == 8) {
			
			validator = new Validator52();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new Validator20();
				return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
			}
			
			return true;
		}
		
		validator = new Validator20();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
	}

}
