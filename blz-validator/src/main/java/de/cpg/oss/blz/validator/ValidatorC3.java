package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorC3 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator;
		
		if(extractAsInt(accountNumber.getZeroFilled(),1) == 9) {
			
			 validator = new Validator58();
			 return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		validator = new Validator00();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
	}

}
