package mx.edu.eld.admision.mapeo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad17_entrevistador")
public class Entrevistador implements Modelo{
	@Id
	@SequenceGenerator(name="tad17_entrevistador_id_entrevistador_seq",sequenceName="tad17_entrevistador_id_entrevistador_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad17_entrevistador_id_entrevistador_seq")
	private Integer id;
	public Entrevistador(){
		super();
	}
	public Entrevistador(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Entrevistador [id=" + id + "]";
	}
	
}
