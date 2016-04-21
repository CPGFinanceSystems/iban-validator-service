package com.hph.finance.controller;

import com.hph.finance.resource.*;
import de.cpg.oss.blz.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private BankRepository bankDeRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    Resource indexGet() {

        ResourceCollapsed accountResource = new AccountResourceCollapsed();
        ResourceCollapsed bankResource = new BankResourceCollapsed();

        IndexResources indexResources = new IndexResources();
        indexResources.setAccounts(accountResource);
        indexResources.setBanks(bankResource);

        IndexResource indexResource = new IndexResource();
        indexResource.setResources(indexResources);

        return indexResource;
    }
}
