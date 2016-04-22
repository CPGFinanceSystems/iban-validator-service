package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorD6 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator07();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator03();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new Validator00();
				return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
			}		
		}
		
		return true;
	}

}
