package de.cpg.oss.blz.validator;

@ValidatorData
public class Validator96V3 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		return accountNumber.getRawNumberAsLong() >= 1300000 && 
				accountNumber.getRawNumberAsLong() <= 99399999;
	}

}
