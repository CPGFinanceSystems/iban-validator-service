package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=10, weights={2,1,2,1,2,1,2,1,2,1,2,1,2,1,2}, posFrom=2)
public class ValidatorD1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(extractAsInt(accountNumber.getZeroFilled(), 1) == 7 || extractAsInt(accountNumber.getZeroFilled(), 1) == 8) {
			return false;
		}
		
		String[] map = {
			"4363380",
			"4363381",
			"4363382",
			"4363383",
			"4363384",
			"4363385",
			"4363386",
			"",
			"",
			"4363389"
		};
		
		String extracted = map[extractAsInt(accountNumber.getZeroFilled(), 1)] + accountNumber.getExtracted();
		
		int sum = sumRightLeft(extracted, weights, true);
		int checksum = modulus - extractAsInt(sum, -1);

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
