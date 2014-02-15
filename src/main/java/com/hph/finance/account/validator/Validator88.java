package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={2, 3, 4, 5, 6, 7}, posFrom=4, posTo=9, posChecksum=10)
public class Validator88 extends Validator06 {

	protected PreparedAccountNumber prepare(String accountNumber, String bankNumber) {

		if(extract(zeroFill(accountNumber, length), 3).equals("9")) {
			posFrom = 3;
			
			int[] newWeights = {2, 3, 4, 5, 6, 7, 8};
			weights = newWeights;
		}
	
		return super.prepare(accountNumber, bankNumber);
	}
}
