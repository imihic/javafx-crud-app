package hr.java.vjezbe.iznimke;

/**
 * Predstavlja gresku (Exception) koja se pojavljuje ako je cijena stana preniska
 * @author Ivan
 *
 */
public class CijenaJePreniskaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6248593067595978905L;

	public CijenaJePreniskaException() {
	}

	public CijenaJePreniskaException(String message) {
		super(message);
	}

	public CijenaJePreniskaException(Throwable cause) {
		super(cause);
	}

	public CijenaJePreniskaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CijenaJePreniskaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
