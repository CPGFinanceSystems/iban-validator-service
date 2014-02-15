package com.hph.finance.account.validator;

import java.util.HashMap;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 1, 2, 3, 1, 2, 3, 1, 2, 3 }, posFrom = 1, posTo = 9, posChecksum = 10)
public class Validator24 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();

		HashMap<String, Boolean> zeros = new HashMap<String, Boolean>();
		zeros.put("3", true);
		zeros.put("4", true);
		zeros.put("5", true);
		zeros.put("6", true);

		HashMap<String, Boolean> zerosTri = new HashMap<String, Boolean>();
		zerosTri.put("9", true);

		String first = extract(number, 1);
		if (zeros.containsKey(first)) {
			number = "0" + extract(number, 2, -1);
		} else if (zerosTri.containsKey(first)) {
			number = "000" + extract(number, 4, -1);
		}

		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumLeftRightAdd(number, weights, modulus);
		Integer checksum = Integer.parseInt(last(sum.toString()));

		return checksum == last;
	}
}
