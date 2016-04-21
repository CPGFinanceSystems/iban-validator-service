package de.cpg.oss.blz.iban;

import lombok.Value;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.stream.Stream;

@Value
public class Iban implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final transient String[] ISO_COUNTRIES = Locale.getISOCountries();

    private final String countryCode;
    private final int checksum;
    private final String bban;

    private Iban(final String countryCode, final int checksum, final String bban) {
        this.countryCode = countryCode;
        this.checksum = checksum;
        this.bban = bban;
    }

    public static Iban parse(final String ibanString) throws IbanParseException {

        if (ibanString == null || ibanString.length() < 15) {
            throw new IllegalArgumentException("Nothing to parse!");
        }

        final String formatted = ibanString.replaceAll("\\s", "").toUpperCase();

        final String country = formatted.substring(0, 2);
        if (country.equals("") || !country.matches("[a-zA-Z]{2}")) {
            throw new IbanParseException("Missing or invalid countryCode!");
        }
        Stream.of(ISO_COUNTRIES).map(country::equals).findFirst()
                .orElseThrow(() -> new IbanParseException(MessageFormat.format(
                        "{0} is not a valid ISO3166 country code!", country)));

        final String checksum = formatted.substring(2, 4);
        if (checksum.equals("") || !checksum.matches("[0-9]{2}")) {
            throw new IbanParseException("Missing or invalid checksum!");
        }

        final String bban = formatted.substring(4);
        if (bban.equals("") || !bban.matches("[0-9a-zA-Z]+")) {
            throw new IbanParseException("Missing or invalid BBAN!");
        }

        final String ibanCheck = bban + country + checksum;
        String ibanCheckMapped = "";
        for (int i = 0; i < ibanCheck.length(); i++) {
            if ((int) ibanCheck.charAt(i) >= 65 &&
                    (int) ibanCheck.charAt(i) <= 90) {
                ibanCheckMapped += mapChar(ibanCheck.charAt(i));
            } else {
                ibanCheckMapped += ibanCheck.charAt(i) + "";
            }
        }

        final BigInteger ibanBig = new BigInteger(ibanCheckMapped);
        if (!ibanBig.mod(BigInteger.valueOf(97)).equals(BigInteger.ONE)) {
            throw new IbanParseException("Invalid modulo checksum!");
        }

        return new Iban(country, Integer.valueOf(checksum), bban);
    }

    public String toString() {
        return countryCode.concat(MessageFormat.format("{0,number,##}", checksum)).concat(bban);
    }

    private static String mapChar(final char toMap) {

        final int newInt = (int) toMap;
        if (newInt < 65 || newInt > 90) {
            throw new IbanMapException("Char out of range!");
        }

        return (newInt - 55) + "";
    }
}
