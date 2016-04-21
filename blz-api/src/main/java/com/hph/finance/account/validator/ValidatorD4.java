package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=10, weights={2,1,2,1,2,1,2,1,2,1,2,1,2,1,2})
public class ValidatorD4 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(extractAsInt(accountNumber.getZeroFilled(), 1) == 0) {
			return false;
		}
		
		String[] map = {
			"",
			"428259",
			"428259",
			"428259",
			"428259",
			"428259",
			"428259",
			"428259",
			"428259",
			"428259"
		};
		
		String extracted = map[extractAsInt(accountNumber.getZeroFilled(), 1)] + accountNumber.getExtracted();
		
		int sum = sumRightLeft(extracted, weights, true);
		int checksum = modulus - extractAsInt(sum, -1);

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
