package mx.edu.eld.admision.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad10_rubro_entrevista")
public class RubroEntrevista implements Modelo{
	@Id
	@SequenceGenerator(name="tad10_rubro_entrevista_id_rubro_seq",sequenceName="tad10_rubro_entrevista_id_rubro_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad10_rubro_entrevista_id_rubro_seq")
	@Column(name="id_rubro")
	private Integer id;
	@Column(name="nb_rubro")
	private String nombre;
	@Column(name="ds_rubro")
	private Integer descripcion;
	@Column(name="st_rubro")
	private Boolean estatus;
	
	@OneToMany(mappedBy="rubroEntrevista")
	private List<EntrevistaRubro> entrevistaRubros;
	
	public RubroEntrevista() {
		super();
	}
	public RubroEntrevista(Integer id, String nombre, Integer descripcion, Boolean estatus) {
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
	public Integer getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstatus() {
		return estatus;
	}
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	public List<EntrevistaRubro> getEntrevistaRubros() {
		return entrevistaRubros;
	}
	public void setEntrevistaRubros(List<EntrevistaRubro> entrevistaRubros) {
		this.entrevistaRubros = entrevistaRubros;
	}
	@Override
	public String toString() {
		return "RubroEntrevista [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estatus="
				+ estatus + "]";
	}
	
	
}
