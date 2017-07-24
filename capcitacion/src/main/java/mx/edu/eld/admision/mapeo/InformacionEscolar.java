package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad06_informacion_escolar")
public class InformacionEscolar implements Modelo{
	@Id
	@SequenceGenerator(name="tad06_informacion_escolar_id_información_seq",sequenceName="tad06_informacion_escolar_id_información_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad06_informacion_escolar_id_información_seq")
	@Column(name="id_informacion")
	private Integer id;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="id_nivel")
	private Integer idNivel;
	@Column(name="tx_nombre")
	private String nombre;
	@Column(name="st_nacional")
	private Boolean estatusNacional;
	@Column(name="st_oficial")
	private Boolean estatusOficial;
	@Column(name="tx_adeudo")
	private String adeudo;
	@Column(name="nu_promedio")
	private Double promedio;
	@Column(name="id_entidad")
	private String idEntidad;
	@Column(name="id_municipio")
	private String idMunicipio;
	
	@ManyToOne
	@JoinColumn(name="id_aspirante", referencedColumnName="id_aspirante", insertable=false, updatable=false)
	private Aspirante aspirante;
	
	@ManyToOne
	@JoinColumn(name="id_nivel", referencedColumnName="id_nivel", insertable=false, updatable=false)
	private Nivel nivel;
	
	public InformacionEscolar() {
		super();
	}
	public InformacionEscolar(Integer id, Integer idAspirante, Integer idNivel, String nombre, Boolean estatusNacional,
			Boolean estatusOficial, String adeudo, Double promedio, String idEntidad, String idMunicipio) {
		super();
		this.id = id;
		this.idAspirante = idAspirante;
		this.idNivel = idNivel;
		this.nombre = nombre;
		this.estatusNacional = estatusNacional;
		this.estatusOficial = estatusOficial;
		this.adeudo = adeudo;
		this.promedio = promedio;
		this.idEntidad = idEntidad;
		this.idMunicipio = idMunicipio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdAspirante() {
		return idAspirante;
	}
	public void setIdAspirante(Integer idAspirante) {
		this.idAspirante = idAspirante;
	}
	public Integer getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstatusNacional() {
		return estatusNacional;
	}
	public void setEstatusNacional(Boolean estatusNacional) {
		this.estatusNacional = estatusNacional;
	}
	public Boolean getEstatusOficial() {
		return estatusOficial;
	}
	public void setEstatusOficial(Boolean estatusOficial) {
		this.estatusOficial = estatusOficial;
	}
	public String getAdeudo() {
		return adeudo;
	}
	public void setAdeudo(String adeudo) {
		this.adeudo = adeudo;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	public String getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public Aspirante getAspirante() {
		return aspirante;
	}
	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "InformacionEscolar [id=" + id + ", idAspirante=" + idAspirante + ", idNivel=" + idNivel + ", nombre="
				+ nombre + ", estatusNacional=" + estatusNacional + ", estatusOficial=" + estatusOficial + ", adeudo="
				+ adeudo + ", promedio=" + promedio + ", idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio + "]";
	}
	
}
