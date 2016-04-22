package de.cpg.oss.blz.validator;

@ValidatorData(modulus=11)
public class Validator97 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int num = Integer.parseInt(accountNumber.getExtracted());
		int checksum = num - ((num / modulus) * modulus);
		
		if(checksum == 10) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}

}
