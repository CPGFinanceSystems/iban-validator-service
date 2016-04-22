package de.cpg.oss.blz.validator;

@ValidatorData(modulus=7, weights={2, 3, 4, 5, 6, 7, 0, 0, 0}, posFrom=4, posTo=9, posChecksum=10)
public class ValidatorA4V2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;
		
		if(rest == 0) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}

}
