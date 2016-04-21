package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11)
public class Validator97 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int num = Integer.parseInt(accountNumber.getExtracted());
		int checksum = num - ((num / modulus) * modulus);
		
		if(checksum == 10) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}

}
