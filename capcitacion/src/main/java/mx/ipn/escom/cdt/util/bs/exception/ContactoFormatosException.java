package mx.ipn.escom.cdt.util.bs.exception;

public class ContactoFormatosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum ReglaFormato {

		LETRAS_EMERGENCIA(1), MAX_CARACTERES_EMERGENCIA(2), MIN_CARACTERES_EMERGENCIA(3), MAX_CARACTERES_RELACION(
				4), LETRAS_RELACION(5), MIN_CARACTERES_RELACION(6), EMAIL(7), CODEAREA_NUMEROS(
						8), MAX_CARACTERES_CODEAREA(9), MIN_CARACTERES_CODEAREA(
								10), TELEFONO_NUMEROS(11), MAX_NUMEROS_CELULAR(12), MAX_NUMEROS_TELEFONO(
										13), MIN_NUMEROS_CELULAR(14), MAX_NUMEROS_EXTENSION(
												15), EXTENSION_NUMEROS(16), MIN_NUMEROS_EXTENSION(17);

		private Integer id;

		private ReglaFormato(Integer id) {
			this.id = id;
		}

		public Integer getId() {
			return id;
		}
	}

	private ReglaFormato reglaFormato;

	public ContactoFormatosException(ReglaFormato reglaFormato) {
		super();
		this.reglaFormato = reglaFormato;
	}

	public ContactoFormatosException() {
		super();
	}

	public ContactoFormatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ContactoFormatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContactoFormatosException(String message) {
		super(message);
	}

	public ContactoFormatosException(Throwable cause) {
		super(cause);
	}

	public ReglaFormato getReglaFormato() {
		return reglaFormato;
	}

	public void setReglaFormato(ReglaFormato reglaFormato) {
		this.reglaFormato = reglaFormato;
	}

}
