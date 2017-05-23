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
@Table(name="tad02_aspirante")
public class Aspirante implements Modelo{
	/*Para obtener el nombre del generador usar dbeaver -> conectarse a la DB -> Click derecho generate sql -> Insert*/
	@Id
	@SequenceGenerator(name="tad02_aspirante_id_aspirante_seq",sequenceName="tad02_aspirante_id_aspirante_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad02_aspirante_id_aspirante_seq")
	@Column(name="id_aspirante")
	private Integer id;
	@Column(name="tx_primer_ap")
	private String primerAp;
	@Column(name="tx_segundo_ap")
	private String segundoAp;
	@Column(name="tx_curp")
	private String curp;
	
	public 	Aspirante(){
		super();
	}
	public Aspirante(Integer idAspirante, String primerAp, String segundoAp, String curp){
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
	@Override
	public String toString() {
		return "Aspirante [idAspirante=" + id + ", primerAp=" + primerAp + ", segundoAp=" + segundoAp
				+ ", curp=" + curp + "]";
	}
	
}
