package hr.java.vjezbe.entitet;

import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja entitet Kategorija koji je definiran nazivom i nizom objekata tipa Artikl
 * @author Ivan
 * @param <T>
 *
 */
public class Kategorija<T extends Artikl> {
	long id;
	private String naziv;
	private List<T> artikli;
	

	/**
	 * Stvara novi objekt tipa Kategorija od zadanih parametara
	 * @param <T>
	 * @param naziv predstavlja podatak o nazivu kategorije
	 * @param artikli2 predstavlja podatak o nizu artikala koje entitet Kategorija sadrzava
	 */
	public Kategorija(String naziv) {
		super();
		this.naziv = naziv;
		this.artikli =  new ArrayList<>();
	}
	public Kategorija(long id, String naziv, List<T> artikli) {
		this.id = id;
		this.naziv = naziv;
		this.artikli =  artikli;
	}

	/**
	 * Vraca podatak o nazivu kategorije
	 * @return String koji predstavlja naziv kategorije
	 */
	public String getNaziv() {
		return naziv;
	}
	
	/**
	 * Postavlja naslov artikla na zadanu vrijednost
	 * @param naslov predstavlja vrijednost na koju ce podatak o naslovu artikla biti postavljen
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void dodajArtikl(T artikl) {
		this.artikli.add(artikl);
	}
	
	public T dohvatiArtikl(int index) {
		return this.artikli.get(index);
	}
	
	public List<T> dohvatiListu() {
		return this.artikli;
	}
}
