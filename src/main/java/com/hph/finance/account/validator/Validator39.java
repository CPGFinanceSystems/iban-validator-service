package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5, 10, 9, 7 }, posFrom = 3, posTo = 9, posChecksum = 10)
public class Validator39 extends Validator06 {

}
