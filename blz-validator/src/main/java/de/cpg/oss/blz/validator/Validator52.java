package de.cpg.oss.blz.validator;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4 })
public class Validator52 extends Validator {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		if(bankNumber == null || bankNumber.equals("")) {
			throw new MissingBankNumberException();
		}
		
		String eser = extract(bankNumber, -4, -1)
				+ extract(accountNumber, 1, 2)
				+ zeroTrimFront(extract(accountNumber, 3, -1));

		PreparedAccountNumber number = super.prepare(accountNumber, bankNumber);
		number.setEser(eser);
		number.setEserExtracted(extract(eser, 1, 5) + "0" + extract(eser, 7, -1));
		number.setChecksum(extract(eser, 6));
		return number;
	}

	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (extract(accountNumber.getZeroFilled(), 1).equals("9") && accountNumber.getLength() == 10) {
			Validator20 validator20 = new Validator20();
			return validator20.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}

		int sum = sumRightLeft(accountNumber.getEserExtracted(), weights);
		int rest = sum % modulus;
		
		int checksum = 0;
		for (int i = 0; i < 10; i++) {
			int tmpRest = (rest + i * 10) % modulus;
			if (tmpRest == 10) {
				checksum = i;
				break;
			}
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}
}
