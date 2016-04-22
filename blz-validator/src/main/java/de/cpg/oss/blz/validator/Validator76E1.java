package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7 }, posFrom = 2, posTo = 7, posChecksum = 8)
public class Validator76E1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int checksum = sum % modulus;

		if (checksum == 10) {
			return false;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
