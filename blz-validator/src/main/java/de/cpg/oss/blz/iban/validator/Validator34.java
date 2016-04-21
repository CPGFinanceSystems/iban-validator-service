package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5, 10, 9, 7 }, posFrom = 1, posTo = 7, posChecksum = 8)
public class Validator34 extends Validator28 {

}
