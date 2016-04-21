package de.cpg.oss.blz.iban;

import de.cpg.oss.blz.Bank;
import de.cpg.oss.blz.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class IbanValidator {

    private final BankRepository bankRepository;

    @Autowired
    public IbanValidator(final BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public boolean validate(final String ibanString) throws IbanParseException {
        return validate(Iban.parse(ibanString));
    }

    public boolean validate(final Iban iban) {
        if ("DE".equals(iban.getCountryCode())) {
            final String bankId = IbanUtil.germanBankIdFrom(iban);
            final String accountId = IbanUtil.germanAccountIdFrom(iban);

            final Bank bank = Optional.ofNullable(bankRepository.findByBankleitzahl(bankId))
                    .orElseThrow(() -> new NoSuchElementException(
                            MessageFormat.format("No bank found for german bank ID {0}", bankId)));

            return ValidatorFactory.factory(bank.getPruefzifferBerechnungsMethode()).isValid(accountId, bankId);
        }

        return true;
    }
}
