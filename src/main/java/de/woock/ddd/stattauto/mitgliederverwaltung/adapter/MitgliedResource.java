package de.woock.ddd.stattauto.mitgliederverwaltung.adapter;

import org.springframework.hateoas.ResourceSupport;

import de.woock.ddd.stattauto.mitgliederverwaltung.entity.Adresse;
import de.woock.ddd.stattauto.mitgliederverwaltung.entity.Telefon;
import de.woock.ddd.stattauto.mitgliederverwaltung.entity.VollerName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MitgliedResource<Mitglied> extends ResourceSupport {
	private Long       mitgliedId;
	private VollerName vollerName;
	private String     mitgliedsId;
	private String     password;
	private Adresse    adresse;
	private String     geburtsdatum;
	private Telefon    telefon;
}
