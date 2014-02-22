package com.hph.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hph.finance.account.Iban;
import com.hph.finance.account.IbanParseException;
import com.hph.finance.resource.AccountResource;

@Controller
public class AccountController {

	@RequestMapping(value="/accounts/iban/{iban}", method=RequestMethod.GET)
	public @ResponseBody AccountResource indexGet(@PathVariable("iban") String iban) {
		
		AccountResource resource = new AccountResource();
		
		try {
			
			Iban validIban = Iban.parse(iban);
			resource.setIban(validIban.toIbanString());
			resource.setValid(true);
			resource.setBank(null);
			
			return resource;
		} catch (IbanParseException e) {
			return null;
		}
	}
}
