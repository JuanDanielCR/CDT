package mx.ipn.escom.cdt.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mx.edu.eld.informacionbase.mapeo.Persona;

/**
 * Las personas registradas catalogadas como Usuarios son aquellas personas que
 * podrán ingresar al sistema mediante un mecanismo de autenticación basado en
 * usuario y contraseña.
 * 
 * @author hermes
 *
 */

@Entity
@Table(name = "tau02_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id_usuario", referencedColumnName = "id_persona")
public class Usuario extends Persona {
	/**
	 * Correo electrónico designado como lógin del usuario.
	 */
	@Column(name = "tx_login")
	private String login;

	/**
	 * Contraseña de acceso para el usuario
	 */
	@Column(name = "tx_password")
	private String password;

	/**
	 * Constructor por defecto de un usuario
	 */
	public Usuario() {
		super();
	}

	/**
	 * Constructor de un usuario con base en un login
	 * 
	 * @param login
	 */
	public Usuario(String login) {
		super();
		this.login = login;
	}

	/**
	 * Constructor de un usuario con base en su login y su contraseña
	 * 
	 * @param login
	 * @param password
	 */
	public Usuario(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
