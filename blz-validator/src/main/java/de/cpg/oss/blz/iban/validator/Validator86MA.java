package de.cpg.oss.blz.iban.validator;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1 }, posFrom = 4, posTo = 9, posChecksum = 10)
public class Validator86MA extends Validator00 {

}
