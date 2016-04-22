package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator45 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (extract(accountNumber.getZeroFilled(), 1).equals("0")
				|| extract(accountNumber.getZeroFilled(), 5).equals("1")) {
			return true;
		}

		return super.validate(accountNumber);
	}
}
