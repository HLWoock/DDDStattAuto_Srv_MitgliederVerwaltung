package de.woock.ddd.stattauto.mitgliederverwaltung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.woock.ddd.stattauto.mitgliederverwaltung.entity.Mitglied;

@Repository
public interface MitgliederRepository extends JpaRepository<Mitglied, Long>{
	
	Mitglied findByMitgliedsId(String mitgliedsId);

	@Query("select min(m.id) from Mitglied m")
	Long findFirstId();

	@Query("select min(m.id) from Mitglied m where m.id > ?1")
	long findNextId(Long id);

}
