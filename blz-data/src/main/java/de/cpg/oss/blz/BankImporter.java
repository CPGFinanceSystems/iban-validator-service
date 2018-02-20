package de.cpg.oss.blz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@Component
public class BankImporter implements ResourceLoaderAware {

    private final static String URL = "http://www.bundesbank.de/Redaktion/DE/Downloads/Aufgaben/Unbarer_Zahlungsverkehr/Bankleitzahlen/2018_06_03/blz_2018_03_05_txt.txt?__blob=publicationFile";

    private ResourceLoader resourceLoader;

    private final BankRepository bankRepository;

    @Autowired
    public BankImporter(final BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    private void fetchToTmpFile(final String sourcePath, final String tmpPath) throws IOException {

        try {
            Files.deleteIfExists(new File(tmpPath).toPath());
        } catch (final IOException e) {
            log.error("Could not delete tmp file!", e);
        }

        final Resource resource = resourceLoader.getResource(sourcePath);
        final InputStream inputStream = resource.getInputStream();
        final FileOutputStream file = new FileOutputStream(tmpPath);

        int i = inputStream.read();
        while (i != -1) {
            file.write(i);
            i = inputStream.read();
        }

        inputStream.close();
        file.close();
    }

    private List<String> fetchLines(final String sourcePath, final String tmpPath) throws IOException {

        fetchToTmpFile(sourcePath, tmpPath);

        final File file = new File(tmpPath);
        final List<String> lines = Files.readAllLines(file.toPath(),
                Charset.forName("ISO-8859-1"));
        file.delete();
        return lines;
    }

    public void load() {

        if (bankRepository.count() == 0) {
            log.info("Importing bankcode file from ".concat(URL).concat("..."));

            final List<String> lines;
            try {
                lines = fetchLines(URL, "finance.import.tmp");
            } catch (final IOException e) {
                log.error("Could not read bankcode file from german central bank!", e);
                throw new RuntimeException(e);
            }

            lines.stream().filter(line -> line != null && !line.equals("")).forEach(line -> {
                final Bank bank = new Bank();

                bank.setBankleitzahl(line.substring(0, 8));
                bank.setMerkmal(line.substring(8, 9));
                bank.setBezeichnung(line.substring(9, 67).trim());
                bank.setPlz(line.substring(67, 72));
                bank.setOrt(line.substring(72, 107).trim());
                bank.setKurzbezeichnung(line.substring(107, 134).trim());
                bank.setPan(line.substring(134, 139));
                bank.setBic(line.substring(139, 150).trim());
                bank.setPruefzifferBerechnungsMethode(line.substring(150, 152));
                bank.setDatensatzNummer(Integer.valueOf(line.substring(152, 158).trim()));
                bank.setAenderungsKennzeichen(line.substring(158, 159));
                bank.setBankleitzahlLoeschung(line.substring(159, 160));
                bank.setNachfolgeBankleitzahl(line.substring(160, 168));

                bankRepository.save(bank);
            });
            log.info("Imported {} entries", bankRepository.count());
        }
    }

    @Override
    public void setResourceLoader(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}