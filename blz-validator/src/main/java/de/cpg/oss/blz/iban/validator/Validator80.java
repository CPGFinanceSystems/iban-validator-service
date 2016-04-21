package de.cpg.oss.blz.iban.validator;

@ValidatorData
public class Validator80 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int third = Integer.parseInt(extract(accountNumber.getZeroFilled(), 3));
		if (third == 9) {

			Validator51MC validator51MC = new Validator51MC();
			return validator51MC.validateException(accountNumber);

		}

		Validator validator = new Validator80MA();
		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {
			validator = new Validator80MB();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		return true;
	}
}
