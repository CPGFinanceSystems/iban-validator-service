package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorB3 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int first = extractAsInt(accountNumber.getZeroFilled(), 1);
		
		Validator validator;
		if(first == 9) {
			validator = new Validator06();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		} else {
			validator = new Validator32();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
		}
	}

}
