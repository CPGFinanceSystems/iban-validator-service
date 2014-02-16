package com.hph.finance.resource;

import java.util.ArrayList;
import java.util.List;

public class IndexResource extends AbstractResource {

	private List<String> resources = new ArrayList<String>();

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}
}
