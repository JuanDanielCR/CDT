package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConvocatoriaEntrevistadorId implements Serializable{
	private static final long serialVersionUID = 3786543014978902698L;
	
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_entrevistador")
	private Integer idEntrevistador;
	
	public ConvocatoriaEntrevistadorId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConvocatoriaEntrevistadorId(Integer idConvocatoria, Integer idEntrevistador) {
		super();
		this.idConvocatoria = idConvocatoria;
		this.idEntrevistador = idEntrevistador;
	}
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}
	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}
	public Integer getIdEntrevistador() {
		return idEntrevistador;
	}
	public void setIdEntrevistador(Integer idEntrevistador) {
		this.idEntrevistador = idEntrevistador;
	}
	@Override
	public String toString() {
		return "ConvocatoriaEntrevistadorId [idConvocatoria=" + idConvocatoria + ", idEntrevistador=" + idEntrevistador
				+ "]";
	}
	
	
}