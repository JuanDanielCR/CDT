package mx.edu.eld.sepomex.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.edu.eld.admision.mapeo.Direccion;
import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tsp02_municipio")
public class Municipio implements Modelo{
	@EmbeddedId
	private MunicipioId id;
	
	@Column(name="id_entidad", insertable=false, updatable=false)
	private String idEntidad;
	@Column(name="id_municipio", insertable=false, updatable=false)
	private String idMunicipio;
	@Column(name="nb_municipio")
	private String nombre;
	@Column(name="st_activo")
	private Boolean estatus;
	
	@OneToMany(mappedBy="municipio")
	private List<Direccion> direcciones;
	
	@ManyToOne
	@JoinColumn(name="id_entidad", referencedColumnName="id_entidad", updatable=false, insertable=false)
	private Entidad entidad;
	
	public Municipio(){
		super();
	}
	
	public Municipio(MunicipioId id, String idEntidad, String idMunicipio, String municipio, Boolean estatus) {
		super();
		this.id = new MunicipioId(idEntidad,idMunicipio); 
		this.idEntidad = idEntidad;
		this.idMunicipio = idMunicipio;
		this.nombre = municipio;
		this.estatus = estatus;
	}

	public MunicipioId getId() {
		return id;
	}
	public void setId(MunicipioId id) {
		this.id = id;
	}
	public String getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Boolean getEstatus() {
		return estatus;
	}
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Municipio [id=" + id + ", idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio + ", municipio="
				+ nombre + ", estatus=" + estatus + "]";
	}
	
	
}
