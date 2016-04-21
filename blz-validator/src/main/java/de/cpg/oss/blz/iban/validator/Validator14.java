package de.cpg.oss.blz.iban.validator;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7 }, posFrom = 4, posTo = 9, posChecksum = 10)
public class Validator14 extends Validator02 {

}
