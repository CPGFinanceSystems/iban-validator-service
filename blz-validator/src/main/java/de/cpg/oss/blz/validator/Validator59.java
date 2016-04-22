package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator59 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (zeroTrimFront(accountNumber.getRawNumber()).length() < 9) {
			return true;
		}

		return super.validate(accountNumber);
	}
}
