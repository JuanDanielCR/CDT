package mx.edu.eld.admision.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntrevistaRubroId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6365194375155253208L;
	
	@Column(name="id_entrevista")
	private Integer idEntrevista;
	@Column(name="id_rubro")
	private Integer idRubro;
	public EntrevistaRubroId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EntrevistaRubroId(Integer idEntrevista, Integer idRubro) {
		super();
		this.idEntrevista = idEntrevista;
		this.idRubro = idRubro;
	}
	public Integer getIdEntrevista() {
		return idEntrevista;
	}
	public void setIdEntrevista(Integer idEntrevista) {
		this.idEntrevista = idEntrevista;
	}
	public Integer getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}
	@Override
	public String toString() {
		return "EntrevistaRubroId [idEntrevista=" + idEntrevista + ", idRubro=" + idRubro + "]";
	}
	
	

}
