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
@Table(name="tad18_direccion")
public class Direccion implements Modelo{
	@Id
	@SequenceGenerator(name="tad18_direccion_id_direccion_seq", sequenceName="tad18_direccion_id_direccion_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="id_direccion")
	@Column(name="id_direccion")
	private Integer id;
	@Column(name="id_entidad")
	private String idEntidad;
	@Column(name="id_municipio")
	private String idMunicipio;
	@Column(name="tx_colonia")
	private String colonia;
	@Column(name="tx_numero_ext")
	private String numeroExt;
	@Column(name="tx_numero_int")
	private String numeroInt;
	@Column(name="tx_cp")
	private String cp;
	@Column(name="tx_calle")
	private Integer calle;
	
	
	public Direccion(){
		super();
	}
	

	public Direccion(Integer id, String idEntidad, String idMunicipio, String colonia, String numeroExt,
			String numeroInt, String cp, Integer calle) {
		super();
		this.id = id;
		this.idEntidad = idEntidad;
		this.idMunicipio = idMunicipio;
		this.colonia = colonia;
		this.numeroExt = numeroExt;
		this.numeroInt = numeroInt;
		this.cp = cp;
		this.calle = calle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getNumeroExt() {
		return numeroExt;
	}

	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}

	public String getNumeroInt() {
		return numeroInt;
	}

	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Integer getCalle() {
		return calle;
	}

	public void setCalle(Integer calle) {
		this.calle = calle;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio + ", colonia="
				+ colonia + ", numeroExt=" + numeroExt + ", numeroInt=" + numeroInt + ", cp=" + cp + ", calle=" + calle
				+ "]";
	}

}
