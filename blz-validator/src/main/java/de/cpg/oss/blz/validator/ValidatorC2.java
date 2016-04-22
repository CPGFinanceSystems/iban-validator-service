package de.cpg.oss.blz.validator;

@ValidatorData
public class ValidatorC2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator22();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator00();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}

		return true;
	}

}
