package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad04_aspirante_criterio")
public class AspiranteCriterio implements Modelo{
	@EmbeddedId
	private AspiranteCriterioId id;
	
	@Column(name="id_convocatoria", insertable=false, updatable=false)
	private Integer idConvocatoria;
	@Column(name="id_aspirante", insertable=false,updatable=false)
	private Integer idAspirante;
	@Column(name="id_criterio", insertable=false, updatable=false)
	private Integer idCriterio;
	@Column(name="nu_valor")
	private Integer valor;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_convocatoria", referencedColumnName="id_convocatoria", insertable=false, updatable=false),
		@JoinColumn(name="id_aspirante", referencedColumnName="id_aspirante", insertable=false, updatable=false)
	})
	private ConvocatoriaAspirante convocatoria;
	
	public AspiranteCriterio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AspiranteCriterio(AspiranteCriterioId id, Integer idConvocatoria, Integer idAspirante, Integer idCriterio,
			Integer valor) {
		super();
		this.id = id;
		this.idConvocatoria = idConvocatoria;
		this.idAspirante = idAspirante;
		this.idCriterio = idCriterio;
		this.valor = valor;
	}

	public AspiranteCriterioId getId() {
		return id;
	}

	public void setId(AspiranteCriterioId id) {
		this.id = id;
	}

	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}

	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	public Integer getIdAspirante() {
		return idAspirante;
	}

	public void setIdAspirante(Integer idAspirante) {
		this.idAspirante = idAspirante;
	}

	public Integer getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public ConvocatoriaAspirante getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(ConvocatoriaAspirante convocatoria) {
		this.convocatoria = convocatoria;
	}

	@Override
	public String toString() {
		return "AspiranteCriterio [id=" + id + ", idConvocatoria=" + idConvocatoria + ", idAspirante=" + idAspirante
				+ ", idCriterio=" + idCriterio + ", valor=" + valor + "]";
	}
	
	
}
