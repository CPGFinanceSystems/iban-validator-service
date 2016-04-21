package de.cpg.oss.blz.iban.validator;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8 }, posFrom = 1, posTo = 7, posChecksum = 8)
public class Validator28 extends Validator06 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumRightLeft(number, weights);
		Integer rest = sum % modulus;

		Integer checksum = modulus - rest;

		if (rest == 0 || rest == 1) {
			checksum = 0;
		}

		return checksum == last;
	}
}
