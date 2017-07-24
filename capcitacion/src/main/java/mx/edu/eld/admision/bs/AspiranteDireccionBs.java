package mx.edu.eld.admision.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.edu.eld.admision.mapeo.AspiranteDireccion;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("aspiranteDireccionBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AspiranteDireccionBs extends GenericBs<AspiranteDireccion>{
	
}
