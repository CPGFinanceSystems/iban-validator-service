package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2 }, posFrom = 5, posTo = 9, posChecksum = 10)
public class Validator80MA extends Validator00 {

}
