package de.cpg.oss.blz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class BlzValidator {

    private final BankRepository bankRepository;

    @Autowired
    public BlzValidator(final BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public boolean validateBlz(final String blz) {
        return Optional.ofNullable(bankRepository.findByBankleitzahl(blz))
                .map(Bank::getMerkmal).filter("1"::equals).isPresent();
    }

    public boolean validateAccountNr(final String blz, final String accountNr) {
        final Bank bank = Optional.ofNullable(bankRepository.findByBankleitzahl(blz))
                .orElseThrow(() -> new NoSuchElementException(
                        MessageFormat.format("No bank found for BLZ {0}", blz)));

        return ValidatorFactory.factory(bank.getPruefzifferBerechnungsMethode()).isValid(accountNr, blz);
    }
}
