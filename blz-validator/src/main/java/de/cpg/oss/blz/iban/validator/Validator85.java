package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class Validator85 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;

		if (extract(accountNumber.getZeroFilled(), 3, 4).equals("99")) {

			validator = new Validator85E1();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		validator = new Validator85MA();
		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {

			validator = new Validator85MB();
			if (!validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber())) {

				validator = new Validator85MC();
				return validator.isValid(accountNumber.getRawNumber(),
						accountNumber.getBankNumber());
			}
		}

		return true;
	}

}
