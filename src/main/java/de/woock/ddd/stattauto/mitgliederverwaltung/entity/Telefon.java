package de.woock.ddd.stattauto.mitgliederverwaltung.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Telefon {
	
	private String festnetz;
	private String mobil;
	
	public Telefon () {}
	
	public Telefon (String festnetz, String mobil) {
		this.festnetz = festnetz;
		this.mobil    = mobil;
	}
	
	public enum VorwahlenMobil {
		telecom1("0151"), telecom2("0160"), telecom3("0170"), telecom4("0171"), telecom5("0175"),
		vodavone1("0152"), vodavone2("0162"),vodavone3("0172"),vodavone4("0173"),vodavone5("0174"),
		Base1("0155"), Base2("0157"), Base3("0161"), Base4("0163"), Base5("0164"), Base6("0177"), Base7("0178"),   
		O21("0159"), O22("0176"), O23("0179");

		public String vorwahl;
		
		VorwahlenMobil(String vorwahl) {
			this.vorwahl = vorwahl;
		}
	}
	
	public enum VorwahlenFestnetz {
		Hamburg("040"), Bremen("0421"), L�beck("0451"), Stade("04141"), Kiel("0431"), Reinbeck("040"), 
		L�neburg("04131"), Pinneberg("04101"), Buchholz("04181");
		
		public String vorwahl;
		private VorwahlenFestnetz(String vorwahl) {
			this.vorwahl = vorwahl;
		}
	}
}
