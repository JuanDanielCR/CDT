package mx.edu.eld.admision.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.mapeo.Modelo;
@Entity
@Table(name="tad09_pago")
public class Pago implements Modelo{
	@EmbeddedId
	private PagoId id;
	
	@Column(name="id_tipo")
	private Integer idTipo;
	@Column(name="fh_pago")
	private Integer fechaPago;
	@Column(name="nu_monto")
	private Double monto;
	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pago(PagoId id, Integer idTipo, Integer fechaPago, Double monto) {
		super();
		this.id = id;
		this.idTipo = idTipo;
		this.fechaPago = fechaPago;
		this.monto = monto;
	}
	public PagoId getId() {
		return id;
	}
	public void setId(PagoId id) {
		this.id = id;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public Integer getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Integer fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "Pago [id=" + id + ", idTipo=" + idTipo + ", fechaPago=" + fechaPago + ", monto=" + monto + "]";
	}
	
	
}
