package hr.java.vjezbe.iznimke;

/**
 * Predstavlja gresku koja se javlja prilikom nemogucnosti odredivanja grupe osiguranja
 * @author Ivan
 *
 */
public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {

	private static final long serialVersionUID = 3468972437907945309L;

	public NemoguceOdreditiGrupuOsiguranjaException() {
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message) {
		super(message);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
		super(cause);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
