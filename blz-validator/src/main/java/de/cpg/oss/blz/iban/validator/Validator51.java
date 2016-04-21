package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class Validator51 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new Validator51MA();
		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {

			validator = new Validator51MB();
			if (!validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber())) {

				validator = new Validator51MC();
				return validator.isValid(accountNumber.getRawNumber(),
						accountNumber.getBankNumber());
			}
		}

		return true;
	}
}
