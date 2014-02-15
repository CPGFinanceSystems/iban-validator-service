package com.hph.finance.data;

import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.hph.finance.data.service.BankDeRepository;

@Component("bankDeImporter")
public class BankDeImporter implements Importer, ResourceLoaderAware {

	private Logger logger = Logger.getLogger(getClass().getName()); 
	
	private String path = "http://www.bundesbank.de/Redaktion/DE/Downloads/Aufgaben/Unbarer_Zahlungsverkehr/Bankleitzahlen/2014_06_08/blz_2014_03_03_txt.txt?__blob=publicationFile";

	private ResourceLoader resourceLoader;
	
	@Autowired
	private BankDeRepository bankDeRepository;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String latin1ToUtf8(String str) {
		
		try {
			return new String(str.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	@Override
	// @PostConstruct
	public void load() {
		
		/*
		if(bankDeRepository.count() == 0) {
		
			try {
				
				Resource resource = resourceLoader.getResource(path);
				InputStream inputStream = resource.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
				
				String line = bufferedReader.readLine();
				while(line != null) {
					
					BankDe bank = new BankDe();
					
					line = line.trim();
					
					if(!line.equals("")) {
						
						bank.setBankleitzahl(Validator.extract(line, 1, 8).trim());
						bank.setMerkmal(Validator.extract(line, 9).trim());
						bank.setBezeichnung(latin1ToUtf8(Validator.extract(line, 10, 67).trim()));
						bank.setPlz(Validator.extract(line, 68, 72).trim());
						bank.setOrt(latin1ToUtf8(Validator.extract(line, 73, 107).trim()));
						bank.setKurzbezeichnung(latin1ToUtf8(Validator.extract(line, 108, 134).trim()));
						bank.setPan(Validator.extract(line, 135, 139).trim());
						bank.setBic(Validator.extract(line, 140, 150).trim());
						bank.setPruefzifferBerechnungsMethode(Validator.extract(line, 151, 152).trim());
						bank.setDatensatzNummer(Validator.extract(line, 153, 158).trim());
						bank.setAenderungsKennzeichen(Validator.extract(line, 159).trim());
						bank.setBankleitzahlLoeschung(Validator.extract(line, 160).trim());
						bank.setNachfolgeBankleitzahl(Validator.extract(line, 161, 168).trim());

						bankDeRepository.save(bank);
						
						logger.info(bank);
					}
					
					line = bufferedReader.readLine();
				}
				
				bufferedReader.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		*/
	}

	@Override
	public void setResourceLoader(ResourceLoader rl) {
		this.resourceLoader = rl;
	}
}