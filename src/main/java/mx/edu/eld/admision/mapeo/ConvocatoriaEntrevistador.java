package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad16_convocatoria_entrevistador")
public class ConvocatoriaEntrevistador implements Modelo{
	@EmbeddedId
	private ConvocatoriaEntrevistadorId id;
	
	@Column(name="id_convocatoria",insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_entrevistador", insertable=false, updatable=false)
	private Integer idEntrevistador;

	public ConvocatoriaEntrevistador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConvocatoriaEntrevistador(ConvocatoriaEntrevistadorId id, Integer idConvocatoria, Integer idEntrevistador) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idEntrevistador = idEntrevistador;
	}


	public ConvocatoriaEntrevistadorId getId() {
		return id;
	}

	public void setId(ConvocatoriaEntrevistadorId id) {
		this.id = id;
	}

	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}

	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	public Integer getIdEntrevistador() {
		return idEntrevistador;
	}

	public void setIdEntrevistador(Integer idEntrevistador) {
		this.idEntrevistador = idEntrevistador;
	}

	@Override
	public String toString() {
		return "ConvocatoriaEntrevistador [id=" + id + "]";
	}
	
	
}
