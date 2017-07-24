package mx.edu.eld.sepomex.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tsp03_cp")
public class Cp implements Modelo{
	@Id
	@Column(name="id_cp")
	private Integer id;
	@Column(name="id_entidad")
	private String idEntidad;
	@Column(name="id_municipio")
	private String idMunicipio;
	@Column(name="tx_cp")
	private String cp;
	@Column(name="nb_asentamiento")
	private String asentamiento;
	@Column(name="nb_ciudad")
	private String ciudad;
	@Column(name="st_activo")
	private Boolean estatus;
	
	public Cp(){
		
	}

	public Cp(Integer id, String idEntidad, String idMunicipio, String cp, String asentamiento, String ciudad,
			Boolean estatus) {
		super();
		this.id = id;
		this.idEntidad = idEntidad;
		this.idMunicipio = idMunicipio;
		this.cp = cp;
		this.asentamiento = asentamiento;
		this.ciudad = ciudad;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Cp [id=" + id + ", idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio + ", cp=" + cp
				+ ", asentamiento=" + asentamiento + ", ciudad=" + ciudad + ", estatus=" + estatus + "]";
	}
	
	
}
