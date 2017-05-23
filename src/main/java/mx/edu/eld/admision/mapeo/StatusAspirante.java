package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad01_status_aspirante")
public class StatusAspirante implements Modelo{
	@Id
	@SequenceGenerator(name="tad01_status_aspirante_id_status_seq",sequenceName="tad01_status_aspirante_id_status_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad01_status_aspirante_id_status_seq")
	@Column(name="id_status")
	private Integer id;
	@Column(name="nb_status")
	private String nombre;
	@Column(name="ds_status")
	private String descripcion;
	@Column(name="st_activo")
	private Boolean estatus;
	
	public StatusAspirante() {
		super();
	}

	public StatusAspirante(Integer id, String nombre, String descripcion, Boolean estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "EstatusAspirante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estatus="
				+ estatus + "]";
	}
	
}
