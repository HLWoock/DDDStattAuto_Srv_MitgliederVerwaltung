package de.woock.ddd.stattauto.mitgliederverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.woock.ddd.stattauto.mitgliederverwaltung.entity.Mitglied;
import de.woock.ddd.stattauto.mitgliederverwaltung.entity.MitgliederKartei;

@Service
public class MitgliederVerwaltungService {
	
	@Autowired private MitgliederKartei mitgliederKartei;

	public Mitglied authentifiziere(String mitgliederId) {
		return mitgliederKartei.authentifiziereMitglied(mitgliederId);
	}

	public List<Mitglied> mitgliederListe() {
		return mitgliederKartei.mitgliederListe();
	}

	public Mitglied holeMitgliedMitId(Long id) {
		return mitgliederKartei.holeMitgliedMitId(id);
	}

	public Mitglied holeErstesMitlied() {
		return mitgliederKartei.holeErstesMitglied();
	}

	public Mitglied holeNachfolgendesMitgliedMitId(Long id) {
		return mitgliederKartei.holeNachfolgendesMitgliedMitId(id);
	}

}
