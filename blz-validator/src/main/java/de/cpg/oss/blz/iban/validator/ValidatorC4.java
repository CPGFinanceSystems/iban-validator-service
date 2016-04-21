package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorC4 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator;
		
		if(extractAsInt(accountNumber.getZeroFilled(),1) == 9) {
			
			 validator = new Validator58();
			 return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		validator = new Validator15();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
	}

}
