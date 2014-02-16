package com.hph.finance.resource;

public class AccountResource {

	private String iban;
	
	private AbstractResource bank;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public AbstractResource getBank() {
		return bank;
	}

	public void setBank(AbstractResource bank) {
		this.bank = bank;
	}
}
