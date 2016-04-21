package de.cpg.oss.blz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bankleitzahl;
    private String merkmal;
    private String bezeichnung;
    private String plz;
    private String ort;
    private String kurzbezeichnung;
    private String pan;
    private String bic;
    private String pruefzifferBerechnungsMethode;
    @Id
    private int datensatzNummer;
    private String aenderungsKennzeichen;
    private String bankleitzahlLoeschung;
    private String nachfolgeBankleitzahl;
}
