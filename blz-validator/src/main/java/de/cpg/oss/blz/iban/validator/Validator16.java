package de.cpg.oss.blz.iban.validator;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 2, 3, 4 })
public class Validator16 extends Validator06 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumRightLeft(number, weights);
		Integer rest = sum % modulus;

		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		} else if (rest == 1) {

			String check1 = extractChecksum(accountNumber.getZeroFilled(), -1);
			String check2 = extractChecksum(accountNumber.getZeroFilled(), -2);

			if (check1.equals(check2)) {
				return true;
			}

			String sumStr = checksum.toString();
			checksum = Integer.parseInt(sumStr.substring(sumStr.length() - 1,
					sumStr.length()));
		}

		return checksum == last;
	}
}
