package mx.edu.eld.admision.action;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ModelDriven;

import mx.edu.eld.admision.mapeo.Aspirante;
import mx.ipn.escom.cdt.util.action.ActionSupportCDT;

/* Conexion a la vista
 * Nombre del paquete despues de la carpeta /pages en webapp
 * dentro de /pages:
 * 	---/admision (Namespace, nombre del paquete que engloba la entidad completa)
 * 	-----/gestionar-aspirante (nombre en minusculas de la clase con guion entre cada palabra)
 * */
@Namespace("/admision") // ve a este folder para mis vistas
public class GestionarAspiranteAct extends ActionSupportCDT implements ModelDriven<Aspirante> {

	private Aspirante model;

	/*
	 * Declaracion de los metodos para hacer el attach con los metodos de REST,
	 * siempre retornan un String, este String se hereda de ActtionSupportCDT
	 */
	public String index() {

		// guardado en ActionSupportCDT
		return INDEX;
	}

	public String editNew() {

		return EDITNEW;
	}

	public Aspirante getModel() {
		return model;
	}

	public void setModel(Aspirante model) {
		this.model = model;
	}

}
