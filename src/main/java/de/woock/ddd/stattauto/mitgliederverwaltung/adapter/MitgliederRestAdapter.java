package de.woock.ddd.stattauto.mitgliederverwaltung.adapter;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.woock.ddd.stattauto.mitgliederverwaltung.entity.Mitglied;
import de.woock.ddd.stattauto.mitgliederverwaltung.service.MitgliederVerwaltungService;


@RestController
@RequestMapping("/Mitglieder")
public class MitgliederRestAdapter {
	
	private static Logger log = Logger.getLogger(MitgliederRestAdapter.class);

	@Autowired private MitgliederVerwaltungService mitgliederService;

	@GetMapping("/{mitgliederId}")
	public Mitglied authentifiziereMitglied(@PathVariable String mitgliederId) {
		log.debug(String.format("Mitglied mit der Id:'%s' vom Server angefordert", mitgliederId));
		return mitgliederService.authentifiziere(mitgliederId);
	}
	
	@GetMapping("/")
	public List<Mitglied> mitgliederListe() {
		return mitgliederService.mitgliederListe();
	}
	
	@GetMapping("/Id/{id}")
	public Mitglied holeMitgliedMitId(@PathVariable Long id) {
		return mitgliederService.holeMitgliedMitId(id);
	}
	
	@GetMapping("/nachfolgendes/{id}")
	public MitgliedResource<Mitglied> holeNachfolgendesMitglied(@PathVariable Long id) {
		Mitglied nachfolgendesMitglied= mitgliederService.holeNachfolgendesMitgliedMitId(id);
		MitgliedResource<Mitglied> resource = new MitgliedResource<>();
		if (nachfolgendesMitglied != null) {
			resource.setMitgliedId(nachfolgendesMitglied.getId());
			resource.setMitgliedsId(nachfolgendesMitglied.getMitgliedsId());
		
			resource.add(linkTo(methodOn(MitgliederRestAdapter.class).holeNachfolgendesMitglied(nachfolgendesMitglied.getId())).slash("nachfolgendes").slash(nachfolgendesMitglied.getId()).withRel("nachfolgendes"));
		}
		resource.add(linkTo(methodOn(MitgliederRestAdapter.class).holeErstestMitglied()).slash("erstes").withRel("erstes"));

		return resource;
	}
	
	@GetMapping("/erstes")
	public MitgliedResource<Mitglied> holeErstestMitglied() {
		Mitglied erstesMitlied = mitgliederService.holeErstesMitlied();
		MitgliedResource<Mitglied> resource = new MitgliedResource<>();
		resource.setMitgliedId(erstesMitlied.getId());
		resource.setMitgliedsId(erstesMitlied.getMitgliedsId());
		
		resource.add(linkTo(methodOn(MitgliederRestAdapter.class).holeErstestMitglied()).slash("erstes").withRel("erstes"));
		resource.add(linkTo(methodOn(MitgliederRestAdapter.class).holeNachfolgendesMitglied(erstesMitlied.getId())).slash("nachfolgendes").slash(erstesMitlied.getId()).withRel("nachfolgendes"));

		return resource;
	}
}
