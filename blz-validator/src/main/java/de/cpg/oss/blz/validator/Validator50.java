package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7 }, posFrom = 1, posTo = 6, posChecksum = 7)
public class Validator50 extends Validator06 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (!super.validate(accountNumber)) {
			return super.validate(prepare(accountNumber.getRawNumber() + "000",
					accountNumber.getBankNumber()));
		}
		return true;
	}
}
