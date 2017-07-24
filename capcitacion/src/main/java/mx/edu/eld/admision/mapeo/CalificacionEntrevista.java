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
@Table(name = "tad11_calificacion_entrevista")
public class CalificacionEntrevista implements Modelo {
	@Id
	@SequenceGenerator(name = "tad11_calificacion_entrevista_id_calificacion_seq", sequenceName = "tad11_calificacion_entrevista_id_calificacion_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tad11_calificacion_entrevista_id_calificacion_seq")
	@Column(name = "id_calificacion")
	private Integer id;
	@Column(name = "nu_calificacion")
	private Integer calificacion;
	@Column(name = "ds_calificacion")
	private String descripcion;
	@Column(name = "st_calificacion")
	private Boolean estatus;

	@OneToMany(mappedBy = "calificacionEntrevista")
	private List<EntrevistaRubro> entrevistaRubros;

	public CalificacionEntrevista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalificacionEntrevista(Integer id, Integer calificacion, String descripcion, Boolean estatus) {
		super();
		this.id = id;
		this.calificacion = calificacion;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
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

	public List<EntrevistaRubro> getEntrevistaRubros() {
		return entrevistaRubros;
	}

	public void setEntrevistaRubros(List<EntrevistaRubro> entrevistaRubros) {
		this.entrevistaRubros = entrevistaRubros;
	}

	@Override
	public String toString() {
		return "CalificacionEntrevista [id=" + id + ", calificacion=" + calificacion + ", descripcion=" + descripcion
				+ ", estatus=" + estatus + "]";
	}

}
