package mx.edu.eld.admision.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;

@Entity
@Table(name = "tad17_entrevistador")
public class Entrevistador implements Modelo {
	@Id
	@SequenceGenerator(name = "tad17_entrevistador_id_entrevistador_seq", sequenceName = "tad17_entrevistador_id_entrevistador_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tad17_entrevistador_id_entrevistador_seq")
	@Column(name = "id_entrevistador")
	private Integer id;

	@OneToMany(mappedBy = "entrevistador", fetch = FetchType.EAGER)
	private List<ConvocatoriaEntrevistador> convocatoriasEntrevistador;

	public List<ConvocatoriaEntrevistador> getConvocatoriasEntrevistador() {
		return convocatoriasEntrevistador;
	}

	public void setConvocatoriasEntrevistador(List<ConvocatoriaEntrevistador> convocatoriasEntrevistador) {
		this.convocatoriasEntrevistador = convocatoriasEntrevistador;
	}

	public Entrevistador() {
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
