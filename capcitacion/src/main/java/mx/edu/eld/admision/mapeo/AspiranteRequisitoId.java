package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class AspiranteRequisitoId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940920720518666340L;
	
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="id_requisito")
	private Integer idRequisito;
	public AspiranteRequisitoId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AspiranteRequisitoId(Integer idConvocatoria, Integer idAspirante, Integer idRequisito) {
		super();
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idRequisito = idRequisito;
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
		return "AspiranteRequisitoId [idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idRequisito=" + idRequisito + "]";
	}
	
	
}
