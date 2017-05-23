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
@Table(name="tad15_status_entervista")
public class StatusEntervista implements Modelo{
	@Id
	@SequenceGenerator(name="tad15_estatus_entrevista_id_estatus_seq", sequenceName="tad15_estatus_entrevista_id_estatus_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tad15_estatus_entrevista_id_estatus_seq")
	@Column(name="id_status")
	private Integer id;
	@Column(name="nb_status")
	private String nombre;
	@Column(name="ds_status")
	private String descripcion;
	@Column(name="st_activo")
	private String estatus;
	
	public StatusEntervista() {
		super();
	}
	public StatusEntervista(Integer id, String nombre, String descripcion, String estatus) {
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
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "StatusEntervista [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estatus="
				+ estatus + "]";
	}
	
}
