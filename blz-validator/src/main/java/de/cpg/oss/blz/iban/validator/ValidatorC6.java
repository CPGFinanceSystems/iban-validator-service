package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=10, weights={2,1,2,1,2,1,2,1,2,1,2,1,2,1,2}, posFrom=2)
public class ValidatorC6 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(extractAsInt(accountNumber.getZeroFilled(), 1) == 4 || extractAsInt(accountNumber.getZeroFilled(), 1) == 8) {
			return false;
		}
		
		String[] map = {
			"4451970",
			"4451981",
			"4451992",
			"4451993",
			"",
			"4344990",
			"4344991",
			"5499570",
			"",
			"5499579"
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
