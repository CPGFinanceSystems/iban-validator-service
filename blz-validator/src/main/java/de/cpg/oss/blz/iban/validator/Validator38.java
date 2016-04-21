package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5, 10, 9 }, posFrom = 4, posTo = 9, posChecksum = 10)
public class Validator38 extends Validator06 {

}
