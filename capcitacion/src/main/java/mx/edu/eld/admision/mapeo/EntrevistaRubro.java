package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tad12_entrevista_rubro")
public class EntrevistaRubro implements Modelo{
	@EmbeddedId
	private EntrevistaRubroId id;
	

	@Column(name="id_entrevista", insertable=false, updatable=false)
	private Integer idEntrevista;
	@Column(name="id_rubro",insertable=false, updatable=false)
	private Integer idRubro;
	
	@Column(name="id_calificacion")
	private Integer idCalificacion;
	
	@ManyToOne
	@JoinColumn(name="id_entrevista", referencedColumnName="id_entrevista",insertable=false, updatable=false)
	private Entrevista entrevista;
	
	@ManyToOne
	@JoinColumn(name="id_calificacion", referencedColumnName="id_calificacion", insertable=false, updatable=false)
	private CalificacionEntrevista calificacionEntrevista;
	
	@ManyToOne
	@JoinColumn(name="id_rubro", referencedColumnName="id_rubro", insertable=false, updatable=false)
	private RubroEntrevista rubroEntrevista;
	
	public EntrevistaRubro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntrevistaRubro(EntrevistaRubroId id, Integer idEntrevista, Integer idRubro, Integer idCalificacion) {
		super();
		this.id = id;
		this.idEntrevista = idEntrevista;
		this.idRubro = idRubro;
		this.idCalificacion = idCalificacion;
	}

	public EntrevistaRubroId getId() {
		return id;
	}

	public void setId(EntrevistaRubroId id) {
		this.id = id;
	}

	public Integer getIdEntrevista() {
		return idEntrevista;
	}

	public void setIdEntrevista(Integer idEntrevista) {
		this.idEntrevista = idEntrevista;
	}

	public Integer getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public Integer getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(Integer idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
	
	public Entrevista getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Entrevista entrevista) {
		this.entrevista = entrevista;
	}

	public CalificacionEntrevista getCalificacionEntrevista() {
		return calificacionEntrevista;
	}

	public void setCalificacionEntrevista(CalificacionEntrevista calificacionEntrevista) {
		this.calificacionEntrevista = calificacionEntrevista;
	}

	public RubroEntrevista getRubroEntrevista() {
		return rubroEntrevista;
	}

	public void setRubroEntrevista(RubroEntrevista rubroEntrevista) {
		this.rubroEntrevista = rubroEntrevista;
	}

	@Override
	public String toString() {
		return "EntrevistaRubro [id=" + id + ", idEntrevista=" + idEntrevista + ", idRubro=" + idRubro
				+ ", idCalificacion=" + idCalificacion + "]";
	}
	
	
}
