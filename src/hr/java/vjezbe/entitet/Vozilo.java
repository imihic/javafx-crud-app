package hr.java.vjezbe.entitet;

import java.math.BigDecimal;


/**
 * Predstavlja sucelje Vozilo
 * @author Ivan
 */
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;
public interface Vozilo {

	/**
	 * Izracunava vrijednost snage u kilowattima
	 * @param broj predstavlja snagu izrazenu u konjskim snagama
	 * @return BigDecimal koji predstavlja snagu izrazenu u kilowattima
	 */
	public default BigDecimal izracunajKw(BigDecimal broj) {
		BigDecimal koeficijent = new BigDecimal(0.745699872);
		return broj.multiply(koeficijent);
		
	}
	
	/**
	 * Izracunava grupu osiguranja
	 * @return BigDecimal koji predstavlja grupu osiguranja
	 * @throws NemoguceOdreditiGrupuOsiguranjaException u slucaju da je nemoguce odrediti grupu osiguranja
	 */
	public abstract BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;

	/**
	 * Izracunava cijenu osiguranja
	 * @return BigDecimal koji predstavlja cijenu osiguranja izracunatu prema razlicitim grupama osiguranja
	 * @throws NemoguceOdreditiGrupuOsiguranjaException u slucaju da je nemoguce odrediti grupu osiguranja
	 */
	public default BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		switch (izracunajGrupuOsiguranja().intValue()) {
	        case 1:
	            BigDecimal val1=new BigDecimal("1000");
	            return val1;
	        case 2:
	            BigDecimal val2=new BigDecimal("2000");
	            return val2;
	        case 3:
	            BigDecimal val3=new BigDecimal("3000");
	            return val3;
	        case 4:
	            BigDecimal val4=new BigDecimal("4000");
	            return val4;
	        case 5:
	            BigDecimal val5=new BigDecimal("5000");
	            return val5;
			case 6:
		        BigDecimal val6=new BigDecimal("6000");
		        return val6;
		    }
	        return new BigDecimal(0);
	    }		
	}
