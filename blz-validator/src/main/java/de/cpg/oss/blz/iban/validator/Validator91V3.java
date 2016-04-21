package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=11, weights={2, 3, 4, 0, 5, 6, 7, 8, 9, 10}, posFrom=1, posTo=10, posChecksum=7)
public class Validator91V3 extends Validator06 {


}
