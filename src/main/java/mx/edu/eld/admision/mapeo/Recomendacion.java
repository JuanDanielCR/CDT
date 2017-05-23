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
@Table(name="tad14_recomendacion")
public class Recomendacion implements Modelo{
	@Id
	@SequenceGenerator(name="tad14_recomendacion_id_recomendacion_seq",sequenceName="tad14_recomendacion_id_recomendacion_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad14_recomendacion_id_recomendacion_seq")
	@Column(name="id_recomendacion")
	private Integer id;
	@Column(name="id_recomendador")
	private Integer idRecomendador;
	@Column(name="id_entrevista")
	private Integer idEntrevista;
	@Column(name="nb_recomendador")
	private String nombre;
	
	public Recomendacion() {
		super();
	}
	public Recomendacion(Integer id, Integer idRecomendador, Integer idEntrevista, String nombre) {
		super();
		this.id = id;
		this.idRecomendador = idRecomendador;
		this.idEntrevista = idEntrevista;
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRecomendador() {
		return idRecomendador;
	}
	public void setIdRecomendador(Integer idRecomendador) {
		this.idRecomendador = idRecomendador;
	}
	public Integer getIdEntrevista() {
		return idEntrevista;
	}
	public void setIdEntrevista(Integer idEntrevista) {
		this.idEntrevista = idEntrevista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Recomendacion [id=" + id + ", idRecomendador=" + idRecomendador + ", idEntrevista=" + idEntrevista
				+ ", nombre=" + nombre + "]";
	}
	
	
}
