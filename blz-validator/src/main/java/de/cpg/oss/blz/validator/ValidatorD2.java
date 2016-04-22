package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorD2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator95();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator00();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new Validator68();
				return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
			}		
		}
		
		return true;
	}

}
