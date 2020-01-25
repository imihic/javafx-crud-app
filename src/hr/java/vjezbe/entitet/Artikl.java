package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet Artikl koji je definiran naslovom, opisom i cijenom.
 * @author Ivan
 *
 */

public abstract class Artikl extends Entitet {
	
	private String naslov;
	private String opis;
	private BigDecimal cijena;
	private Stanje stanje;
	
	public Artikl(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje) {
		super(id);
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}

	public Artikl(String naslov, String opis, BigDecimal cijena, Stanje stanje) {
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((stanje == null) ? 0 : stanje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (stanje != other.stanje)
			return false;
		return true;
	}

	/**
	 * Vraca naslov artikla
	 * @return String koji predstavlja naslov artikla
	 */
	public String getNaslov() {
		return naslov;
	}
	
	/**
	 * Postavlja naslov artikla na zadanu vrijednost
	 * @param naslov predstavlja naslov artikla
	 */
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	/**
	 * Dohvaca opis artikla
	 * @return String koji predstavlja opis artikla
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * Postavlja opis artikla na zadanu vrijednost
	 * @param opis predstavlja opis artikla
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

	/**
	 * Dohvaca cijenu artikla 
	 * @return BigDecimal koji predstavlja cijenu artikla
	 */
	public BigDecimal getCijena() {
		return cijena;
	}
	
	/**
	 * Postavlja cijenu artikla na zadanu vrijednost
	 * @param cijena predstavlja cijenu artikla
	 */

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	
	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	/**
	 * Vraca tekst oglasa spreman za ispis
	 * @return String koji predstavlja tekst oglasa spreman za ispis
	 */
	public abstract String tekstOglasa();
}
