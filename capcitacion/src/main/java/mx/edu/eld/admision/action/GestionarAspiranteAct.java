package mx.edu.eld.admision.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import mx.edu.eld.admision.bs.AspiranteBs;
import mx.edu.eld.admision.mapeo.Aspirante;
import mx.ipn.escom.cdt.util.action.ActionSupportCDT;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;

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
	private List<Aspirante> listAspirantes;
	private Integer idSel;
	/* Uso de un Businnes creado por nosotros */
	@Autowired
	private AspiranteBs aspiranteBs;
	@Autowired
	private GenericSearchBs genericSearch;

	/*
	 * Declaracion de los metodos REST, siempre retornan un String, este String
	 * se hereda de ActtionSupportCDT y contruye el jsp correspondiente para ser
	 * devuelto al cliente
	 */
	public String index() {
		// guardado en ActionSupportCDT
		listAspirantes = genericSearch.findAll(Aspirante.class);
		return INDEX;
	}

	public void validateCreate() {
		/*
		 * Los validators nos retornan un valor Hay dos tipos de errores:
		 * 
		 * -FieldErrors -ActionErrors
		 * 
		 * if ((model.getNombre().length() < 1 || model.getNombre().length() >
		 * 10) || (model.getPrimerAp().length() < 1 ||
		 * model.getPrimerAp().length() > 10)) {
		 * System.out.println("Con longitud invalida");
		 * addActionError("ERROR: longitud invalida"); }
		 */
		// addFieldError("model.segundoAp", "Error de Negocio");
		System.out.println("Validator Create");
		System.out.println(getFieldErrors());
	}

	public String create() {
		System.out.println("Create \n Nombre: " + model.getNombre() + " Paterno: " + model.getPrimerAp() + " Materno: "
				+ model.getSegundoAp() + " Curp: " + model.getCurp());
		aspiranteBs.save(model);
		return "successAspirante";
	}


	public void validateDestroy() {
		System.out.println("Validator Destroy");
	}

	public String destroy() {
		aspiranteBs.delete(model);
		return "success";
	}

	public void validateUpdate() {
		System.out.println("Validator Update");
	}

	public String update() {
		System.out.println("Update");
		aspiranteBs.update(model);
		return "success";
	}

	public void validateDelete() {
		System.out.println("Validator Delete");
	}

	public String delete() {
		aspiranteBs.delete(model);
		return DELETE;
	}

	public String editNew() {
		return EDITNEW;
	}

	public String edit() {

		return EDIT;
	}

	public String show() {
		System.out.println(model.toString());
		return SHOW;
	}

	public String vDelete() {
		return "vDelete";
	}

	/* Getters & Setters */
	@VisitorFieldValidator
	public Aspirante getModel() {
		return model;
	}

	public void setModel(Aspirante model) {
		this.model = model;
	}

	/**
	 * @return the listAspirantes
	 */
	public List<Aspirante> getListAspirantes() {
		return listAspirantes;
	}

	/**
	 * @param listAspirantes
	 *            the listAspirantes to set
	 */
	public void setListAspirantes(List<Aspirante> listAspirantes) {
		this.listAspirantes = listAspirantes;
	}

	/**
	 * @return the aspiranteBs
	 */
	public AspiranteBs getAspiranteBs() {
		return aspiranteBs;
	}

	/**
	 * @param aspiranteBs
	 *            the aspiranteBs to set
	 */
	public void setAspiranteBs(AspiranteBs aspiranteBs) {
		this.aspiranteBs = aspiranteBs;
	}

	/**
	 * @return the genericSearch
	 */
	public GenericSearchBs getGenericSearch() {
		return genericSearch;
	}

	/**
	 * @param genericSearch
	 *            the genericSearch to set
	 */
	public void setGenericSearch(GenericSearchBs genericSearch) {
		this.genericSearch = genericSearch;
	}

	/**
	 * @return the idSel
	 */
	public Integer getIdSel() {
		return idSel;
	}

	/**
	 * @param idSel
	 *            the idSel to set
	 */
	public void setIdSel(Integer idSel) {
		if (idSel != null) {
			model = genericSearch.findById(Aspirante.class, idSel);
		}
		this.idSel = idSel;
	}

}
