package hr.java.vjezbe.entitet;

import java.io.Serializable;

/**
 * Predstavlja entitet poslovnog korisnika koji nasljeduje entitet Korisnik, a definiran je email-om, brojem telefona, imenom i prezimenom
 * @author Ivan
 *
 */
public class PrivatniKorisnik extends Korisnik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7487476001851985168L;
	private String ime;
	private String prezime;
	
	
	/**
	 * Stvara novi objekt tipa PrivatniKorisnik sa zadanim parametrima
	 * @param ime predstavlja podatak o imenu korisnika
	 * @param prezime predstavlja podatak o prezimenu korisnika
	 * @param email prestavlja podatak o emailu korisnika
	 * @param telefon predstavlja podatak o broju telefona korisnika
	 */

	public PrivatniKorisnik(Long id, String ime, String prezime, String email, String telefon) {
		super(id, email, telefon);
		this.ime = ime;
		this.prezime = prezime;
	}

	@Override
	public String dohvatiKontakt() {
		//Osobni podaci prodavatelja: Ivan Cesar, mail: icesar@tvz.hr, tel: 220
		return "Osobni podaci prodavatelja: " + this.ime + " " + this.prezime + ", mail: " + getEmail() + ", tel: " + getTelefon();
	}


	/**
	 * Vraca podatak o imenu korisnika
	 * @return String koji predstavlja ime korisnika
	 */
	public String getIme() {
		return ime;
	}


	/**
	 * Postavlja ime korisnika na zadanu vrijednost
	 * @param ime predstavlja vrijednost na koju ce mail korisnika biti postavljen
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}


	/**
	 * Vraca podatak o prezimenu korisnika
	 * @return String koji predstavlja prezime korisnika
	 */
	public String getPrezime() {
		return prezime;
	}


	/**
	 * Postavlja prezime korisnika na zadanu vrijednost
	 * @param prezime predstavlja vrijednost na koju ce mail korisnika biti postavljen
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	@Override
	public String toString() {
		return this.getIme()+ " " + this.getPrezime() + ", email: " + this.getEmail() + ",telefon: " + this.getTelefon();
	}
}
