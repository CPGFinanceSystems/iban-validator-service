package com.hph.finance.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RestResource(name="banks")
public class BankResourceCollapsed extends ResourceCollapsed {
	
	@JsonIgnore
	private String bic;

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	@Override
	public String getHref() {
		
		if(bic != null && !bic.equals("")) {
			return super.getHref() + "/bic/" + bic; 
		}
		
		return super.getHref();
	}
	
	
}
