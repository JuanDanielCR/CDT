package mx.ipn.escom.cdt.util.bs;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.util.dao.GenericDao;
import mx.ipn.escom.cdt.util.mapeo.Modelo;

/**
 * 
 * Implementación de métodos genéricos que permiten realizar búsquedas en al BD
 * 
 * @author Hermes Francisco Montes Casiano
 * @version 1.0 "Sep 11, 2015"
 */
@Service("genericSearchBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericSearchBs {

	/**
	 * Objeto singleton que permite realizar operaciones en la base de datos
	 */
	@Autowired
	private GenericDao genericDao;

	/**
	 * Realiza la búsqueda de una entidad con base a su clase y su identificador
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} clase de la cual se quiere el elemento que se desea
	 *            buscar
	 * @param {@link
	 * 			Serializable} identificador del elemento que se está buscando
	 *            en la base de datos
	 * @return elemento que coincide con la clase y el identificador
	 *         seleccionados
	 */
	@Transactional(readOnly = true)
	public <C extends Modelo> C findById(Class<C> clazz, Serializable id) {
		return genericDao.findById(clazz, id);
	}

	/**
	 * Busca una entidad en la base de datos con base en las propiedades
	 * inicializadas en example.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param example
	 *            entidad tomada como ejemplo para realizar la busqueda de un
	 *            elemento en la base de datos
	 * @return elementos que coinciden con el ejemplo tomado como criterio de
	 *         busqueda
	 */
	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findByExample(C example) {
		return genericDao.findByExample(example);
	}

	/**
	 * Obtiene todos los elementos que pertenecen a la clase proporcionada
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} de la cual se quieren obtener todos los elementos
	 * @return elementos que pertenecen a la clase proporcionada
	 */
	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findAll(Class<C> clazz) {
		return genericDao.findAll(clazz);
	}

	/**
	 * Obtiene el número de elementos de una entidad
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param clazz
	 *            de la cual se quiere saber el número de registros
	 * @return número de elementos que tiene una entidad
	 */
	@Transactional(readOnly = true)
	public <C extends Modelo> Integer count(Class<C> clazz) {
		return genericDao.count(clazz);
	}
}
