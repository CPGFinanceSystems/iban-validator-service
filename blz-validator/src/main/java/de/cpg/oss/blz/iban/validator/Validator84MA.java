package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6 }, posFrom = 5, posTo = 9, posChecksum = 10)
public class Validator84MA extends Validator33 {

}
