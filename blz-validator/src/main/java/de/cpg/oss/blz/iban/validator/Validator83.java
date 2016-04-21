package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class Validator83 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new Validator83MA();
		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {

			validator = new Validator83MB();
			if (!validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber())) {

				validator = new Validator83MC();
				return validator.isValid(accountNumber.getRawNumber(),
						accountNumber.getBankNumber());
			}
		}

		return true;
	}

}
