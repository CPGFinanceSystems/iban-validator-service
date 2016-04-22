package de.cpg.oss.blz.validator;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8, 9 }, posFrom = 1, posTo = 9, posChecksum = 10)
public class Validator25 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();
		Integer workNumber = Integer.parseInt(extract(number, 2));

		Integer sum = sumRightLeft(number, weights, false);
		Integer rest = (sum % modulus);
		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		} else if (rest == 1 && workNumber >= 0 && workNumber <= 7) {
			return false;
		}

		return checksum == last;
	}
}
