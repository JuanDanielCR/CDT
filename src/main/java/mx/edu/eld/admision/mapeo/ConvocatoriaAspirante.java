package mx.edu.eld.admision.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad04_convocatoria_aspirante")
public class ConvocatoriaAspirante implements Modelo{
	@EmbeddedId
	private ConvocatoriaAspiranteId id;
	@Column(name="id_convocatoria", insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_aspirante", insertable=false, updatable=false)
	private Integer idAspirante;
	@Column(name="id_status")
	private Integer idStatus;
	@Column(name="fh_registro")
	private Integer fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name="id_aspirante",referencedColumnName="id_aspirante", insertable=false, updatable=false)
	private Aspirante aspirante;
	
	@ManyToOne
	@JoinColumn(name="id_status", referencedColumnName="id_status", insertable=false, updatable=false)
	private EstatusAspirante estatus;
	
	@OneToMany(mappedBy="convocatoria")
	private List<AspiranteRequisito> requisitos;
	
	@OneToMany(mappedBy="convocatoria")
	private List<Pago> pagos;
	
	@OneToMany(mappedBy="convocatoria")
	private List<AspiranteCriterio> criterios;
	
	@OneToMany(mappedBy="convocatoria")
	private List<Entrevista> entrevistas;
	
	@OneToMany(mappedBy="convocatoriaAspirante")
	private List<Cita> citas;
	
	public ConvocatoriaAspirante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConvocatoriaAspirante(ConvocatoriaAspiranteId id, Integer idConvocatoria, Integer idAspirante,
			Integer idStatus, Integer fechaRegistro) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idStatus = idStatus;
		this.fechaRegistro = fechaRegistro;
	}
	public ConvocatoriaAspiranteId getId() {
		return id;
	}
	public void setId(ConvocatoriaAspiranteId id) {
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
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public Integer getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Integer fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Aspirante getAspirante() {
		return aspirante;
	}
	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}
	public EstatusAspirante getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusAspirante estatus) {
		this.estatus = estatus;
	}
	public List<AspiranteRequisito> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(List<AspiranteRequisito> requisitos) {
		this.requisitos = requisitos;
	}
	
	public List<Pago> getPagos() {
		return pagos;
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	public List<AspiranteCriterio> getCriterios() {
		return criterios;
	}
	public void setCriterios(List<AspiranteCriterio> criterios) {
		this.criterios = criterios;
	}
	public List<Entrevista> getEntrevistas() {
		return entrevistas;
	}
	public void setEntrevistas(List<Entrevista> entrevistas) {
		this.entrevistas = entrevistas;
	}
	public List<Cita> getCitas() {
		return citas;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	@Override
	public String toString() {
		return "ConvocatoriaAspirante [id=" + id + ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idStatus=" + idStatus + ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
}
