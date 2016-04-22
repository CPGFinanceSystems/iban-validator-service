package de.cpg.oss.blz;


import de.cpg.oss.blz.validator.Validator;

public class ValidatorFactory {

    public static Validator factory(final String index) {
        final String clsName = Validator.class.getCanonicalName().concat(index.toUpperCase());
        try {
            return (Validator) Class.forName(clsName).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ValidatorNotFound();
        }
    }
}
