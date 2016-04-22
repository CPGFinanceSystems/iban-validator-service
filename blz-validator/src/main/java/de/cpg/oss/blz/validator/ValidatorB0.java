package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorB0 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int eight = extractAsInt(accountNumber.getZeroFilled(), 8);
		
		Validator validator;
		if(eight == 1 || eight == 2 || eight == 3 || eight == 6) {
			validator = new Validator09();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		} else {
			validator = new Validator06();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
		}
	}

}
