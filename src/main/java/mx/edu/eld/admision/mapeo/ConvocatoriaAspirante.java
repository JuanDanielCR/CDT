package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad04_convocatoria_aspirante")
public class ConvocatoriaAspirante implements Modelo{
	@EmbeddedId
	private ConvocatoriaAspiranteId id;
	@Column(name="id_convocatoria", insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_aspirante", insertable=false, updatable=false)
	private Integer idAspirante;
	@Column(name="id_status")
	private Integer idStatus;
	@Column(name="fh_registro")
	private Integer fechaRegistro;
	public ConvocatoriaAspirante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConvocatoriaAspirante(ConvocatoriaAspiranteId id, Integer idConvocatoria, Integer idAspirante,
			Integer idStatus, Integer fechaRegistro) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idStatus = idStatus;
		this.fechaRegistro = fechaRegistro;
	}
	public ConvocatoriaAspiranteId getId() {
		return id;
	}
	public void setId(ConvocatoriaAspiranteId id) {
		this.id = id;
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
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public Integer getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Integer fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@Override
	public String toString() {
		return "ConvocatoriaAspirante [id=" + id + ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idStatus=" + idStatus + ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
}
