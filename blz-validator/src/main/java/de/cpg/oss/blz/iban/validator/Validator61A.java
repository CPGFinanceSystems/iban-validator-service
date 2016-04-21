package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2 }, posFrom = 1, posTo = 7, posChecksum = 8)
public class Validator61A extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Integer sum = sumLeftRight(accountNumber.getExtracted(), weights, true);
		int checksum = modulus - Integer.parseInt(last(sum.toString()));

		return checksum == accountNumber.getChecksumAsInt();
	}
}
