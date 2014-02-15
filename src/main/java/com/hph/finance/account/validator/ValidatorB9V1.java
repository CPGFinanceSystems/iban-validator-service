package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={1, 3, 2, 1, 3, 2, 1}, posFrom=3, posTo=9)
public class ValidatorB9V1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeftRest(accountNumber.getExtracted(), weights, modulus);
		int checksum = sum % 10;
		
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
