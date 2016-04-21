package com.hph.finance.account;

public class IbanParseException extends Exception {

    private static final long serialVersionUID = 1L;

    public IbanParseException(final String message) {
        super(message);
    }
}
