package com.hph.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hph.finance.account.Iban;
import com.hph.finance.account.IbanParseException;
import com.hph.finance.account.iban.IbanDe;
import com.hph.finance.data.model.BankDe;
import com.hph.finance.data.service.BankDeRepository;
import com.hph.finance.resource.AccountResource;
import com.hph.finance.resource.BankResourceCollapsed;

@Controller
public class AccountController {

	@Autowired
	private BankDeRepository bankDeRepository;
	
	@RequestMapping(value="/accounts/iban/{iban}", method=RequestMethod.GET)
	public @ResponseBody AccountResource indexGet(@PathVariable("iban") String iban) {
		
		AccountResource resource = new AccountResource();
		
		try {
			
			Iban validIban = Iban.parse(iban);
			resource.setIban(validIban.toIbanString());
			resource.setValid(true);
			resource.setBank(null);
			
			if(validIban.getCountry().equals("DE")) {
				IbanDe ibanDe = IbanDe.parse(validIban.toIbanString());
				BankDe bankDe = bankDeRepository.findByBankleitzahl(ibanDe.getBankId());
				
				if(bankDe != null) {
					
					BankResourceCollapsed bankResource = new BankResourceCollapsed();
					bankResource.setBic(bankDe.getBic());
					
					resource.setBank(bankResource);
				}
			}
			
			return resource;
			
		} catch (IbanParseException e) {
			return null;
		}
	}
}
