package mx.ipn.escom.cdt.util.bs;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.eld.admision.action.GestionarContactosAct;
import mx.edu.eld.admision.mapeo.Aspirante;
import mx.edu.eld.admision.mapeo.Contacto;
import mx.edu.eld.bs.rules.ReglaNegocioN15;
import mx.edu.eld.bs.rules.ReglaNegocioS10;
import mx.edu.eld.informacionbase.dao.ContactoDao;
import mx.edu.eld.informacionbase.mapeo.CategoriaContacto.EnumCategoriaContacto;
import mx.edu.eld.informacionbase.mapeo.TipoContacto.EnumTipoContacto;
import mx.ipn.escom.cdt.util.Constantes;
import mx.ipn.escom.cdt.util.Numeros;
import mx.ipn.escom.cdt.util.action.Error;
import mx.ipn.escom.cdt.util.bs.exception.ContactoFormatosException;
import mx.ipn.escom.cdt.util.bs.exception.ContactoObligatoriosException;
import mx.ipn.escom.cdt.util.bs.exception.ContactoObligatoriosException.campoObligatorio;
import mx.ipn.escom.cdt.util.bs.exception.ContactosLimiteException;
import mx.ipn.escom.cdt.util.mapeo.Modelo;

/**
 * Clase generica de un contacto perteneciente a la capa del negocio, la cual
 * permite implementar las reglas de negocio necesarias a un objeto Contacto
 * para realizar operaciones en la capa de DAO
 * 
 * @author Er-ramani Velasco Rosete
 * @version 1.0 "Abr 28, 2017"
 * 
 * @param <T>
 *            Tipo de dato del negocio/por definir
 */
@Service("contactoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ContactoBs {

	@Autowired
	private ContactoDao contactoDao;

	@Autowired
	private GenericBs<Modelo> genericBs;

	@Autowired
	private GenericSearchBs genericSearchBs;
	
	@Autowired
	private ReglaNegocioN15 reglaNegocioN15;
	
	private Error errorAux;

	private static final Properties properties;
	private static final Integer MAX_DEFAULT_NUMBER_OF_CONTACTS = 10;
	private static final Integer MIN_DEFAULT_NUMBER_OF_CONTACTS = 0;
	private static final String emergencia = "model.emergencia";


	static {
		properties = new Properties();
		try {
			properties.load(GestionarContactosAct.class.getClassLoader()
					.getResourceAsStream("mx/edu/eld/package_es_MX.properties"));
			properties.load(GestionarContactosAct.class.getClassLoader().getResourceAsStream("global.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public Contacto agregarContacto(Contacto contactoSel) {
		genericBs.save(contactoSel);
		return contactoSel;
	}

	public List<Contacto> obtenerContactos(Aspirante model) {
		return contactoDao.obtenerContactos(model.getId());
	}

	/**
	 * 
	 * @param idSelPersona
	 *            Verifica si el contacto tiene mínimo un contacto de teléfono
	 *            local, teléfono celular y un teléfono de emergencia.
	 * @return true si cumple con lo mínimo, false en caso contrario.
	 */
	@Transactional(readOnly = true)
	public Boolean verificarContactos(Integer idSelPersona) {
		return reglaNegocioN15.validate(idSelPersona);
	}

	/**
	 * Valida que el contacto enviado cumpla con las reglas de negocio y no se
	 * haya alcanzado el límite de contactos por persona.
	 * 
	 * @param contacto
	 * @return true si el contacto es valido
	 */
	@Transactional(readOnly = true)
	public Error addContacto(Contacto contacto, List<Contacto> listContactos, Error error)
			throws ContactoObligatoriosException, ContactosLimiteException, ContactoFormatosException {
		//Boolean valido = false;
		errorAux = error;
		// if (listContactos == null) {
		// listContactos = new ArrayList<>();
		// LOGGER.error("Empty Contacts");
		// }
		if (listContactos.size() <= MAX_DEFAULT_NUMBER_OF_CONTACTS) {
			if (validarContacto(contacto)) {
				// contacto.getId();
				// Boolean duplicated = false;
				// for (Contacto c : listContactos) {
				// if (c.getId() != contacto.getId() &&
				// contacto.equalsValues(c)) {
				// duplicated = true;
				// }
				// }
				// if (!duplicated) {
				// contacto.setText(contactoToString(contacto));
				// listContactos.add(contacto);
				//valido = true;
				// } else {
				// error.add("globalHidden", properties.getProperty("MSG6"));
				// valido = false;
				// }
			}
		} else {
			// throw new ContactosLimiteException();
			errorAux.add("model.globalHidden", properties.getProperty("MSG9"));
			// addFieldError("model.globalHidden",
			// properties.getProperty("MSG9"));
			// valido = false;
		}
		return errorAux;
	}

	public Boolean isValid(List<Contacto> listContactos) {
		int size = listContactos.size();
		return size >= MIN_DEFAULT_NUMBER_OF_CONTACTS && size <= MAX_DEFAULT_NUMBER_OF_CONTACTS;
	}

	/**
	 * Verifica el tipo de contacto que se desea registrar y manda a su
	 * validación correspondiente.
	 * 
	 * @param contacto
	 * @return true si el tipo de contacto fue validado correctamente
	 */
	private Boolean validarContacto(Contacto contacto) throws ContactoObligatoriosException, ContactoFormatosException {
		Boolean valido = false;
		Boolean validoEmergencia = false;
		if (contacto != null && !(contacto.getIdTipo() == null
				|| contacto.getIdTipo().equals(Numeros.UNO_NEGATIVO.getValorInteger()))) {
			if (contacto.getIdTipo().equals(EnumTipoContacto.TELEFONO.getIdTipo())
					|| contacto.getIdTipo().equals(EnumTipoContacto.FAX.getIdTipo())) {
				valido = validarTelefono(contacto);
			} else if (contacto.getIdTipo().equals(EnumTipoContacto.CELULAR.getIdTipo())) {
				valido = validarMobil(contacto);
			} else if (contacto.getIdTipo().equals(EnumTipoContacto.EMAIL.getIdTipo())) {
				valido = validarEmail(contacto);
			} else if (contacto.getIdTipo().equals(EnumTipoContacto.LINKEDIN.getIdTipo())) {
				valido = validarLinkedIn(contacto);
			} else if (contacto.getIdTipo().equals(EnumTipoContacto.FACEBOOK.getIdTipo())) {
				valido = validarFacebook(contacto);
			} else if (contacto.getIdTipo().equals(EnumTipoContacto.TWITTER.getIdTipo())) {
				valido = validarTwitter(contacto);
			} else {
				valido = false;
			}
		} else {
			throw new ContactoObligatoriosException(campoObligatorio.TIPO_CONTACTO);
			// valido = false;

		}
		if (contacto.getIdCategoria() == null) {
			valido = false;
		} else {
			if (contacto.getIdCategoria().equals(EnumCategoriaContacto.EMERGENCIA.getIdCategoria())) {
				validoEmergencia = validarEmergencia(contacto);
			} else {
				validoEmergencia = true;
			}
		}
		return valido && validoEmergencia;
	}

	/**
	 * Valida la sección de emergencia para los contactos con categoría de
	 * emergencia.
	 * 
	 * @param contacto
	 * @return true si fue validado correctamente.
	 */
	private Boolean validarEmergencia(Contacto contacto)
			throws ContactoObligatoriosException, ContactoFormatosException {
		Boolean valido = false;
		if (contacto.getEmergencia() == null || Constantes.CADENA_VACIA.equals(contacto.getEmergencia())) {
			valido = false;
			// throw new
			// ContactoObligatoriosException(campoObligatorio.EMERGENCIA_CONTACTO);
			errorAux.add(emergencia, properties.getProperty("MSG39"));
			// addFieldError("model.emergencia",
			// properties.getProperty("MSG39"));
		} else {
			if (!contacto.getEmergencia().matches(properties.getProperty("mx.ipn.escom.cdt.emergencia"))) {
				valido = false;
				// throw new
				// ContactoFormatosException(ReglaFormato.LETRAS_EMERGENCIA);
				errorAux.add(emergencia, properties.getProperty("MSG3_LETTERS"));
				// addFieldError("model.emergencia",
				// properties.getProperty("MSG3_LETTERS"));
			} else if (contacto.getEmergencia().length() > Numeros.CIEN.getValor()) {
				// throw new
				// ContactoFormatosException(ReglaFormato.MAX_CARACTERES_EMERGENCIA);
				String mensaje = properties.getProperty("MSG41");
				mensaje = mensaje.replace("{0}", "100");
				errorAux.add(emergencia, mensaje);
				// addFieldError("model.emergencia", mensaje);
			} else if (contacto.getEmergencia().length() <= Numeros.DOS.getValor()) {
				// throw new
				// ContactoFormatosException(ReglaFormato.MIN_CARACTERES_EMERGENCIA);
				String mensaje = properties.getProperty("MSG4_MORE");
				mensaje = mensaje.replace("{0}", "2");
				errorAux.add(emergencia, mensaje);
				// addFieldError("model.emergencia", mensaje);
			} else {
				valido = true;
			}
		}
		if (contacto.getRelacion() == null || Constantes.CADENA_VACIA.equals(contacto.getRelacion())) {
			valido = false;
			// throw new
			// ContactoObligatoriosException(campoObligatorio.EMERGENCIA_RELACION);
			errorAux.add("model.relacion", properties.getProperty("MSG39"));
			// addFieldError("model.relacion", properties.getProperty("MSG39"));
		} else {
			if (!contacto.getRelacion().matches(properties.getProperty("mx.ipn.escom.cdt.relationShip"))) {
				valido = false;
				// throw new
				// ContactoFormatosException(ReglaFormato.LETRAS_RELACION);
				errorAux.add("model.relacion", properties.getProperty("MSG3_LETTERS"));
				// addFieldError("model.relacion",
				// properties.getProperty("MSG3_LETTERS"));
			} else if (contacto.getRelacion().length() > Numeros.CINCUENTA.getValor()) {
				// throw new
				// ContactoFormatosException(ReglaFormato.MAX_CARACTERES_RELACION);
				String mensaje = properties.getProperty("MSG41");
				mensaje = mensaje.replace("{0}", "50");
				errorAux.add("model.relacion", mensaje);
				// addFieldError("model.relacion", mensaje);
			} else if (contacto.getRelacion().length() <= Numeros.DOS.getValor()) {
				// throw new
				// ContactoFormatosException(ReglaFormato.MIN_CARACTERES_RELACION);
				String mensaje = properties.getProperty("MSG4_MORE");
				mensaje = mensaje.replace("{0}", "2");
				errorAux.add("model.relacion", mensaje);
				// addFieldError("model.relacion", mensaje);
			} else {
				valido = true;
			}
		}
		return valido;
	}

	/**
	 * Valida el formato de la url y que no esté vacía.
	 * 
	 * @param url
	 * @return
	 */
	private Boolean validarURL(String url) {
		Boolean valido = true;
		if (url == null || Constantes.CADENA_VACIA.equals(url)) {
			// addFieldError("model.contacto", properties.getProperty("MSG39"));
			valido = false;
		} else {
			if (!url.matches(properties.getProperty("mx.ipn.escom.cdt.url"))) {
				// addFieldError("model.contacto",
				// properties.getProperty("MSG3_URL"));
				valido = false;
			}
		}
		return valido;// error.isEmpty();
	}

	private Boolean validarTwitter(Contacto contacto) {
		return validarURL(contacto.getContacto());
	}

	private Boolean validarFacebook(Contacto contacto) {
		return validarURL(contacto.getContacto());
	}

	private Boolean validarLinkedIn(Contacto contacto) {
		return validarURL(contacto.getContacto());
	}

	private Boolean validarEmail(Contacto contacto) throws ContactoObligatoriosException, ContactoFormatosException {
		Boolean valido = true;
		if (contacto.getContacto() == null || Constantes.CADENA_VACIA.equals(contacto.getContacto())) {
			valido = false;
			errorAux.add("model.contacto", properties.getProperty("MSG39"));
			//throw new ContactoObligatoriosException(campoObligatorio.EMAIL_CONTACTO);
			// addFieldError("model.contacto", properties.getProperty("MSG39"));
		} else {
			if (!ReglaNegocioS10.validate(contacto.getContacto())) {
				valido = false;
				errorAux.add("model.contacto", properties.getProperty("MSG3_MAIL"));
				//throw new ContactoFormatosException(ReglaFormato.EMAIL);
				// addFieldError("model.contacto",
				// properties.getProperty("MSG3_MAIL"));
			}
		}
		// return !hasFieldErrors();
		return valido;
	}

	private Boolean validarMobil(Contacto contacto) throws ContactoFormatosException, ContactoObligatoriosException {
		return validarCodeAreaAndTelephone(contacto);
	}

	/**
	 * Valida el area y el teléfono de un contacto. Válida formato y que no esté
	 * vacío.
	 * 
	 * @param contacto
	 * @return true si fue validado correctamente.
	 */
	private Boolean validarCodeAreaAndTelephone(Contacto contacto)
			throws ContactoObligatoriosException, ContactoFormatosException {
		Boolean valido = true;
		if (contacto.getContactoA() == null || Constantes.CADENA_VACIA.equals(contacto.getContactoA())) {
			valido = false;
			// throw new
			// ContactoObligatoriosException(campoObligatorio.CODE_AREA);
			errorAux.add("model.contactoA", properties.getProperty("MSG39"));
			// addFieldError("model.contactoA",
			// properties.getProperty("MSG39"));
			// System.err.println("Agrega error de campoVacio");
		} else {
			if (!contacto.getContactoA().matches(properties.getProperty("mx.ipn.escom.cdt.codeArea"))) {
				valido = false;
				// throw new
				// ContactoFormatosException(ReglaFormato.CODEAREA_NUMEROS);
				errorAux.add("model.contactoA", properties.getProperty("MSG3_NUMBERS"));
				// addFieldError("model.contactoA",
				// properties.getProperty("MSG3_NUMBERS"));
			} else if (contacto.getContactoA().length() > Numeros.TRES.getValor()) {
				valido = false;
				// throw new
				// ContactoFormatosException(ReglaFormato.MAX_CARACTERES_CODEAREA);
				String mensaje = properties.getProperty("MSG41");
				mensaje = mensaje.replace("{0}", "3");
				errorAux.add("model.contactoA", mensaje);
				// addFieldError("model.contactoA", mensaje);
			} else if (contacto.getContactoA().length() < Numeros.DOS.getValor()) {
				valido = false;
				// throw new
				// ContactoFormatosException(ReglaFormato.MIN_CARACTERES_CODEAREA);
				String mensaje = properties.getProperty("MSG4_MORE");
				mensaje = mensaje.replace("{0}", "2");
				errorAux.add("model.contactoA", mensaje);
				// addFieldError("model.contactoA", mensaje);
			}
		}
		if (contacto.getContacto() == null || Constantes.CADENA_VACIA.equals(contacto.getContacto())) {
			valido = false;
			// throw new
			// ContactoObligatoriosException(campoObligatorio.TELEFONO);
			errorAux.add("model.contacto", properties.getProperty("MSG39"));
			// addFieldError("model.contacto", properties.getProperty("MSG39"));
		} else {
			if (!contacto.getContacto().matches(properties.getProperty("mx.ipn.escom.cdt.telephone"))) {
				valido = false;
				// throw new
				// ContactoFormatosException(ReglaFormato.TELEFONO_NUMEROS);
				errorAux.add("model.contacto", properties.getProperty("MSG3_NUMBERS"));
				// addFieldError("model.contacto",
				// properties.getProperty("MSG3_NUMBERS"));
			} else {
				if (contacto.getIdTipo().equals(EnumTipoContacto.CELULAR.getIdTipo())) {
					if (contacto.getContacto().length() != Numeros.DIEZ.getValor()) {
						valido = false;
						// throw new
						// ContactoFormatosException(ReglaFormato.MAX_NUMEROS_CELULAR);
						String mensaje = properties.getProperty("MSG41");
						mensaje = mensaje.replace("{0}", "10");
						errorAux.add("model.contacto", mensaje);
						// addFieldError("model.contacto", mensaje);
					}
				} else {
					if (contacto.getContacto().length() > Numeros.OCHO.getValor()) {
						valido = false;
						// throw new
						// ContactoFormatosException(ReglaFormato.MAX_NUMEROS_TELEFONO);
						String mensaje = properties.getProperty("MSG41");
						mensaje = mensaje.replace("{0}", "8");
						errorAux.add("model.contacto", mensaje);
						// addFieldError("model.contacto", mensaje);
					} else if (contacto.getContacto().length() < Numeros.SIETE.getValor()) {
						valido = false;
						// throw new
						// ContactoFormatosException(ReglaFormato.MIN_NUMEROS_CELULAR);
						String mensaje = properties.getProperty("MSG4_MORE");
						mensaje = mensaje.replace("{0}", "7");
						errorAux.add("model.contacto", mensaje);
						// addFieldError("model.contacto", mensaje);
					}
				}
			}
		}
		// return !hasFieldErrors();
		return valido;
	}

	private Boolean validarTelefono(Contacto contacto) throws ContactoFormatosException, ContactoObligatoriosException {
		Boolean valido = true;
		validarCodeAreaAndTelephone(contacto);
		if (contacto.getContactoB() != null && !Constantes.CADENA_VACIA.equals(contacto.getContactoB())) {
			if (Constantes.CADENA_VACIA.equals(contacto.getContactoB())) {
				// addFieldError("model.contactoB",
				// properties.getProperty("MSG39"));
			} else {
				if (contacto.getContactoB() != null && contacto.getContactoB().equals(Constantes.CADENA_VACIA)
						&& !contacto.getContactoB().matches(properties.getProperty("mx.ipn.escom.cdt.extension"))) {
					valido = false;
					errorAux.add("model.contactoB", properties.getProperty("MSG3_NUMBERS"));
					// throw new
					// ContactoFormatosException(ReglaFormato.EXTENSION_NUMEROS);
					// addFieldError("model.contactoB",
					// properties.getProperty("MSG3_NUMBERS"));
				} else if (contacto.getContactoB().length() > Numeros.CINCO.getValor()) {
					valido = false;

					// throw new
					// ContactoFormatosException(ReglaFormato.MAX_NUMEROS_EXTENSION);
					String mensaje = properties.getProperty("MSG41");
					mensaje = mensaje.replace("{0}", "5");
					errorAux.add("model.contactoB", mensaje);
					// addFieldError("model.contactoB", mensaje);
				} else if (contacto.getContactoB().length() < Numeros.UNO.getValor()) {
					valido = false;
					// throw new
					// ContactoFormatosException(ReglaFormato.MIN_NUMEROS_EXTENSION);
					String mensaje = properties.getProperty("MSG4_MORE");
					mensaje = mensaje.replace("{0}", "1");
					errorAux.add("model.contactoB", mensaje);
					// addFieldError("model.contactoB", mensaje);
				}
			}
		}
		// return !hasFieldErrors();
		return valido;
	}

	public Boolean deleteContacto(Contacto contacto, List<Contacto> listContactos) {
		int index = listContactos.indexOf(contacto);
		if (index != Numeros.UNO_NEGATIVO.getValor()) {
			listContactos.remove(index);
			return true;
		} else {
			return false;
		}
	}

	public void eliminarContacto(Contacto model) {
		genericBs.delete(model);

	}

	public ContactoDao getContactoDao() {
		return contactoDao;
	}

	public void setContactoDao(ContactoDao contactoDao) {
		this.contactoDao = contactoDao;
	}

	public GenericBs<Modelo> getGenericBs() {
		return genericBs;
	}

	public void setGenericBs(GenericBs<Modelo> genericBs) {
		this.genericBs = genericBs;
	}

	public Error getErrorAux() {
		return errorAux;
	}

	public void setErrorAux(Error errorAux) {
		this.errorAux = errorAux;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public ReglaNegocioN15 getReglaNegocioN15() {
		return reglaNegocioN15;
	}

	public void setReglaNegocioN15(ReglaNegocioN15 reglaNegocioN15) {
		this.reglaNegocioN15 = reglaNegocioN15;
	}
	
	

}
