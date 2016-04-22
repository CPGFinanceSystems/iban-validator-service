package de.cpg.oss.blz.validator;

/**
 * TODO: Verify algorithm
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8, 9, 10 })
public class Validator11 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumRightLeft(number, weights);
		Integer rest = sum % modulus;

		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		} else if (rest == 1) {
			String sumStr = checksum.toString();
			checksum = Integer.parseInt(sumStr.substring(sumStr.length() - 1,
					sumStr.length()));
		}

		return checksum == last;
	}
}
