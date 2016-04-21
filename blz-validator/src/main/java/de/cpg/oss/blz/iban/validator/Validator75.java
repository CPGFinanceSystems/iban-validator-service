package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2 })
public class Validator75 extends Validator {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		int length = zeroTrimFront(accountNumber).length();

		if (length == 6 || length == 7) {
			posFrom = 5;
			posTo = 9;
			posChecksum = 10;
		} else if (length == 9
				&& extract(zeroFill(accountNumber, length), 2).equals("9")) {
			posFrom = 3;
			posTo = 7;
			posChecksum = 8;
		} else if (length == 9 || length == 10) {
			posFrom = 2;
			posTo = 6;
			posChecksum = 7;
		}

		return super.prepare(accountNumber, bankNumber);
	}

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumLeftRight(accountNumber.getExtracted(), weights, true);
		int checksum = modulus - extractAsInt(sum, -1);

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
