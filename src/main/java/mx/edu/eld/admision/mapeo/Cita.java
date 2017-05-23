package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tad21_cita")
public class Cita implements Modelo{
	@EmbeddedId
	private CitaId id;
	
	@Column(name="id_convocatoria", insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_aspirante", insertable=false, updatable=false)
	private Integer idAspirante;
	@Column(name="id_entrevistador", insertable=false, updatable=false)
	private Integer idEntrevistador;

	@Column(name="fh_cita")
	private Integer fechaCita;
	/*
	 * Relacion Many To One con llave compuesta
	 * Usamos una sintaxis parecida a la de ManyToMany
	 * */
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_convocatoria", referencedColumnName="id_convocatoria", insertable=false, updatable=false),
		@JoinColumn(name="id_entrevistador", referencedColumnName="id_entrevistador", updatable=false, insertable=false)
		})
	private ConvocatoriaEntrevistador convocatoriaEntrevistador;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_convocatoria", referencedColumnName="id_convocatoria", insertable=false, updatable=false),
		@JoinColumn(name="id_aspirante", referencedColumnName="id_aspirante", insertable=false, updatable=false)
	})
	private ConvocatoriaAspirante convocatoriaAspirante;
	
	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cita(CitaId id, Integer idConvocatoria, Integer idAspirante, Integer idEntrevistador, Integer idCon,
			Integer fechaCita) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idEntrevistador = idEntrevistador;
		this.fechaCita = fechaCita;
	}
	public ConvocatoriaEntrevistador getConvocatoriaEntrevistador() {
		return convocatoriaEntrevistador;
	}
	public void setConvocatoriaEntrevistador(ConvocatoriaEntrevistador convocatoriaEntrevistador) {
		this.convocatoriaEntrevistador = convocatoriaEntrevistador;
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
	public Integer getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Integer fechaCita) {
		this.fechaCita = fechaCita;
	}
	public CitaId getId() {
		return id;
	}
	public void setId(CitaId id) {
		this.id = id;
	}
	
	public ConvocatoriaAspirante getConvocatoriaAspirante() {
		return convocatoriaAspirante;
	}
	public void setConvocatoriaAspirante(ConvocatoriaAspirante convocatoriaAspirante) {
		this.convocatoriaAspirante = convocatoriaAspirante;
	}
	@Override
	public String toString() {
		return "Cita [id=" + id + ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idEntrevistador=" + idEntrevistador + ", fechaCita=" + fechaCita + "]";
	}
	
	
}
