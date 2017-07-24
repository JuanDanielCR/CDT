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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import mx.edu.eld.sepomex.mapeo.Municipio;
import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name = "tad18_direccion")
public class Direccion implements Modelo {
	@Id
	@SequenceGenerator(name = "tad18_direccion_id_direccion_seq", sequenceName = "tad18_direccion_id_direccion_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tad18_direccion_id_direccion_seq")
	@Column(name = "id_direccion")
	private Integer id;
	@Column(name = "tx_colonia")
	private String colonia;
	@Column(name = "tx_numero_ext")
	private String numeroExt;
	@Column(name = "tx_numero_int")
	private String numeroInt;
	@Column(name = "tx_cp")
	private String cp;
	@Column(name = "tx_calle")
	private String calle;
	/*------INSERCION de un campo que es llave foránea--------*/
	/*Hibernate no guarda registros a través campos que se encuentren en las relaciones,
	 * es necesario, que el cmapo se encuentre mapeado a través de un @Column */
	@Column(name = "id_entidad")
	private String idEntidad;
	@Column(name = "id_municipio")
	private String idMunicipio;
	/*La relación no guarda*/
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_entidad", referencedColumnName="id_entidad", updatable=false, insertable=false),
		@JoinColumn(name="id_municipio", referencedColumnName="id_municipio", updatable=false, insertable=false)
	})
	/*-------------------------------------------------------*/
	private Municipio municipio;
	
	@OneToMany(mappedBy="direccion")
	private List<AspiranteDireccion> listaAspirantesDireccion;
	
	public Direccion() {
		super();
	}

	

	public Direccion(Integer id, String colonia, String numeroExt, String numeroInt, String cp, String calle,
			String idEntidad, String idMunicipio, Municipio municipio,
			List<AspiranteDireccion> listaAspirantesDireccion) {
		super();
		this.id = id;
		this.colonia = colonia;
		this.numeroExt = numeroExt;
		this.numeroInt = numeroInt;
		this.cp = cp;
		this.calle = calle;
		this.idEntidad = idEntidad;
		this.idMunicipio = idMunicipio;
		this.municipio = municipio;
		this.listaAspirantesDireccion = listaAspirantesDireccion;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/*Validator: 5-50 chars, debe tener al menos 1 número y [*,!,&]
	 * [abc] --- any of a, b or c
	 * [a-z] --- a through z
	 * X+ ------ X one or more time
	 * 
	 * (?=.*[a-z]+.*)(?=.*[0-9]+.*)(.*[!?&]+.*)
	 * 
	@Validations(requiredStrings={@RequiredStringValidator(type=ValidatorType.FIELD, message="${getText('MSG40')}")},
			stringLengthFields={@StringLengthFieldValidator(minLength="5", maxLength="50", message="${getText('MSG41',{getText('5'),getText('50')})}")},
			regexFields={@RegexFieldValidator(message="${getText('CAP-LBL6')}", regex="(?=.*[a-z]+.*)(?=.*[0-9]+.*)(.*[!?&]+.*)")}
	)*/
	public String getColonia() { 
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	/*Validator: 1 letra y 1 numero
	 * */
	@Validations(
			stringLengthFields={@StringLengthFieldValidator(maxLength="2", message="${getText('CAP-LBL7')}")},
			regexFields={@RegexFieldValidator(message="${getText('CAP-LBL7')}", regex="(?=.*[0-9].*)(.*[a-zA-Z].*)")}
		)
	public String getNumeroExt() {
		return numeroExt;
	}

	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}
	/*Validator: Solo numeros del 1 al 500
	 * */
	@Validations(
			requiredStrings = {@RequiredStringValidator(type=ValidatorType.FIELD, message="${getText('CAP-LBL8')}")},
			regexFields = {@RegexFieldValidator(message="${getText('CAP-LBL8')}", regex="^([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-9][0-9]|3[0-9][0-9]|4[0-9][0-9]|500)$")})
	public String getNumeroInt() {
		return numeroInt;
	}

	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}
	@Validations(
			requiredStrings = {@RequiredStringValidator(type=ValidatorType.FIELD, message="${getText('CAP-LBL10')}")},
			stringLengthFields = {@StringLengthFieldValidator(type=ValidatorType.FIELD, minLength="5", maxLength="5",message="${getText('CAP-LBL10')}")},
			regexFields = {@RegexFieldValidator(type=ValidatorType.FIELD, regex="[0-9]+",message="${getText('CAP-LBL10')}")}
		)
	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	@Validations(
			requiredStrings={@RequiredStringValidator(type=ValidatorType.FIELD, message="${getText('CAP-LBL9')}")},
			regexFields={@RegexFieldValidator(message="${getText('CAP-LBL9')}", regex="([a-zA-Z\\s]+)")}
		)
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public List<AspiranteDireccion> getListaAspirantesDireccion() {
		return listaAspirantesDireccion;
	}

	public void setListaAspirantesDireccion(List<AspiranteDireccion> listaAspirantesDireccion) {
		this.listaAspirantesDireccion = listaAspirantesDireccion;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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



	@Override
	public String toString() {
		return "Direccion [id=" + id + ", colonia=" + colonia + ", numeroExt=" + numeroExt + ", numeroInt=" + numeroInt
				+ ", cp=" + cp + ", calle=" + calle + ", idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio
				+ ", municipio=" + municipio + ", listaAspirantesDireccion=" + listaAspirantesDireccion + "]";
	}

	
	

}
