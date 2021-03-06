package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7 }, posFrom = 3, posTo = 8, posChecksum = 9)
public class Validator49 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new Validator00();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			
			validator = new Validator01();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		return true;
	}

}
