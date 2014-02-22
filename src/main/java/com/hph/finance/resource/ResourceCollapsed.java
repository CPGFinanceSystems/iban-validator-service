package com.hph.finance.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(name="rest")
public class ResourceCollapsed extends Resource {

	private String href;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
