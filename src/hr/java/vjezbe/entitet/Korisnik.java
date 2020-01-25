package hr.java.vjezbe.entitet;

/**
 * Predstavlja entitet Korisnik koji je definiran email-om i brojem telefona
 * @author Ivan
 *
 */
public abstract class Korisnik extends Entitet {
	private String email;
	private String telefon;
	
	/**
	 * Stvara novi objekt tipa Korisnik od zadanih parametara
	 * @param email predstavlja email korisnika
	 * @param telefon predstavlja broj telefona korisnika
	 */
	public Korisnik(String email, String telefon) {
		super();
		this.email = email;
		this.telefon = telefon;
	}

	public Korisnik(Long id, String email2, String telefon2) {
		super(id);
		this.email = email2;
		this.telefon = telefon2;
	}

	/**
	 * Vraca podatak o mailu korisnika
	 * @return String koji predstavlja mail korisnika
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Postavlja mail korisnika na zadanu vrijednost
	 * @param email predstavlja vrijednost na koju ce mail korisnika biti postavljen
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Vraca podatak o telefonu korisnika
	 * @return String koji predstavlja podatak o telefonu korisnika
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Postavlja telefon korisnika na zadanu vrijednost
	 * @param telefon predstavlja vrijednost na koju ce biti postavljen broj telefona korisnika
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	/**
	 * Vraca tekstualni oblik objekta spreman za ispis
	 * @return String koji predstavlja kontakt Korisnika 
	 */
	public abstract String dohvatiKontakt();
	
}
