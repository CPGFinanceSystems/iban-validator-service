package com.hph.finance.resource;

@RestResource(name="accounts")
public class AccountResource extends Resource {

	private String iban;
	
	private boolean valid = false;
	
	private Resource bank;
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Resource getBank() {
		return bank;
	}

	public void setBank(Resource bank) {
		this.bank = bank;
	}
}
