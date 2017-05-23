package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class AspiranteCriterioId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6707693586256304571L;
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="id_criterio")
	private Integer idCriterio;
	public AspiranteCriterioId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AspiranteCriterioId(Integer idConvocatoria, Integer idAspirante, Integer idCriterio) {
		super();
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idCriterio = idCriterio;
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
	public Integer getIdCriterio() {
		return idCriterio;
	}
	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}
	@Override
	public String toString() {
		return "AspiranteCriterioId [idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idCriterio=" + idCriterio + "]";
	}
	
	
}
