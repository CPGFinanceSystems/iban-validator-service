package de.cpg.oss.blz.iban.validator;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7 }, posFrom = 1, posTo = 6, posChecksum = 7)
public class Validator23 extends Validator16 {

}
