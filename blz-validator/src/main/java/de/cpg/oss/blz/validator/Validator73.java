package de.cpg.oss.blz.validator;

@ValidatorData
public class Validator73 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;

		int third = Integer.parseInt(extract(accountNumber.getZeroFilled(), 3));
		if (third == 9) {

			Validator51MC validator51MC = new Validator51MC();
			return validator51MC.validateException(accountNumber);

		} else {

			validator = new Validator73V1();
			if (!validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber())) {

				validator = new Validator73V2();
				if (!validator.isValid(accountNumber.getRawNumber(),
						accountNumber.getBankNumber())) {

					validator = new Validator73V3();
					return validator.isValid(accountNumber.getRawNumber(),
							accountNumber.getBankNumber());
				}
			}

			return true;
		}
	}

}
