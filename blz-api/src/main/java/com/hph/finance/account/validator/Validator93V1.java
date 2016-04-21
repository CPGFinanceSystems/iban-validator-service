package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={2, 3, 4, 5, 6}, posFrom=1, posTo=5, posChecksum=6)
public class Validator93V1 extends Validator06 {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {
		
		if(zeroFill(accountNumber, length).startsWith("0000")) {
			posFrom = 5;
			posTo = 9;
			posChecksum = 10;
		}
		
		return super.prepare(accountNumber, bankNumber);
	}
}
