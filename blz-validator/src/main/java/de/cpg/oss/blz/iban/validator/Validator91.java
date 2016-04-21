package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class Validator91 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator91V1();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator91V2();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new Validator91V3();
				if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
					validator = new Validator91V4();
					return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
				}			
			}		
		}
		
		return true;
	}

}
