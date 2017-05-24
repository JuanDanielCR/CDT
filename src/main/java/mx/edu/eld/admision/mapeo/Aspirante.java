package mx.edu.eld.admision.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name = "tad02_aspirante")
public class Aspirante implements Modelo {
	/*
	 * Para obtener el nombre del generador usar dbeaver -> conectarse a la DB
	 * -> Click derecho generate sql -> Insert
	 */
	@Id
	@SequenceGenerator(name = "tad02_aspirante_id_aspirante_seq", sequenceName = "tad02_aspirante_id_aspirante_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tad02_aspirante_id_aspirante_seq")
	@Column(name = "id_aspirante")
	private Integer id;
	@Column(name = "tx_primer_ap")
	private String primerAp;
	@Column(name = "tx_segundo_ap")
	private String segundoAp;
	@Column(name = "tx_curp")
	private String curp;

	/*
	 * Relacion OneToMany, la relacion se especifica en la clase
	 * correspondientes al Many, en la correspondiente al One (este caso)
	 * hacemos uso de la anotación mappedBy
	 */
	@OneToMany
	@JoinColumn(name = "id_aspirante", referencedColumnName = "id_aspirante", updatable = false, insertable = false)
	private List<Contacto> contactos;

	@OneToMany(mappedBy = "aspirante")
	private List<InformacionEscolar> listaInformacionEscolar;

	@OneToMany(mappedBy = "aspirante")
	private List<ConvocatoriaAspirante> convocatoriasAspirantes;

	/*
	 * Relacion ManyToMany, referencia a la tabla intermedia donde se vaciará la
	 * información, así como la llaves transferidas, esta relacion solo se hace
	 * en la entidad que lo usara, no hay necesidad de crear una lista en cada
	 * entidad, solo si el caso de uso lo necesita
	 */
	@ManyToMany
	@JoinTable(name = "tad19_aspirante_direccion", joinColumns = {
			@JoinColumn(name = "id_aspirante", updatable = false, insertable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", updatable = false, insertable = false) })
	private List<Direccion> direcciones;

	public Aspirante() {
		super();
	}

	public Aspirante(Integer idAspirante, String primerAp, String segundoAp, String curp) {
		this.id = idAspirante;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.curp = curp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrimerAp() {
		return primerAp;
	}

	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}

	public String getSegundoAp() {
		return segundoAp;
	}

	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public List<ConvocatoriaAspirante> getConvocatoriasAspirantes() {
		return convocatoriasAspirantes;
	}

	public void setConvocatoriasAspirantes(List<ConvocatoriaAspirante> convocatoriasAspirantes) {
		this.convocatoriasAspirantes = convocatoriasAspirantes;
	}

	public List<InformacionEscolar> getListaInformacionEscolar() {
		return listaInformacionEscolar;
	}

	public void setListaInformacionEscolar(List<InformacionEscolar> listaInformacionEscolar) {
		this.listaInformacionEscolar = listaInformacionEscolar;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public String toString() {
		return "Aspirante [idAspirante=" + id + ", primerAp=" + primerAp + ", segundoAp=" + segundoAp + ", curp=" + curp
				+ "]";
	}

}
