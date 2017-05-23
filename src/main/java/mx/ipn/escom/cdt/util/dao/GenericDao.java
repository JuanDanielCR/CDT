package mx.ipn.escom.cdt.util.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.eld.calendario.mapeo.FaseActividad;
import mx.edu.eld.calendario.mapeo.Criterio;
import mx.edu.eld.calendario.mapeo.Requisito;
import mx.ipn.escom.cdt.util.Numeros;
import mx.ipn.escom.cdt.util.mapeo.Modelo;

/**
 * Clase generica pertenenciente a la capa de Acceso a Datos que permite
 * realizar operaciones en la base de datos
 * 
 * @author Hermes Francisco Montes Casiano
 * @version 1.0 "Sep 08, 2015"
 */
@Repository("genericDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericDao {

	/**
	 * Permite el manejo de la session de hibernate
	 */
	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * Devuelve el elemento de tipo C con base en el id especificado.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param clazz
	 *            clase generica de la cual se quiere obtener un resultado
	 * @param id
	 *            identificador del elemento que se esta buscando en la base de
	 *            datos
	 * @return elemento que coincide con los parametros de busqueda en la base
	 *         de datos
	 */
	public <C extends Modelo> C findById(Class<C> clazz, Serializable id) {
		sessionFactory.getCurrentSession().clear();
		return (C) sessionFactory.getCurrentSession().get(clazz, id);
	}

	/**
	 * Devuelve los elementos que cumplen con los valores inicializados en
	 * example.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param example
	 *            elemento tomado como ejemplo para realizar una busqueda
	 * @return elementos que coinciden con el criterio de busqueda
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findByExample(C example) {
		return (List<C>) sessionFactory.getCurrentSession().createCriteria(example.getClass())
				.add(Example.create(example)).list();
	}

	/**
	 * Devuelve todos los registros de tipo C existentes.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param clazz
	 *            clase de la cual se quieren obtener todos los elementos
	 * @return elementos que pertencen a la clase de datos tomada como parámetro
	 *         en la busqueda
	 */
	public <C extends Modelo> List<C> findAll(Class<C> clazz) {
		// Get Criteria Builder
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();

		// Create Criteria
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		criteria.from(clazz);

		// Extract and Result
		List<C> list = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
		System.out.println("----->" + list.size());
		return list;
	}

	/**
	 * Persiste el elemento de tipo C.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param entity
	 *            elemento que quiere ser persistido en la base de datos
	 * @return elemento que ha sido persistido en la base de datos
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C save(C entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		return entity;
	}

	/**
	 * Persiste una lista de elementos de tipo C.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param list
	 *            coleccion de elementos que quieren ser persistidos en la base
	 *            de datos
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void save(List<C> list) {
		for (C entity : list) {
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
	}

	/**
	 * Actualiza el elemento de tipo C especificado.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que quiere ser actualizado
	 * @return {@link Class} elemento que ha sido actualizado
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C update(C entity) {
		sessionFactory.getCurrentSession().update(entity);
		sessionFactory.getCurrentSession().flush();
		return entity;
	}

	/**
	 * Actualiza el elemento de tipo C especificado.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que quiere ser actualizado
	 * @return {@link Class} elemento que ha sido actualizado
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void update(List<C> list) {
		for (C entity : list) {
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	/**
	 * Elimina el elemento de tipo C especificado.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param {@link
	 * 			Class} elemento que quiere ser eliminado de la base de datos
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void delete(C entity) {
		System.err.println(entity);
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * Actualiza el estado de un objeto que se encuentra en la sessión de
	 * hibernate a su estado en la base de datos.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param entity
	 *            entidad que quiere ser refrescada en la sesión de Hibernate
	 * @return entidad después de haber sido refrescada de la sesión de
	 *         Hibernate
	 */
	public <C extends Modelo> C refreshEntity(C entity) {
		sessionFactory.getCurrentSession().refresh(entity);
		return entity;
	}

	/**
	 * Limpia la sesión de Hibernate
	 * 
	 * @author Hermes Francisco Montes Casiano
	 */
	public void clear() {
		sessionFactory.getCurrentSession().clear();
	}

	/**
	 * Cuenta el total de registros existentes de tipo C.
	 * 
	 * @author Jorge Álvarez
	 * @param {@link
	 * 			Class} de la cual se quiere contar el numero de registros
	 * @return número de registros por clase
	 */
	@SuppressWarnings("deprecation")
	public <C extends Modelo> Integer count(Class<C> clazz) {
		return ((Number) sessionFactory.getCurrentSession().createCriteria(clazz.getCanonicalName())
				.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

	/**
	 * Método que permite identificar si un atributo se encuentra duplicado.
	 * 
	 * @author Hermes Francisco Montes Casiano
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
	public <C extends Modelo> Boolean existByAttribute(Class<C> clazz, String nombreAtributo, String nombreIdAtributo,
			String valorAtributo, Serializable valorIdAtributo) {
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		Root<C> root = criteria.from(clazz);
		criteria.where(builder.equal(root.get(nombreAtributo), valorAtributo));
		criteria.where(builder.notEqual(root.get(nombreIdAtributo), valorIdAtributo));
		List<C> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
		return !result.isEmpty();

	}

	/**
	 * Método que permite identificar si un atributo se encuentra duplicado.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param clazz
	 *            Clase en la cual se buscará la existencia del atributo
	 * @param nombreAtributo
	 *            nombre de la propiedad mapeada
	 * @param valorAtributo
	 *            valor que se verificará que no exista en la base de datos
	 * @return
	 */
	public <C extends Modelo> Boolean existByAttribute(Class<C> clazz, String nombreAtributo, String valorAtributo) {
		sessionFactory.getCurrentSession().clear();
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		Root<C> root = criteria.from(clazz);
		criteria.where(builder.equal(root.get(nombreAtributo), valorAtributo));
		List<C> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
		return !result.isEmpty();
	}

	/**
	 * Copia el estado del objeto proporcionado en un objeto persistente con el
	 * mismo identificador, forzando a la sesión a liberarse.
	 * 
	 * @author Hermes Francisco Montes Casiano
	 * @param entity
	 * @return
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C updateMerge(C entity) {
		sessionFactory.getCurrentSession().merge(entity);
		sessionFactory.getCurrentSession().flush();
		return entity;
	}

	/**
	 * Verifica la unicidad del modelo por la propiedad especificada.
	 * 
	 * @param clazz
	 *            {Class} Clase del modelo.
	 * @param propiedad
	 *            {String} Propiedad a validar.
	 * @param valor
	 *            {Object} Objeto a validar.
	 * @param id
	 *            {Serializable} Id del modelo a validar, se utiliza en caso de
	 *            modificaciones en el modelo.
	 * @return {Boolean} True si la propiedad ya persisten false si no persiste.
	 */
	public <C extends Modelo> boolean unicidad(Class<C> clazz, String propiedad, Object valor, Serializable id) {
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<C> criteriaQuery = builder.createQuery(clazz);
		Root<C> root = criteriaQuery.from(clazz);
		criteriaQuery.where(
				builder.like(builder.lower(root.<String>get(propiedad)), "%" + valor.toString().toLowerCase() + "%"));
		List<C> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
		if (id != null && (list.size() == Numeros.UNO.getValor())) {
			if (list.get(0) instanceof Criterio) {
				return !((Criterio) list.get(0)).getId().equals(id);
			} else if (list.get(0) instanceof Requisito) {
				return !((Requisito) list.get(0)).getId().equals(id);
			} else if (list.get(0) instanceof FaseActividad) {
				return !((FaseActividad) list.get(0)).getId().equals(id);
			}
		}
		return (list.isEmpty()) ? false : true;
	}
}
