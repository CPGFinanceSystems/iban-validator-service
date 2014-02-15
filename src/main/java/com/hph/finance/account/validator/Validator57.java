package com.hph.finance.account.validator;

import java.util.HashMap;
import java.util.Map;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;
import com.hph.finance.account.ValidatorFactory;

@ValidatorData
public class Validator57 extends Validator {

	private static final String[] type1 = { "51", "55", "61", "64", "65", "66",
			"70", "73", "75", "76", "77", "78", "79", "80", "81", "82", "88",
			"94", "95" };

	private static final String[] type2 = { "32", "33", "34", "35", "36", "37",
			"38", "39", "41", "42", "43", "44", "45", "46", "47", "48", "49",
			"52", "53", "54", "56", "57", "58", "59", "60", "62", "63", "67",
			"68", "69", "71", "72", "74", "83", "84", "85", "86", "87", "89",
			"90", "92", "93", "96", "97", "98" };

	private static final String[] type3 = { "40", "50", "91", "92", "93", "94",
			"95", "96", "97", "98", "99" };

	private static final String[] type4 = { "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
			"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30", "31" };

	protected static Map<String, String> types = new HashMap<String, String>();

	static {

		for (int i = 0; i < type1.length; i++) {
			types.put(type1[i], "57V1");
		}

		for (int i = 0; i < type2.length; i++) {
			types.put(type2[i], "57V2");
		}

		for (int i = 0; i < type3.length; i++) {
			types.put(type3[i], "57V3");
		}

		for (int i = 0; i < type4.length; i++) {
			types.put(type4[i], "57V4");
		}
	}

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (accountNumber.getRawNumber().startsWith("777777")) {
			return true;
		} else if (accountNumber.getRawNumber().startsWith("888888")) {
			return true;
		} else if (accountNumber.getRawNumber().startsWith("00")) {
			return false;
		}

		String index = extract(accountNumber.getZeroFilled(), 1, 2);

		if (types.containsKey(index)) {
			Validator validator = ValidatorFactory.factory(types.get(index));
			return validator.isValid(accountNumber.getRawNumber());
		}

		return false;
	}

}
