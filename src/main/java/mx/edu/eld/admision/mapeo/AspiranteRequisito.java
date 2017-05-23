package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tad04_aspirante_requisito")
public class AspiranteRequisito implements Modelo{
	@EmbeddedId
	private AspiranteRequisitoId id;
	
	@Column(name="id_convocatoria", insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_aspirante", insertable=false, updatable=false)
	private Integer idAspirante;
	@Column(name="id_requisito", insertable=false, updatable=false)
	private Integer idRequisito;
	public AspiranteRequisito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AspiranteRequisito(AspiranteRequisitoId id, Integer idConvocatoria, Integer idAspirante,
			Integer idRequisito) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idRequisito = idRequisito;
	}
	public AspiranteRequisitoId getId() {
		return id;
	}
	public void setId(AspiranteRequisitoId id) {
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
	public Integer getIdRequisito() {
		return idRequisito;
	}
	public void setIdRequisito(Integer idRequisito) {
		this.idRequisito = idRequisito;
	}
	@Override
	public String toString() {
		return "AspiranteRequisito [id=" + id + ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idRequisito=" + idRequisito + "]";
	}
	
	
}
