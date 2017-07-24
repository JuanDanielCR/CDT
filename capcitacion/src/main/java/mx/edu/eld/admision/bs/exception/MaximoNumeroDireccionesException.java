package mx.edu.eld.admision.bs.exception;

public class MaximoNumeroDireccionesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum DireccionFueraRangoEnum {
		MAX_DIRECCIONES(1), ESTADO(2), OAXACA_ESTADO(3), DURANGO_ESTADO(4), PUEBLA_ESTADO(5);

		private Integer id;

		private DireccionFueraRangoEnum(Integer id) {
			this.id = id;
		}

		public Integer getId() {
			return id;
		}
	}
	
	private DireccionFueraRangoEnum causa;
	

	public MaximoNumeroDireccionesException(DireccionFueraRangoEnum causa) {
		super();
		this.causa = causa;
	}

	public DireccionFueraRangoEnum getCausa() {
		return causa;
	}

	public void setCausa(DireccionFueraRangoEnum causa) {
		this.causa = causa;
	}

	public MaximoNumeroDireccionesException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaximoNumeroDireccionesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MaximoNumeroDireccionesException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MaximoNumeroDireccionesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MaximoNumeroDireccionesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
