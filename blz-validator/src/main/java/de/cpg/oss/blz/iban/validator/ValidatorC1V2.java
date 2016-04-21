package de.cpg.oss.blz.iban.validator;

import java.util.HashMap;
import java.util.Map;

@ValidatorData(modulus=11, weights={1, 2, 1, 2, 1, 2, 1, 2, 1})
public class ValidatorC1V2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Map<Integer, Boolean> qi = new HashMap<Integer, Boolean>();
		qi.put(1, true);
		qi.put(3, true);
		qi.put(5, true);
		qi.put(7, true);
		
		int sum = sumLeftRight(accountNumber.getExtracted(), weights, true, qi) - 1;
		int rest = sum % modulus;
		int checksum = 10 - rest;
		
		if(rest == 0) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}

}
