package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 0, 0, 1 }, posFrom = 1, posTo = -2, posChecksum = -1)
public class Validator68B extends Validator00 {

}
