package de.woock.ddd.stattauto.mitgliederverwaltung.entity;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Mitglied {

	@Id
	@GeneratedValue
	private Long id;
	private VollerName vollerName;
	private String     mitgliedsId;
	private String     password;
	private Adresse    adresse;
	private String     geburtsdatum;
	private Telefon    telefon;
	
	public Mitglied() {}
	
	public Mitglied(VollerName vollerName, String mitgliedsId, Adresse adresse, Temporal geburtsdatum, Telefon telefon) {
		this.vollerName   = vollerName;
		this.geburtsdatum = geburtsdatum.toString();
		this.mitgliedsId  = String.valueOf(vollerName.getVorname().charAt(0)) + vollerName.getName().toLowerCase()
				          + adresse.getStrasse().substring(0, 2) + adresse.getNr();
		this.password     = vollerName.getVorname();
		this.adresse      = adresse;
		this.telefon      = telefon;
	}
	
	public List<Reservierung> ermittleReservierungen(int year, int month) {
		return new ArrayList<Reservierung>();
	}
}
