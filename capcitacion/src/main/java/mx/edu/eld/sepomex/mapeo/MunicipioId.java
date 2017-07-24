package mx.edu.eld.sepomex.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MunicipioId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_entidad")
	private String idEntidad;
	@Column(name="id_municipio")
	private String idMunicipio;
	
	public MunicipioId(){
		super();
	}
	

	public MunicipioId(String idEntidad, String idMunicipio) {
		super();
		this.idEntidad = idEntidad;
		this.idMunicipio = idMunicipio;
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
		return "MunicipioId [idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio + "]";
	}
	
	
	
}
