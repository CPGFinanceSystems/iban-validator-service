package com.hph.finance.controller;

import com.hph.finance.account.Iban;
import com.hph.finance.account.IbanParseException;
import com.hph.finance.account.ValidatorFactory;
import com.hph.finance.account.iban.IbanDe;
import com.hph.finance.resource.AccountResource;
import com.hph.finance.resource.BankResource;
import com.hph.finance.resource.BankResourceCollapsed;
import de.cpg.oss.blz.Bank;
import de.cpg.oss.blz.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private BankRepository bankDeRepository;

    @RequestMapping(value = "/accounts/iban/{iban}", method = RequestMethod.GET)
    public
    @ResponseBody
    AccountResource indexGet(
            @PathVariable("iban") String iban,
            @RequestParam(defaultValue = "false") boolean expand) {

        AccountResource resource = new AccountResource();

        try {

            Iban validIban = Iban.parse(iban);
            resource.setIban(validIban.toIbanString());
            resource.setValid(true);
            resource.setBank(null);

            if (validIban.getCountry().equals("DE")) {

                IbanDe ibanDe = IbanDe.parse(validIban.toIbanString());
                Bank bankDe = bankDeRepository.findByBankleitzahl(ibanDe.getBankId());

                resource.setLocalId(ibanDe.getAccountId());

                if (ValidatorFactory.factory(bankDe.getPruefzifferBerechnungsMethode())
                        .isValid(ibanDe.getAccountId(), ibanDe.getBankId())) {
                    resource.setVerified(true);
                }

                if (bankDe != null && !expand) {

                    BankResourceCollapsed bankResource = new BankResourceCollapsed();
                    bankResource.setBic(bankDe.getBic());
                    resource.setBank(bankResource);

                } else if (bankDe != null) {

                    BankResource bankResource = new BankResource();
                    bankResource.setBic(bankDe.getBic());
                    bankResource.setName(bankDe.getBezeichnung());
                    bankResource.setCountry(ibanDe.getCountry());
                    bankResource.setLocalId(ibanDe.getBankId());
                    resource.setBank(bankResource);
                }
            }

            return resource;

        } catch (IbanParseException e) {
            return null;
        }
    }
}
