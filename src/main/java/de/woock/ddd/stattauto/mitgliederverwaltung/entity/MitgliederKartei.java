package de.woock.ddd.stattauto.mitgliederverwaltung.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.woock.ddd.stattauto.mitgliederverwaltung.repository.MitgliederRepository;

@Service
public class MitgliederKartei {
	
	@Autowired
	MitgliederRepository mitgliederRepository;
	

	public Mitglied authentifiziereMitglied(String mitgliedsId) {
		return  mitgliederRepository.findByMitgliedsId(mitgliedsId);
	}
	
	public List<Mitglied> mitgliederListe() {
		return mitgliederRepository.findAll();
	}

	public Mitglied holeMitgliedMitId(Long id) {
		return mitgliederRepository.findOne(id);
	}
	
	public Mitglied holeErstesMitglied() {
		return mitgliederRepository.findOne(mitgliederRepository.findFirstId());
	}
	
	public Mitglied holeNachfolgendesMitgliedMitId(Long id) {
		Mitglied mitglied = null;
		try {
			mitglied = mitgliederRepository.findOne(mitgliederRepository.findNextId(id));
		} catch (Exception ex) {
		}
		return mitglied;
	}
	
	public void mitgliedAufnehmen(Mitglied mitglied) {
		mitgliederRepository.save(mitglied);
	}

}
