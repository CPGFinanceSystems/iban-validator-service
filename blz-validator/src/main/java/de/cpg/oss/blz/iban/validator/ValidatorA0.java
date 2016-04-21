package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=11, weights={2, 4, 8, 5, 10, 0, 0, 0, 0})
public class ValidatorA0 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(accountNumber.getLength() == 3) {
			return true;
		}
		
		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;
		
		if(rest == 0 || rest == 1) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}

}
