package mx.edu.eld.admision.bs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.eld.admision.mapeo.AspiranteDireccion;
import mx.edu.eld.admision.mapeo.Direccion;
import mx.edu.eld.bs.rules.ReglaNegocioN1;
import mx.edu.eld.sepomex.mapeo.Cp;
import mx.edu.eld.sepomex.mapeo.Municipio;
import mx.ipn.escom.cdt.util.bs.GenericBs;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;
import mx.ipn.escom.cdt.util.mapeo.AjaxResult;
import mx.ipn.escom.cdt.util.mapeo.AjaxResult.EnumRespuestaAjax;

/* Reglas de negocio:
 * 1. Un aspirante no puede tener más de 3 direcciones asignadas
 * 2. La direccion no es aceptada si los estados son: Oaxaca, Durango, Sonora
 * 
 * Exception: Crear un clase con el sufijo Exception.
 *  Cada regla de negocio tendrá su respectiva clase de Exception
 *  
 *  ENUM: Nos permitira saber las causas concretas de la Exception, de a la eleccion del ENUM que hagamos
 * 	
 * 	---Agregar la sentencia throws NombreDeMiException
 *  ---throw new ConstructorException(NombreEnum.OPCION)
 *  
 *  if(true){
 *		throw new MaximoNumeroDireccionesException(ActividadFueraCicloEnum.FECHA_FIN);
 *	}
 * */


@Service("direccionBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DireccionBs extends GenericBs<Direccion>{
	
	@Autowired
	GenericSearchBs genericSearch;
	
	@Autowired
	AspiranteDireccionBs aspiranteDireccionBs;
	
	@Autowired
	ReglaNegocioN1 reglaNegocioN1;
	
	@Transactional(rollbackFor = Exception.class)
	public void guardar(Direccion model, Integer idAspiranteSel) throws Exception {
		//El usuario tiene menos de 3 direcciones
		if(reglaNegocioN1.validate(idAspiranteSel, model.getIdEntidad())){
			model = save(model);
			AspiranteDireccion aspiranteDireccionSel = new AspiranteDireccion(0,model.getId(),idAspiranteSel);
			aspiranteDireccionBs.save(aspiranteDireccionSel);
		}
		
	}

	public List<String> obtenerColonias(List<Cp> listaCodigos) {
		List<String> colonias = new ArrayList<>();
		for (Cp codigo : listaCodigos) {
			colonias.add(codigo.getAsentamiento());
		}
		return colonias;
	}
	
	public AjaxResult obtenerMunicipios(String idEstadoSel){
		AjaxResult ajaxResult;
		Municipio municipio = new Municipio(null, idEstadoSel, null, null, true);
		List<Municipio> listaMunicipios = genericSearch.findByExample(municipio);
		ajaxResult = new AjaxResult();
		if(listaMunicipios.size()>0){
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("listaMunicipios", listaMunicipios);
		}else{
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
		}
		
		return ajaxResult;
	}
	
	
}
