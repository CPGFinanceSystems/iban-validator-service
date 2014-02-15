package com.hph.finance.account;

public class ValidatorFactory {

	public static Validator factory(String index) {
		String clsName = "com.hph.finance.account.validator.Validator"
				+ index.toUpperCase();
		try {
			return (Validator) Class.forName(clsName).newInstance();
		} catch (InstantiationException e) {
			throw new ValidatorNotFound();
		} catch (IllegalAccessException e) {
			throw new ValidatorNotFound();
		} catch (ClassNotFoundException e) {
			throw new ValidatorNotFound();
		}
	}
}
