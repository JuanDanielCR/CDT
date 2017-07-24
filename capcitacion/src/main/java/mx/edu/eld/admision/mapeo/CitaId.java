package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CitaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2343964605113772116L;
	
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="id_entrevistador")
	private Integer idEntrevistador;
	public CitaId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CitaId(Integer idConvocatoria, Integer idAspirante, Integer idEntrevistador) {
		super();
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idEntrevistador = idEntrevistador;
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
	public Integer getIdEntrevistador() {
		return idEntrevistador;
	}
	public void setIdEntrevistador(Integer idEntrevistador) {
		this.idEntrevistador = idEntrevistador;
	}
	@Override
	public String toString() {
		return "CitaId [idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante + ", idEntrevistador="
				+ idEntrevistador + "]";
	}
	
	
	
}
