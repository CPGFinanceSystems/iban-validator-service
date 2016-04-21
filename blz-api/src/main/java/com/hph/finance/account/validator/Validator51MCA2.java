package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8, 9, 10 }, posFrom = 1, posTo = 9, posChecksum = 10)
public class Validator51MCA2 extends Validator51MCA1 {

}
