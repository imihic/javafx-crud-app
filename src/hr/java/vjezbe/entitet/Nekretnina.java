package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
 /**
  * Sucelje koje predstavlja nekretninu
  * @author Ivan
  *
  */
public interface Nekretnina {
	
	/**
	 * Izracunava porez koji je potreban platiti za parametrom proslijedenu cijenu nekretnine
	 * @param cijena predstavlja cijenu nekretnine za koju se izracunava porez
	 * @return BigDecimal koji predstavlja podatak o izracunatom porezu
	 * @throws CijenaJePreniskaException ako je cijena nekretnina manja od 10000
	 */
	default BigDecimal izracunajPorez(BigDecimal cijena) throws CijenaJePreniskaException {
		BigDecimal porez = cijena;
		if(cijena.compareTo(new BigDecimal(10000)) == -1) {
			throw new CijenaJePreniskaException();
		}
		porez.multiply(new BigDecimal(3)).divide(new BigDecimal(100));
		return porez;
	}
}
