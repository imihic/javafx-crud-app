package hr.java.vjezbe.entitet;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Oznacava entitet Usluga koji nasljeduje entitet Artikl, a definiran je naslovom, opisom i cijenom.
 * @author Ivan
 *
 */
public class Usluga extends Artikl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7746672776910487825L;


	/**
	 * Stvara novi objekt tipa Usluga sa zadanim parametrima
	 * @param naslov oznacava naslov objekta
	 * @param opis oznacava opis usluge
	 * @param cijena oznacava cijenu usluge
	 */
	public Usluga(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje) {
		super(id, naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
	}
	
	public Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje) {
		super(naslov, opis, cijena, stanje);
		// TODO Auto-generated constructor stub
	}


	public Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje, long id) {
		super(id, naslov, opis, cijena, stanje);
	}

	@Override
	public String tekstOglasa() {
		return ("Naslov: " + Usluga.super.getNaslov() + "\n" + "Opis: " + Usluga.super.getOpis() + "\n" + "Cijena: " + Usluga.super.getCijena() + "\n" + "Stanje: " + Usluga.super.getStanje());
	}
	@Override
	public String toString() {
		return this.getNaslov() + ", " + this.getOpis() + ",cijena: " + this.getCijena() + ",stanje:  " + this.getStanje();
	}
}
