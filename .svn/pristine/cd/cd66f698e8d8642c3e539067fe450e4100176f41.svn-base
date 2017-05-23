package mx.ipn.escom.cdt.controlacceso.mapeo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

/**
 * Contiene la información de acceso de un {@link Usuario} con base en la cual
 * se determina si la cuenta está bloqueada por intentos fallidos.
 * 
 * @author hermes
 *
 */
@Entity
@Table(name = "tau04_acceso")
public class Acceso implements Modelo{
	/**
	 * Identificador del {@Link Usuario}
	 */
	@Id
	@Column(name = "id_usuario")
	private Integer idUsuario;

	/**
	 * Número de intentos fallidos consecutivos del usuario
	 */
	@Column(name = "nu_intento")
	private Integer intentos;

	/**
	 * Fecha y hora del último intento fallido
	 */
	@Column(name = "fh_intento")
	private Date intento;

	/**
	 * Fecha de bloqueo
	 */
	@Column(name = "fh_bloqueo")
	private Date bloqueo;

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the intentos
	 */
	public Integer getIntentos() {
		return intentos;
	}

	/**
	 * @param intentos the intentos to set
	 */
	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	/**
	 * @return the intento
	 */
	public Date getIntento() {
		return intento;
	}

	/**
	 * @param intento the intento to set
	 */
	public void setIntento(Date intento) {
		this.intento = intento;
	}

	/**
	 * @return the bloqueo
	 */
	public Date getBloqueo() {
		return bloqueo;
	}

	/**
	 * @param bloqueo the bloqueo to set
	 */
	public void setBloqueo(Date bloqueo) {
		this.bloqueo = bloqueo;
	}
}
