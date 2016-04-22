package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorB5 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new ValidatorB5V1();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			
			if(extractAsInt(accountNumber.getZeroFilled(), 1) == 8 || extractAsInt(accountNumber.getZeroFilled(), 1) == 9) {
				return false;
			}
			
			validator = new Validator00();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		return true;
	}

}
