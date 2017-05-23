package mx.edu.eld.admision.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad05_nivel")
public class Nivel implements Modelo{
	@Id
	@SequenceGenerator(name="tad05_nivel_id_nivel_seq",sequenceName="tad05_nivel_id_nivel_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tad05_nivel_id_nivel_seq")
	@Column(name="id_nivel")
	private Integer id;
	@Column(name="nb_nivel")
	private String nombre;
	@Column(name="ds_nivel")
	private String descripcion;
	@Column(name="st_activo")
	private Boolean estatus;
	
	@OneToMany(mappedBy="nivel")
	private List<InformacionEscolar> listaInformacionEscolar;
	
	public Nivel(){
		super();
	}
	
	public Nivel(Integer id, String nombre, String description, Boolean estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = description;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Nivel [id=" + id + ", nombre=" + nombre + ", description=" + descripcion + ", estatus=" + estatus + "]";
	}
	
	
}
