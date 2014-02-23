package com.hph.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hph.finance.data.service.BankDeRepository;

public class BankController {

	@Autowired
	private BankDeRepository bankDeRepository;
}
