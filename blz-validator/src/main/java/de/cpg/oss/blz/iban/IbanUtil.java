package de.cpg.oss.blz.iban;

public abstract class IbanUtil {

    public static String germanAccountIdFrom(final Iban iban) {
        return validateGerman(iban).getBban().substring(8);
    }

    public static String germanBankIdFrom(final Iban iban) {
        return validateGerman(iban).getBban().substring(0, 8);
    }

    private static Iban validateGerman(final Iban iban) {
        if ("DE".equals(iban.getCountryCode())) {
            return iban;
        }
        throw new IllegalArgumentException("Not a german IBAN!");
    }
}
