package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name="tad20_contacto")
public class Contacto implements Modelo{
	@Id
	@SequenceGenerator(name="tad20_contacto_id_contacto_seq",sequenceName="tad20_contacto_id_contacto_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad20_contacto_id_contacto_seq")
	@Column(name="id_contacto")
	private Integer id;
	@Column(name="id_aspirante")
	private Integer idAspirante;
	@Column(name="id_categoria")
	private Integer idCategoria;
	@Column(name="id_tipo")
	private Integer idTipo;
	@Column(name="tx_contacto")
	private String contacto;
	@Column(name="tx_contacto_a")
	private String contactoA;
	@Column(name="tx_contacto_b")
	private String contactoB;
	@Column(name="tx_emergencia")
	private String emergencia;
	@Column(name="tx_relacion")
	private String relacion;
	
	public Contacto() {
		super();
	}
	public Contacto(Integer id, Integer idAspirante, Integer idCategoria, Integer idTipo, String contacto,
			String contactoA, String contactoB, String emergencia, String relacion) {
		super();
		this.id = id;
		this.idAspirante = idAspirante;
		this.idCategoria = idCategoria;
		this.idTipo = idTipo;
		this.contacto = contacto;
		this.contactoA = contactoA;
		this.contactoB = contactoB;
		this.emergencia = emergencia;
		this.relacion = relacion;
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
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getContactoA() {
		return contactoA;
	}
	public void setContactoA(String contactoA) {
		this.contactoA = contactoA;
	}
	public String getContactoB() {
		return contactoB;
	}
	public void setContactoB(String contactoB) {
		this.contactoB = contactoB;
	}
	public String getEmergencia() {
		return emergencia;
	}
	public void setEmergencia(String emergencia) {
		this.emergencia = emergencia;
	}
	public String getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", idAspirante=" + idAspirante + ", idCategoria=" + idCategoria + ", idTipo="
				+ idTipo + ", contacto=" + contacto + ", contactoA=" + contactoA + ", contactoB=" + contactoB
				+ ", emergencia=" + emergencia + ", relacion=" + relacion + "]";
	}
	
	
}
