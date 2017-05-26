package mx.edu.eld.admision.action;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import mx.edu.eld.admision.bs.AspiranteBs;
import mx.edu.eld.admision.mapeo.Aspirante;
import mx.ipn.escom.cdt.util.action.ActionSupportCDT;

/* Conexion a la vista
 * Nombre del paquete despues de la carpeta /pages en webapp
 * dentro de /pages:
 * 	---/admision (Namespace, nombre del paquete que engloba la entidad completa)
 * 	-----/gestionar-aspirante (nombre en minusculas de la clase con guion entre cada palabra)
 * */
@Namespace("/admision") // ve a este folder para mis vistas

/*
 * Dentro de struts manejamos parte de la navegación mediante Results, en el
 * action podemos hacer que se regresen ciertos resultados al realizar ciertas
 * acciones
 *
 * Un resultado en especifico realizará su correspondiente redireccion, hay dif.
 * tipos de resultados --Resultados globales: Se configuran en el struts.xml y
 * son accesibles en todos los actions.
 * 
 * Si no hay sesion iniciada, usaremos una exception que arroje un resultado
 * "noAutorizado" en el struts.xml tendremos
 * 
 * <global-results> <result name="noAutorizado">/pages/accessDenied.jsp</result>
 * </global-results>
 * 
 * --Resultados individuales: Se configuran para cada página.
 * 
 * params = {"llave","valor"}
 */
@Results({
		@Result(name = "success", type = "redirectAction", params = { "actionName",
				"../admision/gestionar-aspirante" }),
		@Result(name = "successAspirante", type = "redirectAction", params = { "actionName",
				"../admision/gestionar-aspirante" }) })

/*
 * Permite salirnos de la convencion de REST y agregar nuestros propios metodos:
 * url: /contextPath/namespace/action!nombreMetodo jsp: index-nombreMetodo.jsp
 * Action: public String nombreMetodo(){ return "nombreMetodo" }
 */
@AllowedMethods({ "vDelete" })
public class GestionarAspiranteAct extends ActionSupportCDT implements ModelDriven<Aspirante> {
	private static final long serialVersionUID = -2318881314579583272L;
	private Aspirante model;

	/* Uso de un Businnes creado por nosotros */
	@Autowired
	private AspiranteBs aspiranteBs;

	/*
	 * Declaracion de los metodos REST, siempre retornan un String, este String
	 * se hereda de ActtionSupportCDT y contruye el jsp correspondiente para ser
	 * devuelto al cliente
	 */
	public String index() {
		// guardado en ActionSupportCDT
		return INDEX;
	}

	public void validateCreate() {
		/*
		 * Los validators no retornan un valor Hay dos tipos de errores:
		 * 
		 * -FieldErrors -ActionErrors
		 */

		if ((model.getNombre().length() < 1 && model.getNombre().length() > 10)
				|| (model.getPrimerAp().length() < 1 && model.getPrimerAp().length() > 10)) {
			System.out.println("Con longitud invalida");
			addActionError("ERROR: longitud invalida");
		}
		addActionError("ERROR: longitud invalida");
		System.out.println("Validator Create");
	}

	public String create() {
		System.out.println("Create \n Nombre: " + model.getNombre() + " Paterno: " + model.getPrimerAp() + " Materno: "
				+ model.getSegundoAp() + " Curp: " + model.getCurp());
		aspiranteBs.save(model);
		return "successAspirante";
	}

	public void validateUpdate() {
		System.out.println("Validator Update");
	}

	public String update() {
		System.out.println("Update");
		return INDEX;
	}

	public void validateDelete() {
		System.out.println("Validator Delete");
	}

	public String delete() {
		System.out.println("Delete");
		return DELETE;
	}

	public String editNew() {
		return EDITNEW;
	}

	public String edit() {
		return EDIT;
	}

	public String show() {
		return SHOW;
	}

	public String vDelete() {
		return "vDelete";
	}

	/* Getters & Setters */
	public Aspirante getModel() {
		return model;
	}

	public void setModel(Aspirante model) {
		this.model = model;
	}

}
