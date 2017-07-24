package mx.ipn.escom.cdt.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import mx.ipn.escom.cdt.util.mapeo.Catalogo;

public class Perfil implements Catalogo {
	/**
	 * Identificador del perfil
	 */
	@Id
	@SequenceGenerator(name = "tau01_perfil_id_perfil_seq", sequenceName = "tau01_perfil_id_perfil_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tau01_perfil_id_perfil_seq")
	@Column(name = "id_perfil")
	private Integer id;

	/**
	 * Nombre del perfil
	 */
	@Column(name = "nb_perfil")
	private String nombre;

	/**
	 * Descripción del perfil
	 */
	@Column(name = "ds_perfil")
	private String descripcion;

	/**
	 * Estado del elemento en el catálogo
	 */
	@Column(name = "st_activo")
	private Boolean activo;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * @param activo
	 *            the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
