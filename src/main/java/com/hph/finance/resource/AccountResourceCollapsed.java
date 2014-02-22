package com.hph.finance.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RestResource(name="accounts")
public class AccountResourceCollapsed extends ResourceCollapsed {
	
	@JsonIgnore
	private String iban;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String getHref() {
		
		if(iban != null && !iban.equals("")) {
			return super.getHref() + "/iban/" + iban; 
		}
		
		return super.getHref();
	}
}
