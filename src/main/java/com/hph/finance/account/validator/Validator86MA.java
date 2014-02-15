package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1 }, posFrom = 4, posTo = 9, posChecksum = 10)
public class Validator86MA extends Validator00 {

}
