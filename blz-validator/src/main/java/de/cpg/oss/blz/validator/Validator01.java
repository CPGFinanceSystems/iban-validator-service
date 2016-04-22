package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 10, weights = { 3, 7, 1, 3, 7, 1, 3, 7, 1 })
public class Validator01 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int checksum = modulus - extractAsInt(sum, -1);

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
