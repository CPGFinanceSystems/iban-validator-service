package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorD8 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		long num = accountNumber.getRawNumberAsLong();
		Validator validator;
		
		if(num >= 1000000000L && num <= 9999999999L) {
			validator = new Validator00();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		if(num >= 10000000L && num <= 99999999L) {
			validator = new Validator09();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		return false;
	}

}
