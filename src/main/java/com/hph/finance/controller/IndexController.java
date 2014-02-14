package com.hph.finance.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hph.finance.resource.IndexResource;

@Controller
public class IndexController {

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody IndexResource indexGet() {
		
		List<String> resources = new ArrayList<String>();
		resources.add("user");
		resources.add("account");
		
		IndexResource indexResource = new IndexResource();
		indexResource.setResources(resources);
		
		return indexResource;
	}
}
