package de.cpg.oss.blz.validator;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1 }, posFrom = 2, posTo = 7, posChecksum = 8)
public class Validator13 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		boolean isValid = super.validate(accountNumber);

		if (!isValid) {
			isValid = super.validate(prepare(accountNumber.getRawNumber()
					+ "00", accountNumber.getBankNumber()));
		}

		return isValid;
	}
}
