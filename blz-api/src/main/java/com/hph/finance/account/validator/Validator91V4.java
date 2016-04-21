package com.hph.finance.account.validator;

import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={2, 4, 8, 5, 10, 9}, posFrom=1, posTo=6, posChecksum=7)
public class Validator91V4 extends Validator06 {

}
