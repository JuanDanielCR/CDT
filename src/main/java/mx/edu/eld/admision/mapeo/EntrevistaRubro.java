package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

	@Override
	public String toString() {
		return "EntrevistaRubro [id=" + id + ", idEntrevista=" + idEntrevista + ", idRubro=" + idRubro
				+ ", idCalificacion=" + idCalificacion + "]";
	}
	
	
}
