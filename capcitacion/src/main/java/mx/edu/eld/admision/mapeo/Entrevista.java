package mx.edu.eld.admision.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad13_entrevista")
public class Entrevista implements Modelo{
	@Id
	@SequenceGenerator(name="tad13_entrevista_id_entrevista_seq", sequenceName="tad13_entrevista_id_entrevista_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad13_entrevista_id_entrevista_seq")
	@Column(name="id_entrevista")
	private Integer id;
	@Column(name="id_entrevistador")
	private Integer idEntrevistador;
	@Column(name="is_status")
	private Integer idStatus;
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="tx_observacion")
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name="id_status", referencedColumnName="id_status", insertable=false, updatable=false)
	private EstatusEntrevista estatus;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_convocatoria", referencedColumnName="id_convocatoria", insertable=false, updatable=false),
		@JoinColumn(name="id_aspirante", referencedColumnName="id_aspirante", insertable=false, updatable=false)
	})
	private ConvocatoriaAspirante convocatoria;
	/*
	 * OneToOne
	 * Las relaciones OneToOne no siempre son mapeadas como una relacion
	 * en ocasiones son manejadas como herencias.
	 * 
	 * Entrevistador extends Profesor;
	 * Profesor extends Persona
	 * 
	 * Si la relacion si es hecha explicitamente usamos la sintaxis
	 * @OneToOne() en ls clase del objeto que herede la llave foranea
	 *  
	 * */
	@OneToOne
	@JoinColumn(name="id_entrevista", referencedColumnName="id_recomendacion", insertable=false, updatable=false)
	private Recomendacion recomendacion;
	
	@OneToMany(mappedBy="entrevista")
	private List<EntrevistaRubro> entrevistaRubros;	
	
	
	public Entrevista() {
		super();
	}
	public Entrevista(Integer id, Integer idEntrevistador, Integer idStatus, Integer idConvocatoria,
			Integer idAspirante, String observacion) {
		super();
		this.id = id;
		this.idEntrevistador = idEntrevistador;
		this.idStatus = idStatus;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.observacion = observacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEntrevistador() {
		return idEntrevistador;
	}
	public void setIdEntrevistador(Integer idEntrevistador) {
		this.idEntrevistador = idEntrevistador;
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
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
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public EstatusEntrevista getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusEntrevista estatus) {
		this.estatus = estatus;
	}
	public ConvocatoriaAspirante getConvocatoria() {
		return convocatoria;
	}
	public void setConvocatoria(ConvocatoriaAspirante convocatoria) {
		this.convocatoria = convocatoria;
	}
	public Recomendacion getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}
	public List<EntrevistaRubro> getEntrevistaRubros() {
		return entrevistaRubros;
	}
	public void setEntrevistaRubros(List<EntrevistaRubro> entrevistaRubros) {
		this.entrevistaRubros = entrevistaRubros;
	}
	
	@Override
	public String toString() {
		return "Entrevista [id=" + id + ", idEntrevistador=" + idEntrevistador + ", idStatus=" + idStatus
				+ ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante + ", observacion=" + observacion
				+ "]";
	}
	
	
}
