package mx.edu.eld.sepomex.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tsp01_entidad")
public class Entidad implements Modelo{
	@Id
	@Column(name="id_entidad")
	private String id;
	@Column(name = "nb_entidad")
	private String nombre;
	@Column(name="st_activo")
	private Boolean estatus;
	
	@OneToMany
	@JoinColumn(name="id_entidad", referencedColumnName="id_entidad", updatable=false, insertable=false)
	private List<Municipio> municipio;
	
	public Entidad(){
		
	}
	
	public Entidad(String id, String nombre, Boolean estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Entidad [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + "]";
	}	
}