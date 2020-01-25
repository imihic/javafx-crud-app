package hr.java.vjezbe.entitet;

import java.io.Serializable;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Predstavlja entitet Stan koji nasljeduje entitet Korisnik, a implementira sucelje Nekretnina. Definiran je naslovom, opisom, cijenom i kvadraturom stana.
 * @author Ivan
 *
 */
public class Stan extends Artikl implements Nekretnina, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -961031128772811695L;
	private Integer kvadratura;
	
	
	public Stan(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje, int kvadratura) {
		super(id, naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
		this.kvadratura = kvadratura;
	}
	
	public Stan(String naslov, String opis, BigDecimal cijena, Stanje stanje, int kvadratura) {
		super(naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
		this.kvadratura = kvadratura;
	}
	public Stan(String naslov, String opis, BigDecimal cijena, Stanje stanje) {
		super(naslov, opis, cijena, stanje);
		this.kvadratura = null;
	}
	public Stan(String naslov, String opis, BigDecimal cijena, int kvadratura, Stanje stanje, long id) {
		// TODO Auto-generated constructor stub
		super(id, naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
		this.kvadratura = kvadratura;
	}

	/**
	 * Vraca podatak o povrsini stana
	 * @return int koji predstavlja iznos povrsine stana u m2
	 */
	public Integer getKvadratura() {
		return this.kvadratura;
	}
	/**
	 * Postavlja atribut kvadratura na parametrom zadanu vrijednost
	 * @param kvadratura oznacava vrijednost na koju kvadratura stana treba biti postavljena
	 */
	public void setKvadratura(int kvadratura) {
		this.kvadratura = kvadratura;
	}

	@Override
	public String tekstOglasa() {
		try {
			return ("Naslov nekretnine: " + Stan.super.getNaslov() + 
					"\n" + "Opis nekretnine: " + Stan.super.getOpis() + 
					"\n" + "Kvadratura nekretnine: " + Stan.this.kvadratura + 
					"\n" + "Stanje nekretnine: " + Stan.this.getStanje() +
					"\n" + "Porez na nekretnine: " + Stan.this.izracunajPorez(Stan.super.getCijena()) + 
					"\n" + "Cijena nekretnine: " + Stan.super.getCijena());
			
		} catch (CijenaJePreniskaException e) {
			logger.info("Cijena ne smije biti manja od 10000kn", e);
			return ("Naslov nekretnine: " + Stan.super.getNaslov() + 
					"\n" + "Opis nekretnine: " + Stan.super.getOpis() + 
					"\n" + "Kvadratura nekretnine: " + Stan.this.kvadratura + 
					"\n" + "Stanje nekretnine: " + Stan.this.getStanje() +
					"\n" + "Porez na nekretnine: Cijena ne smije biti manja od 10000kn"+ 
					"\n" + "Cijena nekretnine: " + Stan.super.getCijena());
		}
	}
	
	@Override
	public String toString() {
		return this.getNaslov() + ", " + this.getOpis() + ", kvadratura: " + this.getKvadratura() + ",cijena: " + this.getCijena() + ",stanje:  " + this.getStanje();
	}
	private static final Logger logger = LoggerFactory.getLogger(Automobil.class);
}
