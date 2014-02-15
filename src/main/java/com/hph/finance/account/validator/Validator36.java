package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5 }, posFrom = 6, posTo = 9, posChecksum = 10)
public class Validator36 extends Validator06 {

}
