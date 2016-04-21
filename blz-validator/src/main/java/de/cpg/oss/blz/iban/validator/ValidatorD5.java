package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorD5 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator;
		if(extractAsInt(accountNumber.getZeroFilled(), 3, 4) == 99) {
			validator = new ValidatorD5V1();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		validator = new ValidatorD5V2();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new ValidatorD5V3();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new ValidatorD5V4();
				return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
			}		
		}
		
		return true;		
	}

}
