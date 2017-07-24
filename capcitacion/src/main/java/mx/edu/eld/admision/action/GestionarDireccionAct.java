package mx.edu.eld.admision.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import mx.edu.eld.admision.bs.DireccionBs;
import mx.edu.eld.admision.bs.exception.MaximoNumeroDireccionesException;
import mx.edu.eld.admision.bs.exception.MaximoNumeroDireccionesException.DireccionFueraRangoEnum;
import mx.edu.eld.admision.mapeo.AspiranteDireccion;
import mx.edu.eld.admision.mapeo.Direccion;
import mx.edu.eld.sepomex.mapeo.Cp;
import mx.edu.eld.sepomex.mapeo.Entidad;
import mx.edu.eld.sepomex.mapeo.Municipio;
import mx.ipn.escom.cdt.util.action.ActionSupportCDT;
import mx.ipn.escom.cdt.util.action.NombreObjetosSesion;
import mx.ipn.escom.cdt.util.action.SessionManager;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;
import mx.ipn.escom.cdt.util.mapeo.AjaxResult;

@Namespace("/admision")
@Results({
	@Result(name = "success", type = "redirectAction", params = { "actionName",	"../admision/gestionar-aspirante" }),
	@Result(name ="showMunicipios", type="json", params = { "root", "action", "includeProperties", "ajaxResult.*" })
		})
@AllowedMethods({"obtenerMunicipios","autocompletarCp"})
public class GestionarDireccionAct extends ActionSupportCDT implements ModelDriven<Direccion> {

	private static final long serialVersionUID = -2507489284310743134L;
	/*
	 * Recuperar parametro a traves de una URL en struts 2: 1. Crear un
	 * propiedad con el mismo nombre del parametro pasado en la URL. 2. Crear
	 * los getters y setters correspondientes.
	 * 
	 * Nota: Cuando pasemos id's por parametro, usaremos el Sufijo -sel- para
	 * que no tenga conflictos con algún otro parametro que llegue a llamarse
	 * igual y sea traido por el ModelDriven
	 */
	
	private Direccion model;
	private Cp codigoPostal;
	
	/* Nombrar todas las variables que no sean el 'model' con el sufijo SEL */
	private AspiranteDireccion aspiranteDireccionSel;
	private Integer idSel;
	private Integer idAspiranteSel;
	private String idEstadoSel;
	private String cpSel;
	private Entidad entidadSel;
	private Municipio municipioSel;

	private List<Entidad> listaEstados;
	private List<Municipio> listaMunicipios;
	private List<Cp> listaCodigos;
	private List<String> listaColonias;
	/*
	 * Variables usada por la relacion One To Many de Direccion con
	 * AspiranteDireccion
	 */
	private List<AspiranteDireccion> listaAspiranteDirecciones;
	
	private AjaxResult ajaxResult;

	@Autowired
	private DireccionBs direccionBs;
	
	@Autowired
	private GenericSearchBs genericSearch;

	/* Pagina principal para la revisión de las direcciones existentes */
	public String index() {
		//este idAspiranteSel es pasado po url, ya que es la primera ves que se accede a su setter
		aspiranteDireccionSel = new AspiranteDireccion(null, null, idAspiranteSel);
		//OBteniendo la Lista de 
		listaAspiranteDirecciones = genericSearch.findByExample(aspiranteDireccionSel);
		return INDEX;
	}

	/* Creación de una nueva dirección */
	/* Formulario para la creación para una nueva direccion */
	public String editNew() {
		listaMunicipios = new ArrayList<>();
		listaEstados = genericSearch.findAll(Entidad.class);
		return EDITNEW;
	}

	public void validateCreate() throws Exception {
		System.out.println(getFieldErrors());
		//Aqui ya se guarda el valor de idAspirante mediante una a llamada un getter que internamente hace una llamada a una session
		getIdAspiranteSel();
		/* Mensajes de error:
		 * 
		 * ACTION ERROR - <s:actionerror theme="%{getText('mx.edu.eld.defaulTheme')}"/>
		 * 	addActionError("Erroooooorrrrr");
		 * FIELD ERROR  - <s:fielderror fieldName="model.nombre" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
		 * 	addFieldError("model.nombre", "Error en el campo nombre");
		 * 
		 * if (!hasErrors()) {
		 *	try {
		 *		direccionBs.guardar(model, idAspiranteSel);
	 	 *	} catch (MaximoNumeroDireccionesException e) {
		 * 		if(e.getCausa() == ActividadFueraCicloEnum.FECHA_FIN){......}
		 *	}
		 * }
		 * */
		
		// Field error o ActionError
		if (!hasErrors()) {
			try{
				direccionBs.guardar(model, idAspiranteSel);
			}catch(MaximoNumeroDireccionesException e){
				if(e.getCausa()== DireccionFueraRangoEnum.MAX_DIRECCIONES){
					addActionError(getText("EX-NUM_DIR"));
				}else if(e.getCausa()== DireccionFueraRangoEnum.ESTADO){
					addActionError(getText("EX-EST"));
				}else if(e.getCausa()== DireccionFueraRangoEnum.OAXACA_ESTADO){
					addActionError(getText("EX-OAX"));
				}else if(e.getCausa()== DireccionFueraRangoEnum.DURANGO_ESTADO){
					addActionError(getText("EX-DUR"));
				}else if(e.getCausa()== DireccionFueraRangoEnum.PUEBLA_ESTADO){
					addActionError(getText("EX-PUE"));
				}else{
					addActionError(getText("EX-OUCH"));
				}
			}
		}
		if(hasErrors()){
			listaMunicipios =  new ArrayList<>();
			listaEstados = genericSearch.findAll(Entidad.class);
		}
	}

	public String create() {
		return "success";
	}
	
	/* Actualización de una direccion */
	/* Formulario de actualización para una dirección */
	public String edit() {
		return EDIT;
	}

	public void validateUpdate() {

	}

	public String update() {
		direccionBs.update(model);
		return "success";
	}

	public void validateDelete() {

	}

	public String delete() {
		direccionBs.delete(model);
		return "succes";
	}
	public String obtenerMunicipios(){
		getAjaxResult();
		ajaxResult = direccionBs.obtenerMunicipios(idEstadoSel);
		listaMunicipios = new ArrayList<>();
		SessionManager.put(NombreObjetosSesion.AJAX_RESULT,ajaxResult);
		return "showMunicipios";
	}
	
	public String autocompletarCp(){
		
		codigoPostal = new Cp(null, null, null, cpSel, null, null, null);
		/*Información del Codigo Postal*/
		listaCodigos = genericSearch.findByExample(codigoPostal);
		
		/*Obteniendo el estado*/
		entidadSel = genericSearch.findById(Entidad.class, listaCodigos.get(0).getIdEntidad());
		
		/*Obteniendo el municipio*/
		municipioSel =  new Municipio(null, null, null, listaCodigos.get(0).getCiudad(), null);

		listaMunicipios = genericSearch.findByExample(municipioSel);

		municipioSel = listaMunicipios.get(0);
		municipioSel.setNombre(listaCodigos.get(0).getCiudad());

		/*Obteniendo las posibles colonias*/
		listaColonias = direccionBs.obtenerColonias(listaCodigos);
		
		return "autocompletar";
	}
	
	/*Tag para indicar que ciertos validators deberan ser aplicados*/
	@VisitorFieldValidator
	public Direccion getModel() {
		return model;
	}

	public void setModel(Direccion model) {
		this.model = model;
	}

	public DireccionBs getDireccionBs() {
		return direccionBs;
	}

	public void setDireccionBs(DireccionBs direccionBs) {
		this.direccionBs = direccionBs;
	}

	public GenericSearchBs getGenericSearch() {
		return genericSearch;
	}

	public void setGenericSearch(GenericSearchBs genericSearch) {
		this.genericSearch = genericSearch;
	}

	public List<AspiranteDireccion> getListaAspiranteDirecciones() {
		return listaAspiranteDirecciones;
	}

	public void setListaAspiranteDirecciones(List<AspiranteDireccion> listaAspiranteDirecciones) {
		this.listaAspiranteDirecciones = listaAspiranteDirecciones;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		if (idSel != null) {
			model = genericSearch.findById(Direccion.class, idSel);
		}
		this.idSel = idSel;
	}

	public Integer getIdAspiranteSel() {
		if(SessionManager.get(NombreObjetosSesion.SESSION_MODEL_ID) != null){
			idAspiranteSel = (Integer) SessionManager.get(NombreObjetosSesion.SESSION_MODEL_ID);
		}
		return idAspiranteSel;
	}

	public void setIdAspiranteSel(Integer idAspiranteSel) {
		if (idAspiranteSel != null) {
			SessionManager.put(NombreObjetosSesion.SESSION_MODEL_ID, idAspiranteSel);
		}
		this.idAspiranteSel = idAspiranteSel;
	}

	public AspiranteDireccion getAspiranteDireccionSel() {
		return aspiranteDireccionSel;
	}

	public void setAspiranteDireccionSel(AspiranteDireccion aspiranteDireccionSel) {
		this.aspiranteDireccionSel = aspiranteDireccionSel;
	}

	public List<Entidad> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Entidad> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Municipio> getListaMunicipios() {
		return listaMunicipios;
	}

	public void setListaMunicipios(List<Municipio> listaMunicipios) {
		this.listaMunicipios = listaMunicipios;
	}

	public String getIdEstadoSel() {
		return idEstadoSel;
	}

	public void setIdEstadoSel(String idEstadoSel) {
		this.idEstadoSel = idEstadoSel;
	}

	public String getCpSel() {
		return cpSel;
	}

	public void setCpSel(String cpSel) {
		this.cpSel = cpSel;
	}

	public Cp getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Cp codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Cp> getListaCodigos() {
		return listaCodigos;
	}

	public void setListaCodigos(List<Cp> listaCodigos) {
		this.listaCodigos = listaCodigos;
	}

	public Entidad getEntidadSel() {
		return entidadSel;
	}

	public void setEntidadSel(Entidad entidadSel) {
		this.entidadSel = entidadSel;
	}

	public List<String> getListaColonias() {
		return listaColonias;
	}

	public void setListaColonias(List<String> listaColonias) {
		this.listaColonias = listaColonias;
	}
	@JSON(name = "ajaxResult")
	public AjaxResult getAjaxResult() {
		this.ajaxResult = (AjaxResult) SessionManager.get(NombreObjetosSesion.AJAX_RESULT);
        if (ajaxResult == null) {
            ajaxResult = new AjaxResult();
            SessionManager.put(NombreObjetosSesion.AJAX_RESULT, ajaxResult);
        }
        return ajaxResult;
	}

	public void setAjaxResult(AjaxResult ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	
	public Municipio getMunicipioSel() {
		return municipioSel;
	}

	public void setMunicipioSel(Municipio municipioSel) {
		this.municipioSel = municipioSel;
	}
	
}
