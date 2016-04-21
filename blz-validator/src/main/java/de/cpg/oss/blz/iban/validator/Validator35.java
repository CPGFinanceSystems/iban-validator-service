package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8, 9, 10 })
public class Validator35 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int checksum = sumRightLeft(accountNumber.getExtracted(), weights)
				% modulus;
		boolean identical = extract(accountNumber.getZeroFilled(), 9).equals(
				extract(accountNumber.getZeroFilled(), 10));

		if (checksum == 10 && identical) {
			return true;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
