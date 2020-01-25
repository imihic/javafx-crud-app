package hr.java.vjezbe.entitet;

import java.io.Serializable;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Predstavlja entitet Automobil koji nasljeduje klasu Artikl, a implementira sucelje Vozilo, te je definiran naslovom, opisom, cijenom i snagom (izrazenom u Ks)
 * @author Ivan
 *
 */
public class Automobil extends Artikl implements Vozilo, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6831379070711788902L;
	private BigDecimal snagaKs;
	

	public Automobil(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal snaga) {
		super(id, naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
		this.snagaKs = snaga;
	}

	public Automobil(String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal snaga) {
		super(naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
		this.snagaKs = snaga;
	}

	public Automobil(String naslov, String opis, BigDecimal cijena, BigDecimal snaga, Stanje stanje,
			long id) {
		super(id, naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
		this.snagaKs = snaga;
	}

	/**
	 * Vraca snagu automobila u konjskim snagama
	 * @return BigDecimal koji predstavlja snagu automobila izraženu u konjskim snagama
	 */
	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	/**
	 * Postavlja snagu automobila u konjskim snagama na parametrom zadanu vrijednost
	 * @param snagaKS predstavlja vrijednost na koju ce snaga objekta Automobil biti postavljena
	 */
	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}

	@Override
	public BigDecimal izracunajGrupuOsiguranja() {
		if(this.snagaKs.compareTo(new BigDecimal(100)) == -1) {
			return new BigDecimal(1);
		} else if(this.snagaKs.compareTo(new BigDecimal(200)) == -1) {
			return new BigDecimal(2);
		}
		else if(this.snagaKs.compareTo(new BigDecimal(300)) == -1) {
			return new BigDecimal(3);
		}
		else if(this.snagaKs.compareTo(new BigDecimal(400)) == -1) {
			return new BigDecimal(4);
		}
		else if(this.snagaKs.compareTo(new BigDecimal(500)) == -1) {
			return new BigDecimal(5);
		}
		else if(this.snagaKs.compareTo(new BigDecimal(200)) == -1) {
			return new BigDecimal(6);
		}
		return new BigDecimal(0);
	}

	@Override
	public String tekstOglasa() {
		try {
			if(this.izracunajKw(getSnagaKs()).compareTo(new BigDecimal(180)) == 1) {
				throw new NemoguceOdreditiGrupuOsiguranjaException();
			}
			return ("Naslov automobila: " + Automobil.super.getNaslov() + 
					"\n" + "Opis automobila: " + Automobil.super.getOpis() + 
					"\n" + "Snaga automobila: " + Automobil.this.snagaKs + 
					"\n" + "Stanje automobila: " + Automobil.this.getStanje() + 
					"\n" + "Izracun osiguranja automobila: " + Automobil.this.izracunajCijenuOsiguranja() + 
					"\n" + "Cijena automobila: " + Automobil.super.getCijena());
			
		} catch (NemoguceOdreditiGrupuOsiguranjaException e) {
			logger.info("Previše kw, ne mogu odrediti grupu osiguranja.", e);
			return ("Naslov automobila: " + Automobil.super.getNaslov() + 
					"\n" + "Opis automobila: " + Automobil.super.getOpis() + 
					"\n" + "Snaga automobila: " + Automobil.this.snagaKs + 
					"\n" + "Stanje automobila: " + Automobil.this.getStanje() +
					"\n" + "Izracun osiguranja automobila: Previše kw, ne mogu odrediti grupu osiguranja." + 
					"\n" + "Cijena automobila: " + Automobil.super.getCijena());
		}
	}
	@Override
	public String toString() {
		return this.getNaslov() + ", " + this.getOpis() + ", snaga: " + this.getSnagaKs() + ",cijena: " + this.getCijena() + ",stanje:  " + this.getStanje();
	}
	private static final Logger logger = LoggerFactory.getLogger(Automobil.class);

}
