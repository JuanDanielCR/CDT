package mx.ipn.escom.cdt.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table
public class Matriz implements Modelo {
	/**
	 * Identificador compuesto del acceso
	 */
	@EmbeddedId
	private MatrizId id;
	/**
	 * Identificador del {@link Perfil} de usuario
	 */
	@Column(name = "id_perfil", insertable = false, updatable = false)
	private Integer idPerfil;

	/**
	 * Identificador del acceso
	 */
	@Column(name = "id_acceso", insertable = false, updatable = false)
	private Integer idAcceso;

	/**
	 * Url del caso de uso
	 */
	@Column(name = "tx_url")
	private String url;

	/**
	 * Indica si está permitido el acceso al perfil espeficado por idPerfil a la
	 * url dada en url.
	 */
	@Column(name = "st_permitido")
	private Boolean permitido;

	/**
	 * @return the id
	 */
	public MatrizId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(MatrizId id) {
		this.id = id;
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

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the permitido
	 */
	public Boolean getPermitido() {
		return permitido;
	}

	/**
	 * @param permitido
	 *            the permitido to set
	 */
	public void setPermitido(Boolean permitido) {
		this.permitido = permitido;
	}
}
