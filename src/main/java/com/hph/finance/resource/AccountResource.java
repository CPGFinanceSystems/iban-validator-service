package com.hph.finance.resource;

public class AccountResource extends Resource {

	private String iban;
	
	private Resource bank;

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
