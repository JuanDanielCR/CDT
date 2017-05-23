package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class HorarioId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5099283327175911402L;
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_entrevistador")
	private Integer idEntrevistador;
	@Column(name="id_dia")
	private Integer idDia;
	@Column(name="id_horario")
	private Integer idHorario;
	public HorarioId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HorarioId(Integer idConvocatoria, Integer idEntrevistador, Integer idDia, Integer idHorario) {
		super();
		this.idConvocatoria = idConvocatoria;
		this.idEntrevistador = idEntrevistador;
		this.idDia = idDia;
		this.idHorario = idHorario;
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
	public Integer getIdDia() {
		return idDia;
	}
	public void setIdDia(Integer idDia) {
		this.idDia = idDia;
	}
	public Integer getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}
	@Override
	public String toString() {
		return "HorarioId [idConvocatoria=" + idConvocatoria + ", idEntrevistador=" + idEntrevistador + ", idDia="
				+ idDia + ", idHorario=" + idHorario + "]";
	}
	
	

}
