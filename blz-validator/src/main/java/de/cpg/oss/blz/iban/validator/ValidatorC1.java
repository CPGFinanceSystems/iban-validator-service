package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorC1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if(extractAsInt(accountNumber.getZeroFilled(),1) == 5) {
			
			 validator = new ValidatorC1V2();
			 return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		 validator = new Validator17();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
	}

}
