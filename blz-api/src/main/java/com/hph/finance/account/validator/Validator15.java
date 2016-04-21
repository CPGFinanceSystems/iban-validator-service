package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

/**
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5 }, posFrom = 6, posTo = 9, posChecksum = 10)
public class Validator15 extends Validator06 {

}
