package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={1, 2, 3, 4, 5, 6}, posFrom=4, posTo=9)
public class ValidatorB9V2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int checksum = sum % modulus;
		
		if(!(checksum == accountNumber.getChecksumAsInt())) {
			
			checksum += 5;
			if(checksum >= 10) {
				checksum -= 10;
			}
			
			return checksum == accountNumber.getChecksumAsInt();
		}
		
		return true;		
	}

}
