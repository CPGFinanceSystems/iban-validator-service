package com.hph.finance.account;

public class PreparedAccountNumber {

	private String rawNumber;
	private String zeroFilled;
	private String bankNumber;
	private String extracted;
	private String trimmed;
	private String checksum;
	private String eser;
	private String eserExtracted;

	public String getEser() {
		return eser;
	}

	public void setEser(String eser) {
		this.eser = eser;
	}

	public String getEserExtracted() {
		return eserExtracted;
	}

	public void setEserExtracted(String eserExtracted) {
		this.eserExtracted = eserExtracted;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getZeroFilled() {
		return zeroFilled;
	}

	public void setZeroFilled(String zeroFilled) {
		this.zeroFilled = zeroFilled;
	}

	public String getRawNumber() {
		return rawNumber;
	}

	public long getRawNumberAsLong() {
		return Long.parseLong(rawNumber);
	}

	public void setRawNumber(String rawNumber) {
		this.rawNumber = rawNumber;
	}

	public String getExtracted() {
		return extracted;
	}

	public void setExtracted(String extracted) {
		this.extracted = extracted;
	}

	public String getChecksum() {
		return checksum;
	}

	public int getChecksumAsInt() {
		return Integer.parseInt(checksum);
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String toString() {
		return "rawNumber[" + rawNumber + "]" + ", bankNumber[" + bankNumber
				+ "]" + ", extracted[" + extracted + "]" + ", zeroFilled["
				+ zeroFilled + "]" + ", eser[" + eser + "]"
				+ ", eserExtracted[" + eserExtracted + "]" + ", checksum["
				+ checksum + "]";
	}

	public String getTrimmed() {
		return trimmed;
	}

	public void setTrimmed(String trimmed) {
		this.trimmed = trimmed;
	}

	public int getLength() {
		return getTrimmed().length();
	}
	
	public int[] getZeroFilledArray() {
		
		int[] arr = new int[zeroFilled.length()];
		for(int i = 0; i < zeroFilled.length(); i++) {
			arr[i] = Integer.parseInt(zeroFilled.substring(i, i + 1));
		}
		return arr;
	}
}
