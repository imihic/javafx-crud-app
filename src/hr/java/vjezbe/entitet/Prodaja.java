package hr.java.vjezbe.entitet;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Predstavlja entitet Prodaja, definiran atributima artikl tipa Artikl, korisnik tipa Korisnik i datumObjave tipa LocalDate
 * @author Ivan
 *
 */

public class Prodaja implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4745449514149858034L;
	private Artikl artikl;
	private Korisnik korisnik;
	private LocalDate datumObjave;
	
	/**
	 * Kreira novi objekt tipa Prodaja sa zadanim parametrima
	 * @param artikl predstavlja artikl koji se prodaje
	 * @param korisnik predstavlja podatak o korisniku koji prodaje artikl
	 * @param datumObjave predstavlja podatak o datumu objavljivanja oglasa
	 */
	public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
		super();
		this.artikl = artikl;
		this.korisnik = korisnik;
		this.datumObjave = datumObjave;
	}
	
	/**
	 * Vraca podatak o artiklu koji se prodaje
	 * @return Artikl koji je na prodaju
	 */
	public Artikl getArtikl() {
		return artikl;
	}

	/**
	 * Postavlja artikl prodaje na zadanu vrijednost
	 * @param artikl predstavlja vrijednost na koju ce artikl biti postavljen
	 */
	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}
	
	/**
	 * Vraca podatak o korisniku koji prodaje artikl
	 * @return Korisnik koji predstavlja podatak o korisniku
	 */
	public Korisnik getKorisnik() {
		return korisnik;
	}

	/**
	 * Postavlja podatak o korisniku koji prodaje artikl
	 * @param korisnik predstavlja korisnika koji prodaje artikl
	 */
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	/**
	 * Vraca podatak o datumu objave
	 * @return LocalDate koji predstavlja datum objave oglasa
	 */
	public LocalDate getDatumObjave() {
		return datumObjave;
	}
	
	/**
	 * Postavlja datum objave oglasa na zadanu vrijednost
	 * @param datumObjave predstavlja vrijednost na koju ce mail datum objave biti postavljen
	 */
	public void setDatumObjave(LocalDate datumObjave) {
		this.datumObjave = datumObjave;
	}
	
	
	
}
