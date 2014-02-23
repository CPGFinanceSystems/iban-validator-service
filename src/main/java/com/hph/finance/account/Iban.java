package com.hph.finance.account;

import java.math.BigInteger;

import org.apache.log4j.Logger;

/**
 * 
 * @author smash
 *
 */
public class Iban {

	private static Logger logger = Logger.getLogger(Iban.class);
	
	private String bankId;
	
	private String accountId;
	
	private String country;
	
	private String bban;
	
	private String checksum = "00";
	
	public static String mapChar(char toMap) {
		
		int newInt = (int)toMap;
		if(newInt < 65 || newInt > 90) {
			throw new IbanMapException("Char out of range!");
		}
		
		return (newInt - 55) + "";
	}
	
	public static String mapInt(int toMap) {
		
		if(toMap < 10 || toMap > 35) {
			throw new IbanMapException("Integer out of range!");
		}
		
		return (toMap + 55) + "";	
	}
	
	public static Iban parse(String ibanString) throws IbanParseException {
		
		if(ibanString == null || ibanString.equals("")) {
			throw new IbanParseException("Nothing to parse!");
		}
		
		ibanString = ibanString.replaceAll("\\s", "").toUpperCase();
		
		String country = Validator.extract(ibanString, 1, 2);
		if(country == null || country.equals("") || 
				!country.matches("[a-zA-Z]{2}")) {
			throw new IbanParseException("Missing or invalid country!");
		};
		
		String checksum = Validator.extract(ibanString, 3, 4);
		if(checksum == null || checksum.equals("") || 
				!checksum.matches("[0-9]{2}")) {
			throw new IbanParseException("Missing or invalid checksum!");	
		};
		
		String bban = Validator.extract(ibanString, 5, -1);
		if(bban == null || bban.equals("") || 
				!bban.matches("[0-9a-zA-Z]+")) {
			throw new IbanParseException("Missing or invalid bban!");
		};
		
		try {
			
			String ibanCheck = bban + country + checksum;
			String ibanCheckMapped = "";
			for(int i = 0; i < ibanCheck.length(); i++) {
				if((int)ibanCheck.charAt(i) >= 65 && 
						(int)ibanCheck.charAt(i) <= 90) {
					ibanCheckMapped += mapChar(ibanCheck.charAt(i));	
				} else {
					ibanCheckMapped += ibanCheck.charAt(i) + "";
				}
			}
			
			BigInteger ibanBig = new BigInteger(ibanCheckMapped);
			if(!ibanBig.mod(new BigInteger("97")).equals(new BigInteger("1"))) {
				throw new IbanParseException("Invalid checksum!");
			}
			
			Iban iban = new Iban();
			iban.setCountry(country);
			iban.setChecksum(checksum);
			iban.setBban(bban);
			
			logger.debug(iban);
			
			return iban;
			
		} catch(NumberFormatException error) {
			throw new IbanParseException("Invalid iban!");
		} catch(IbanMapException error) {
			throw new IbanParseException("Invalid country!");
		}
	}
	
	public static Iban build(String country, String bankId, String accountId) {
		
		return null;
	}
	
	public String toString() {
		return "IBAN: " +
				" country[" + country + "]" +
				" checkSum[" + checksum + "]" +
				" bban[" + bban + "]";
	}
	
	public String toIbanString() {
		return country + checksum + bban;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getBban() {
		return bban;
	}

	public void setBban(String bban) {
		this.bban = bban;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
