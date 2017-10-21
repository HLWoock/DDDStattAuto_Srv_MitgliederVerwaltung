package de.woock.ddd.stattauto.mitgliederverwaltung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DddStattAuto_Srv_MitgliederVerwaltung {

	public static void main(String[] args) {
		SpringApplication.run(DddStattAuto_Srv_MitgliederVerwaltung.class, args);
	}
}
