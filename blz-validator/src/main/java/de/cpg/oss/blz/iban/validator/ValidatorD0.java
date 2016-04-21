package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class ValidatorD0 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int start = extractAsInt(accountNumber.getZeroFilled(), 1, 2);
		
		Validator validator;
		if(start == 57) {
			validator = new Validator09();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		} else {
			validator = new Validator20();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
		}
	}

}
