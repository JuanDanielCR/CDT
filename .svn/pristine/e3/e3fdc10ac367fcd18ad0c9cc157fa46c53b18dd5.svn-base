package mx.ipn.escom.cdt.controlacceso.mapeo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * La Cuenta es la entidad que permite determinar si se debe permitir el accesso
 * a un usuario registrado, ya que contiene los periodos de vigencia de los
 * perfiles activos para el usuario.
 * 
 * @author hermes
 *
 */

@Entity
@Table(name = "tau03_cuenta")
public class Cuenta {
	@EmbeddedId
	private CuentaId id;
	/**
	 * Identificador del {@link Usuario} de la cuenta
	 */
	@Column(name = "id_usuario", insertable = false, updatable = false)
	private Integer idUsuario;

	/**
	 * Identificador del {@link Perfil} de la cuenta
	 */
	@Column(name = "id_perfil", insertable = false, updatable = false)
	private Integer idPerfil;

	/**
	 * Identificador de la cuenta
	 */
	@Column(name = "id_cuenta", insertable = false, updatable = false)
	private Integer idCuenta;

	/**
	 * Fecha de inicio del periodo de vigencia de la cuenta
	 */
	@Column(name = "fh_inicio")
	private Date inicio;

	/**
	 * Fecha de fin del periodo de vigencia de la cuenta
	 */
	@Column(name = "fh_fin")
	private Date fin;

	/**
	 * @return the id
	 */
	public CuentaId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(CuentaId id) {
		this.id = id;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the idCuenta
	 */
	public Integer getIdCuenta() {
		return idCuenta;
	}

	/**
	 * @param idCuenta
	 *            the idCuenta to set
	 */
	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	/**
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}
}
