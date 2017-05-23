package mx.edu.eld.admision.mapeo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad07_horario")
public class Horario implements Modelo{
	@EmbeddedId
	private HorarioId id;
	
	@Column(name="id_convocatoria", insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_entrevistador", insertable=false, updatable=false)
	private Integer idEntrevistador;
	@Column(name="id_dia", insertable=false, updatable=false)
	private Integer idDia;
	@Column(name="id_horario", insertable=false, updatable=false)
	private Integer idHorario;
	
	@Column(name="tm_inicio")
	private Date tiempoInicio;
	@Column(name="tm_fin")
	private Date tiempoFin;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_convocatoria", referencedColumnName="id_convocatoria", insertable=false, updatable=false),
		@JoinColumn(name="id_entrevistador", referencedColumnName="id_entrevistador", insertable=false, updatable=false)
	})
	private ConvocatoriaEntrevistador convocatoriaEntrevistador;
	
	
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(HorarioId id, Integer idConvocatoria, Integer idEntrevistador, Integer idDia, Integer idHorario,
			Date tiempoInicio, Date tiempoFin) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idEntrevistador = idEntrevistador;
		this.idDia = idDia;
		this.idHorario = idHorario;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFin = tiempoFin;
	}

	public HorarioId getId() {
		return id;
	}

	public void setId(HorarioId id) {
		this.id = id;
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

	public Date getTiempoInicio() {
		return tiempoInicio;
	}

	public void setTiempoInicio(Date tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public Date getTiempoFin() {
		return tiempoFin;
	}

	public void setTiempoFin(Date tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public ConvocatoriaEntrevistador getConvocatoriaEntrevistador() {
		return convocatoriaEntrevistador;
	}

	public void setConvocatoriaEntrevistador(ConvocatoriaEntrevistador convocatoriaEntrevistador) {
		this.convocatoriaEntrevistador = convocatoriaEntrevistador;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", idConvocatoria=" + idConvocatoria + ", idEntrevistador=" + idEntrevistador
				+ ", idDia=" + idDia + ", idHorario=" + idHorario + ", tiempoInicio=" + tiempoInicio + ", tiempoFin="
				+ tiempoFin + "]";
	}
	
	
}
