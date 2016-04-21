package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=10, weights={2, 1, 2, 1, 2, 1, 2, 0, 0})
public class ValidatorA1 extends Validator00 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(accountNumber.getLength() != 8 && accountNumber.getLength() != 10) {
			return false;
		}
		
		return super.validate(accountNumber);
	}

}
