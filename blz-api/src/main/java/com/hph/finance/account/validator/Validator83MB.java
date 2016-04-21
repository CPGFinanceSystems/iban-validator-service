package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6 }, posFrom = 5, posTo = 9, posChecksum = 10)
public class Validator83MB extends Validator33 {

}
