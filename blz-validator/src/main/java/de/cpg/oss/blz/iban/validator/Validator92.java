package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus=10, weights={3, 7, 1, 3, 7, 1}, posFrom=4, posTo=9, posChecksum=10)
public class Validator92 extends Validator01 {

}
