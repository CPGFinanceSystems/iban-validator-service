package com.hph.finance.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.hph.finance.account.Validator;
import com.hph.finance.data.model.BankDe;
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
	
	public void fetchToTmpFile(String sourcePath, String tmpPath) {
		
		try {
			Files.deleteIfExists(new File(tmpPath).toPath());
		} catch (IOException e1) {
			logger.error("Could not delete tmp file!");
		}
		
		Resource resource = resourceLoader.getResource(sourcePath);
		InputStream inputStream;
		try {
			
			inputStream = resource.getInputStream();
			FileOutputStream file = new FileOutputStream(tmpPath);
			
			int i = inputStream.read();
			while(i != -1) {
				file.write(i);
				i = inputStream.read();
			}
			
			inputStream.close();
			file.close();
			
		} catch (IOException e) {
			logger.error("Could not fetch to temp file!");
		}

		
	}
	
	public List<String> fetchLines(String sourcePath, String tmpPath) {
		
		fetchToTmpFile(sourcePath, tmpPath);
		
		File file = new File(tmpPath);
		try {
			List<String> lines = Files.readAllLines(file.toPath(), 
					Charset.forName("ISO-8859-1"));
			file.delete();
			return lines;
		} catch (IOException e) {
			logger.error("Could not fetch lines!");
			return null;
		}
	}
	
	@Override
	@PostConstruct
	public void load() {
		
		if(bankDeRepository.count() == 0) {
		
			List<String> lines = fetchLines(path, "finance.import.tmp");
			
			String line = "";
			for(int i=0; i < lines.size(); i++) {
				
				line = lines.get(i);
				
				if(!line.equals("") && line != null) {
			
					line = line.trim();
					
					BankDe bank = new BankDe();
					
					bank.setBankleitzahl(Validator.extract(line, 1, 8).trim());
					bank.setMerkmal(Validator.extract(line, 9).trim());
					bank.setBezeichnung(Validator.extract(line, 10, 67).trim());
					bank.setPlz(Validator.extract(line, 68, 72).trim());
					bank.setOrt(Validator.extract(line, 73, 107).trim());
					bank.setKurzbezeichnung(Validator.extract(line, 108, 134).trim());
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
			}
		}		
	}

	@Override
	public void setResourceLoader(ResourceLoader rl) {
		this.resourceLoader = rl;
	}
}