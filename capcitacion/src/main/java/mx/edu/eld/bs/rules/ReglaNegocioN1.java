package mx.edu.eld.bs.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.edu.eld.admision.bs.exception.MaximoNumeroDireccionesException;
import mx.edu.eld.admision.bs.exception.MaximoNumeroDireccionesException.DireccionFueraRangoEnum;
import mx.edu.eld.admision.mapeo.AspiranteDireccion;
import mx.edu.eld.sepomex.mapeo.Entidad;
import mx.ipn.escom.cdt.util.PropertyAccess;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;
import mx.ipn.escom.cdt.util.exception.AccessPropertyException;

@Service("reglaNegocioN1")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class ReglaNegocioN1 implements ReglaNegocio{
	
	@Autowired
	GenericSearchBs genericSearch;
	
	public boolean validate(Integer idAspiranteSel, String idEstado) throws Exception{
		
		if(direccionesDisponibles(idAspiranteSel)){
			if(estadoHabilitado(idEstado)){
				return true;
			}
		}
		return false;
	}
	
	public boolean direccionesDisponibles(Integer idAspiranteSel) throws AccessPropertyException, MaximoNumeroDireccionesException{
		AspiranteDireccion aspiranteDireccionSel = new AspiranteDireccion(0,null,idAspiranteSel);
		List<AspiranteDireccion> direccionesActuales = genericSearch.findByExample(aspiranteDireccionSel);
		if(direccionesActuales.size() < PropertyAccess.getIntegerProperty("mx.edu.eld.maxDirecciones.aspirante") ){
			System.out.println("Size: "+direccionesActuales.size());
			return true;
		}else{
			throw new MaximoNumeroDireccionesException(DireccionFueraRangoEnum.MAX_DIRECCIONES);
		}
	}
	
	/* Código de Errores 
	 * 0 - Correcto
	 * 1 - Estado
	 * 2 - Oaxaca
	 * 3 - Durango
	 * 4 - Puebla
	 * */
	public boolean estadoHabilitado(String idEstado) throws MaximoNumeroDireccionesException {
		Entidad entidadActual =  genericSearch.findById(Entidad.class, idEstado);
		String idActual = entidadActual.getId();
		if(idActual.equals("20") ){
			throw new MaximoNumeroDireccionesException(DireccionFueraRangoEnum.OAXACA_ESTADO);
		}else if(idActual.equals("10")){
			throw new MaximoNumeroDireccionesException(DireccionFueraRangoEnum.DURANGO_ESTADO);
		}else if(idActual.equals("21")){
			throw new MaximoNumeroDireccionesException(DireccionFueraRangoEnum.PUEBLA_ESTADO);
		}
		return true;
	}
}
