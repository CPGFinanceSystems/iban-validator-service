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
		
		RestResource restResource = this.getClass().getAnnotation(RestResource.class);
		
		if(restResource != null) {
			return baseUrl + "/" + restResource.name();
		} else {
			return this.href;
		}
	}

	public void setHref(String href) {
		this.href = href;
	}
}
