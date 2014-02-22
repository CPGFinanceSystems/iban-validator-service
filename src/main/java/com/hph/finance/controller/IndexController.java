package com.hph.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hph.finance.data.service.BankDeRepository;
import com.hph.finance.resource.IndexResource;
import com.hph.finance.resource.IndexResources;
import com.hph.finance.resource.Resource;
import com.hph.finance.resource.ResourceCollapsed;

@Controller
public class IndexController {
	
	@Autowired
	private BankDeRepository bankDeRepository;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody Resource indexGet() {
		
		ResourceCollapsed accountResource = new ResourceCollapsed();
		ResourceCollapsed bankResource = new ResourceCollapsed();
		
		IndexResources indexResources = new IndexResources();
		indexResources.setAccounts(accountResource);
		indexResources.setBanks(bankResource);
		
		IndexResource indexResource = new IndexResource();
		indexResource.setResources(indexResources);
		
		return indexResource;
	}
}
