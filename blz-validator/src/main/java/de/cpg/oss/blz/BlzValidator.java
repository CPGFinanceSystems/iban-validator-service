package de.cpg.oss.blz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

@Component
@Transactional(readOnly = true)
public class BlzValidator {

    private final BankRepository bankRepository;

    @Autowired
    public BlzValidator(final BankRepository bankRepository, final BankImporter bankImporter) {
        this.bankRepository = bankRepository;
        bankImporter.load();
    }

    public boolean validateBlz(final String blz) {
        return bankRepository.findByBankleitzahl(blz)
                .map(Bank::getMerkmal).filter("1"::equals).findFirst().isPresent();
    }

    public boolean validateAccountNr(final String blz, final String accountNr) {
        final Bank bank = bankRepository.findByBankleitzahl(blz).findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        MessageFormat.format("No bank found for BLZ {0}", blz)));

        return ValidatorFactory.factory(bank.getPruefzifferBerechnungsMethode()).isValid(accountNr, blz);
    }
}
