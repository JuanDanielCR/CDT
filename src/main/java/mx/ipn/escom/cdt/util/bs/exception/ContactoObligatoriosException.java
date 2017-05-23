package mx.ipn.escom.cdt.util.bs.exception;

public class ContactoObligatoriosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum campoObligatorio {

		TIPO_CONTACTO(1), CATEGORIA_CONTACTO(2), EMERGENCIA_CONTACTO(3), EMERGENCIA_RELACION(4), EMAIL_CONTACTO(
				5), CODE_AREA(6), TELEFONO(7);

		private Integer id;

		private campoObligatorio(Integer id) {
			this.id = id;
		}

		public Integer getId() {
			return id;
		}

	}

	private campoObligatorio obligatorio;

	public ContactoObligatoriosException(campoObligatorio obligatorio) {
		super();
		this.obligatorio = obligatorio;
	}

	public ContactoObligatoriosException() {
		super();
	}

	public ContactoObligatoriosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ContactoObligatoriosException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContactoObligatoriosException(String message) {
		super(message);
	}

	public ContactoObligatoriosException(Throwable cause) {
		super(cause);
	}

	public campoObligatorio getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(campoObligatorio obligatorio) {
		this.obligatorio = obligatorio;
	}

}
