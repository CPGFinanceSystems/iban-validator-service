package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=11, weights={7, 6, 5, 4, 3, 2}, posFrom=1, posTo=6, posChecksum=7)
public class Validator91V2 extends Validator06 {

}
