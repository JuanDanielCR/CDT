package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class AspiranteDireccionId implements Serializable{

	private static final long serialVersionUID = -5661803307739076320L;
	@Column(name="id_tipo")
	private Integer idTipo;
	@Column(name="id_direccion")
	private Integer idDireccion;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	
	public AspiranteDireccionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AspiranteDireccionId(Integer idTipo, Integer idDireccion, Integer idAspirante) {
		super();
		this.idTipo = idTipo;
		this.idDireccion = idDireccion;
		this.idAspirante = idAspirante;
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
		return "AspiranteDireccionId [idTipo=" + idTipo + ", idDireccion=" + idDireccion + ", idAspirante="
				+ idAspirante + "]";
	}
	
	
}
