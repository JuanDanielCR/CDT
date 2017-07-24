package mx.ipn.escom.cdt.controlacceso.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatrizId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador del {@link Perfil} de usuario
	 */
	@Column(name = "id_perfil", nullable = false)
	private Integer idPerfil;

	/**
	 * Identificador del acceso
	 */
	@Column(name = "id_acceso", nullable = false)
	private Integer idAcceso;

	/**
	 * Constructor por defecto de la llave compuesta
	 */
	public MatrizId() {
		super();
	}

	/**
	 * Constructor de la llave compuesta
	 * 
	 * @param idPerfil
	 * @param idAcceso
	 */
	public MatrizId(Integer idPerfil, Integer idAcceso) {
		super();
		this.idPerfil = idPerfil;
		this.idAcceso = idAcceso;
	}

	/**
	 * @return the idPerfil
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil
	 *            the idPerfil to set
	 */
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * @return the idAcceso
	 */
	public Integer getIdAcceso() {
		return idAcceso;
	}

	/**
	 * @param idAcceso
	 *            the idAcceso to set
	 */
	public void setIdAcceso(Integer idAcceso) {
		this.idAcceso = idAcceso;
	}
}
