package mx.edu.eld.admision.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.edu.eld.admision.mapeo.Aspirante;
import mx.ipn.escom.cdt.util.bs.GenericBs;

/*Permite poner el Business disponible como un servicio para los actions de la 
 * aplicacion todos los acciones que contengan una instancia de este bussines podrán
 * hacer uso de este busin*/
@Service("aspiranteBs")
/* Aplica el patron de diseño SIngleton a un Business */
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AspiranteBs extends GenericBs<Aspirante> {

}
