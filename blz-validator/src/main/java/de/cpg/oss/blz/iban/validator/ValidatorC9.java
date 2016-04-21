package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorC9 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator00();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator07();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		return true;	
	}

}
