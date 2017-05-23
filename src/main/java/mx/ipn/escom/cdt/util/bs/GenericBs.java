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
 * Clase generica perteneciente a la capa del negocio, la cual permite
 * implemntar las reglas de negocio necesarias para realizar operaciones en la
 * capa de DAO
 * 
 * @author Hermes Francisco Montes Casiano
 * @version 1.0 "Sep 08, 2015"
 * 
 * @param <T>
 *            Tipo de dato del negocio
 */
@Service("genericBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericBs<T extends Modelo> {

	/**
	 * Objeto singleton que permite realizar operaciones en la capa de DAO
	 */
	@Autowired
	protected GenericDao genericDao;

	/**
	 * Objeto singleton que permite realizar busquedas genéricas
	 */
	@Autowired
	protected GenericSearchBs genericSearchBs;

	/**
	 * Persiste un elemento en la base de datos
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que se quiere persistir
	 * @return {@link Serializable} Llave del objeto registrado
	 */
	@Transactional(rollbackFor = Exception.class)
	public T save(T entity) {
		return genericDao.save(entity);
	}

	/**
	 * Persiste un conjunto de elementos en la base de datos
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			List} elementos que quieren ser persistidos en la base de
	 *            datos
	 */
	@Transactional(rollbackFor = Exception.class)
	public <C extends Modelo> void save(List<C> list) {
		genericDao.update(list);
	}

	/**
	 * Actualiza un elemento en la base de datos
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que se quiere actualizar
	 * @return: {@link Class} Objeto actualizado
	 */
	@Transactional(rollbackFor = Exception.class)
	public T update(T entity) {
		return genericDao.update(entity);
	}

	/**
	 * Actualiza un conjunto de elementos en la base de datos
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que se quiere actualizar
	 * @return: {@link Class} Objeto actualizado
	 */
	@Transactional(rollbackFor = Exception.class)
	public <C extends Modelo> void update(List<C> list) {
		genericDao.update(list);
	}

	/**
	 * Actualiza un elemento en la base de datos
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que se quiere actualizar
	 * @return: {@link Class} Objeto actualizado
	 */
	@Transactional(rollbackFor = Exception.class)
	public T updateMarge(T entity) {
		return genericDao.updateMerge(entity);
	}

	/**
	 * Eelimina un elemento en la base de datos
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} que se desea eliminar de la base de datos
	 */
	@Transactional(rollbackFor = Exception.class)
	public void delete(T entity) {
		genericDao.delete(entity);
	}

	/**
	 * Limpia la sesión de Hibernate
	 * 
	 * @author Hermes Francisco Montes Casiano
	 */
	public void clear() {
		genericDao.clear();
	}

	/**
	 * Verifica si un atributo se encuentra duplicado y que dicho valor
	 * pertenezca a un registro con identificador distinto a id.
	 * 
	 * @param clazz
	 *            Clase en la cual se buscará la existencia del atributo
	 * @param nombreAtributo
	 *            nombre de la propiedad mapeada
	 * @param nombreIdAtributo
	 *            nombre de la propiedad a la que hace referencia el Id
	 * @param valorAtributo
	 *            valor que se verificará que no exista en la base de datos
	 * @param id
	 *            identificador de la persona
	 * @return
	 */
	@Transactional(readOnly = true)
	public Boolean existeAtributo(Class<T> clazz, String nombreAtributo, String nombreIdAtributo, String valorAtributo,
			Serializable idAtributo) {
		return genericDao.existByAttribute(clazz, nombreAtributo, nombreIdAtributo, valorAtributo, idAtributo);
	}

	/**
	 * Verifica si un atributo se encuentra duplicado.
	 * 
	 * @param clazz
	 *            Clase en la cual se buscará la existencia del atributo
	 * @param nombreAtributo
	 *            nombre de la propiedad mapeada
	 * @param valorAtributo
	 *            valor que se verificará que no exista en la base de datos
	 * @return
	 */
	@Transactional(readOnly = true)
	public Boolean existeAtributo(Class<T> clazz, String nombreAtributo, String valorAtributo) {
		return genericDao.existByAttribute(clazz, nombreAtributo, valorAtributo);
	}
}
