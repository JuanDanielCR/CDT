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
@Table(name="tad13_entrevista")
public class Entrevista implements Modelo{
	@Id
	@SequenceGenerator(name="tad13_entrevista_id_entrevista_seq", sequenceName="tad13_entrevista_id_entrevista_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad13_entrevista_id_entrevista_seq")
	@Column(name="id_entrevista")
	private Integer id;
	@Column(name="id_entrevistador")
	private Integer idEntrevistador;
	@Column(name="is_status")
	private Integer idStatus;
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="tx_observacion")
	private String observacion;
	
	public Entrevista() {
		super();
	}
	public Entrevista(Integer id, Integer idEntrevistador, Integer idStatus, Integer idConvocatoria,
			Integer idAspirante, String observacion) {
		super();
		this.id = id;
		this.idEntrevistador = idEntrevistador;
		this.idStatus = idStatus;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.observacion = observacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEntrevistador() {
		return idEntrevistador;
	}
	public void setIdEntrevistador(Integer idEntrevistador) {
		this.idEntrevistador = idEntrevistador;
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}
	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}
	public Integer getIdAspirante() {
		return idAspirante;
	}
	public void setIdAspirante(Integer idAspirante) {
		this.idAspirante = idAspirante;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "Entrevista [id=" + id + ", idEntrevistador=" + idEntrevistador + ", idStatus=" + idStatus
				+ ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante + ", observacion=" + observacion
				+ "]";
	}
	
	
}
