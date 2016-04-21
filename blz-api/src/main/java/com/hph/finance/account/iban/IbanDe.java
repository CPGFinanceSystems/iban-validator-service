package com.hph.finance.account.iban;

import com.hph.finance.account.Iban;
import com.hph.finance.account.IbanParseException;
import com.hph.finance.account.Validator;

public class IbanDe extends Iban {
	
	public static IbanDe parse(String ibanStr) throws IbanParseException {
		
		Iban iban = Iban.parse(ibanStr);
		String bban = iban.getBban();
		
		IbanDe ibanDe = new IbanDe();
		ibanDe.setCountry(iban.getCountry());
		ibanDe.setChecksum(iban.getChecksum());
		ibanDe.setBban(iban.getBban());
		ibanDe.setBankId(Validator.extract(bban, 1, 8));
		ibanDe.setAccountId(Validator.extract(bban, 9, -1));
		
		return ibanDe;
	}
}
