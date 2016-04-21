package com.hph.finance.account;

public class ValidatorFactory {

    public static Validator factory(String index) {
        final String clsName = "com.hph.finance.account.validator.Validator"
                + index.toUpperCase();
        try {
            return (Validator) Class.forName(clsName).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ValidatorNotFound();
        }
    }
}
