package com.hph.finance.data.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hph.finance.data.model.BankDe;

public interface BankDeRepository  extends CrudRepository<BankDe, Long>{

	@Query("select u from BankDe u where u.bankleitzahl = ?1 and u.bic is not null and u.bic != '' group by u.bankleitzahl")
	public BankDe findByBankleitzahl(String bankleitzahl);
}
