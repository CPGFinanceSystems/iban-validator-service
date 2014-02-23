package com.hph.finance.resource;

@RestResource(name="accounts")
public class AccountResource extends Resource {

	private String iban;
	
	private String localId;
	
	private boolean valid;
	
	private boolean verified;
	
	private Resource bank;

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
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
