package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=7, weights={2, 3, 4, 5, 6}, posFrom=1, posTo=5, posChecksum=6)
public class Validator93V2 extends Validator {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {
		
		if(zeroFill(accountNumber, length).startsWith("0000")) {
			posFrom = 5;
			posTo = 9;
			posChecksum = 10;
		}
		
		return super.prepare(accountNumber, bankNumber);
	}
	
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Integer sum = sumRightLeft(accountNumber.getExtracted(), weights);
		Integer rest = sum % modulus;
		Integer checksum = modulus - rest;

		if (rest == 0) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
