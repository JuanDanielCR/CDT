package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad19_aspirante_direccion")
public class AspiranteDireccion implements Modelo{
	@EmbeddedId
	private AspiranteDireccionId id;
	/*
	 * atributos insertable, y updatable en false para 
	 * usarlos solo como un ahorro de una referecncia a id
	 * 
	 * Ej. Sin los attr insertable | updatable: 
	 * 	   	AspiranteDireccion a = new AspiranteDIreccion()
	 *     	a.getId().getIdTipo();
	 *     Con los attr: 
	 *     	a.getIdTipo()
	 * Ej. Guardar un attr. al usar insertable = false, updatable = false
	 * 		a.setId(new AspiranteDireccionId(idTipo, idDireccion,idAspirante))
	 * */
	@Column(name="id_tipo",insertable=false, updatable=false)
	private Integer idTipo;
	@Column(name="id_direccion",insertable=false, updatable=false)
	private Integer idDireccion;
	@Column(name="id_aspirante",insertable=false, updatable=false)
	private Integer idAspirante;
	
	
	public AspiranteDireccion() {
		super();
	}
	
	
	public AspiranteDireccion(AspiranteDireccionId id, Integer idTipo, Integer idDireccion, Integer idAspirante) {
		super();
		this.id = id;
		this.idTipo = idTipo;
		this.idDireccion = idDireccion;
		this.idAspirante = idAspirante;
	}


	public AspiranteDireccionId getId() {
		return id;
	}

	public void setId(AspiranteDireccionId id) {
		this.id = id;
	}
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Integer getIdAspirante() {
		return idAspirante;
	}

	public void setIdAspirante(Integer idAspirante) {
		this.idAspirante = idAspirante;
	}

	@Override
	public String toString() {
		return "AspiranteDireccion [id=" + id + "]";
	}
	
	
}
