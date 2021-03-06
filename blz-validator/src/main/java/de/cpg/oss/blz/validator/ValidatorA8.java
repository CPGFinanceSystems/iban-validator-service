package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorA8 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int third = Integer.parseInt(extract(accountNumber.getZeroFilled(), 3));
		if (third == 9) {
			Validator51MC validator51MC = new Validator51MC();
			return validator51MC.validateException(accountNumber);
		}
		
		Validator validator = new ValidatorA8V1();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			
			validator = new ValidatorA8V2();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		return true;
	}

}
