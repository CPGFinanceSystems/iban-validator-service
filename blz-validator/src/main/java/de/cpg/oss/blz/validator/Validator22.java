package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 3, 1, 3, 1, 3, 1, 3, 1, 3 })
public class Validator22 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeftLast(accountNumber.getExtracted(), weights);
		int rest = (sum % modulus);
		int checksum = modulus - rest;

		if(rest == 0) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}
}
