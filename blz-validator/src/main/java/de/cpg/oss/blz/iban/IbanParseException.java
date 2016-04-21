package de.cpg.oss.blz.iban;

public class IbanParseException extends Exception {

    private static final long serialVersionUID = 1L;

    public IbanParseException(final String message) {
        super(message);
    }
}
