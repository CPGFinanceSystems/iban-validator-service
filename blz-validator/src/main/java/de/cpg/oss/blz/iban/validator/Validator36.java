package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5 }, posFrom = 6, posTo = 9, posChecksum = 10)
public class Validator36 extends Validator06 {

}
