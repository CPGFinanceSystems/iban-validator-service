package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 5, 4, 3, 4, 5 }, posFrom = 6, posTo = 10)
public class Validator77V2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		return (sum % modulus) == 0;
	}

}
