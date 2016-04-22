package com.hph.finance.controller;

import com.hph.finance.resource.AccountResource;
import com.hph.finance.resource.BankResource;
import com.hph.finance.resource.BankResourceCollapsed;
import de.cpg.oss.blz.Bank;
import de.cpg.oss.blz.BankRepository;
import de.cpg.oss.blz.BlzValidator;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    private final BlzValidator blzValidator;
    private final BankRepository bankRepository;

    @Autowired
    public AccountController(final BlzValidator blzValidator, final BankRepository bankRepository) {
        this.blzValidator = blzValidator;
        this.bankRepository = bankRepository;
    }

    @RequestMapping(value = "/accounts/iban/{iban}", method = RequestMethod.GET)
    public
    @ResponseBody
    AccountResource indexGet(
            @PathVariable("iban") final String ibanString,
            @RequestParam(defaultValue = "false") final boolean expand) {

        final AccountResource resource = new AccountResource();

        final Iban iban = Iban.valueOf(ibanString);
        resource.setIban(iban.toString());
        resource.setValid(true);
        resource.setBank(null);

        if (CountryCode.DE.equals(iban.getCountryCode())) {
            final String bankId = iban.getBankCode();
            final String accountNr = iban.getAccountNumber();
            final Bank bank = bankRepository.findByBankleitzahl(bankId);

            resource.setLocalId(accountNr);
            resource.setValid(blzValidator.validateAccountNr(bankId, accountNr));

            if (expand) {
                final BankResource bankResource = new BankResource();
                bankResource.setBic(bank.getBic());
                bankResource.setName(bank.getBezeichnung());
                bankResource.setCountry(iban.getCountryCode().getAlpha2());
                bankResource.setLocalId(bankId);
                resource.setBank(bankResource);
            } else {
                final BankResourceCollapsed bankResource = new BankResourceCollapsed();
                bankResource.setBic(bank.getBic());
                resource.setBank(bankResource);
            }
        }

        return resource;
    }
}
