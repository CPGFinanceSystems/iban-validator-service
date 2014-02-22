package com.hph.finance.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResourceCollapsed extends Resource {
	
	@JsonIgnore
	private static String baseUrl;
	
	private String href;
	
	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		ResourceCollapsed.baseUrl = baseUrl;
	}

	public String getHref() {
		return baseUrl + href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
