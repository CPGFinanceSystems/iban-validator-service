package com.hph.finance.controller;

import com.hph.finance.resource.AccountResource;
import com.hph.finance.resource.BankResource;
import com.hph.finance.resource.BankResourceCollapsed;
import de.cpg.oss.blz.Bank;
import de.cpg.oss.blz.BankRepository;
import de.cpg.oss.blz.iban.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    private final IbanValidator ibanValidator;
    private final BankRepository bankRepository;

    @Autowired
    public AccountController(final IbanValidator ibanValidator, final BankRepository bankRepository) {
        this.ibanValidator = ibanValidator;
        this.bankRepository = bankRepository;
    }

    @RequestMapping(value = "/accounts/iban/{iban}", method = RequestMethod.GET)
    public
    @ResponseBody
    AccountResource indexGet(
            @PathVariable("iban") final String ibanString,
            @RequestParam(defaultValue = "false") final boolean expand) throws IbanParseException {

        final AccountResource resource = new AccountResource();

        final Iban iban = Iban.parse(ibanString);
        resource.setIban(iban.toString());
        resource.setValid(ibanValidator.validate(iban));
        resource.setBank(null);

        if (iban.getCountryCode().equals("DE")) {
            final String bankId = IbanUtil.germanBankIdFrom(iban);
            final Bank bank = bankRepository.findByBankleitzahl(bankId);

            resource.setLocalId(IbanUtil.germanAccountIdFrom(iban));

            if (expand) {
                final BankResource bankResource = new BankResource();
                bankResource.setBic(bank.getBic());
                bankResource.setName(bank.getBezeichnung());
                bankResource.setCountry(iban.getCountryCode());
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
