package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class ConvocatoriaAspiranteId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 123060422893328644L;
	
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	public ConvocatoriaAspiranteId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConvocatoriaAspiranteId(Integer idConvocatoria, Integer idAspirante) {
		super();
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
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
	@Override
	public String toString() {
		return "ConvocatoriaAspiranteId [idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante + "]";
	}
	
}
