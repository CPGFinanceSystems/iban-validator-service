package de.cpg.oss.blz;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Integer> {

    @Query("select u from Bank u where u.bankleitzahl = ?1 and u.bic is not null and u.bic != '' group by u.bankleitzahl")
    Bank findByBankleitzahl(String bankleitzahl);
}
