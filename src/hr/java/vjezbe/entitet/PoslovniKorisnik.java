package hr.java.vjezbe.entitet;

import java.io.Serializable;

/**
 * Predstavlja entitet PoslovniKorisnik koji je definiran nazivom, web stranicom, mailom i brojem telefona, a nasljeduje entitet Korisnik
 * @author Ivan
 *
 */
public class PoslovniKorisnik extends Korisnik implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4049249845934863530L;
	private String web;
	private String naziv;
	

	/**
	 * Stvara novi objekt tipa PoslovniKorisnik od zadanih parametara
	 * @param naziv predstavlja naziv tvrtke, tj poslovnog korisnika
	 * @param web oznacava web adresu poslovnog korisnika
	 * @param email predstavlja email korisnika
	 * @param telefon predstavlja broj telefona korisnika
	 */
	public PoslovniKorisnik(Long id, String naziv, String web, String email, String telefon) {
		super(id, email, telefon);
		this.web = web;
		this.naziv = naziv;
	}

	/**
	 * Vraca web adresu poslovnog korisnika
	 * @return String koji predstavlja web adresu korisnika
	 */
	public String getWeb() {
		return this.web;
	}

	/**
	 * Postavlja atribut web adrese na vrijednost zadanu parametrom
	 * @param web oznacava String na koji atribut web adrese treba biti postavljen
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * Vraca naziv poslovnog korisnika
	 * @return String koji predstavlja naziv korisnika
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja atribut naziva poslovnog korisnika na vrijednost zadanu parametrom
	 * @param naziv oznacava String na koji ce atribut naziva biti postavljen
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	@Override
	public String dohvatiKontakt() {
		//Naziv tvrtke: TVZ, mail: tvz@tvz.hr, tel: 01/5603900, web: www.tvz.hr
		// TODO Auto-generated method stub
		return "Naziv tvrtke: " + this.naziv + ", mail: " + getEmail() + ", tel: " + getTelefon() + ", web: " + this.web;
	}
	
	@Override
	public String toString() {
		return this.getTelefon()+ "web: " + this.getNaziv() + ", email: " + this.getEmail() + ",telefon: " + this.getNaziv();
	}
}
