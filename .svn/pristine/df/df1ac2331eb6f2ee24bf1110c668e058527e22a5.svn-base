package mx.ipn.escom.cdt.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.ipn.escom.cdt.util.action.FileUtil;
import mx.ipn.escom.cdt.util.exception.AccessPropertyException;

/**
 * Carga el archivo global.properties, el cual contiene las variables
 * parametrizadas que requiere el sistema.
 * 
 * @author Hermes
 *
 */
public class PropertyAccess {
	/**
	 * Permite acceder al archivo de propiedades
	 */
	private static final Properties properties = new Properties();

	/**
	 * Nombre del archivo de propiedades que se encuentra en el directorio
	 * WEB-INF/classes/
	 */
	private static final String PROPERTIES_FILE_NAME = "global.properties";

	/**
	 * Instancia que permitirá escribir dentro del log de la aplicación
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * Realiza la carga del archivo de propiedades
	 */
	static {
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
			properties.load(input);
		} catch (IOException ex) {
			LOGGER.error(Constantes.IO_EXCEPTION, ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.error(Constantes.IO_EXCEPTION, e);
				}
			}
		}
	}

	/**
	 * Devuelve la propiedad escificada por key
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * Obtiene el valor de la propiedad especificada por key y lo convierte a
	 * entero
	 * 
	 * @param key
	 * @return
	 * @throws AccessPropertyException
	 *             cuando ocurre una {@link NumberFormatException} al convertir
	 *             el valor de key a Integer
	 */
	public static Integer getIntegerProperty(String key) throws AccessPropertyException {
		try {
			return Integer.parseInt(properties.getProperty(key));
		} catch (NumberFormatException nfe) {
			throw new AccessPropertyException(nfe.getCause());
		}
	}

	/**
	 * Obtiene el valor de la propiedad especificada por key y lo convierte a un
	 * valor de doble precision
	 * 
	 * @param key
	 * @return
	 * @throws AccessPropertyException
	 *             cuando ocurre una {@link NumberFormatException} al convertir
	 *             el valor de key a Double
	 */
	public static Double getDoubleProperty(String key) throws AccessPropertyException {
		try {
			return Double.parseDouble(properties.getProperty(key));
		} catch (NumberFormatException nfe) {
			throw new AccessPropertyException(nfe.getCause());
		}
	}

	/**
	 * Obtiene el valor de la propiedad especificada por key y lo convierte a un
	 * valor de punto flotante
	 * 
	 * @param key
	 * @return
	 * @throws AccessPropertyException
	 *             cuando ocurre una {@link NumberFormatException} al convertir
	 *             el valor de key a Float.
	 */
	public static Float getFloatProperty(String key) throws AccessPropertyException {
		try {
			return Float.parseFloat(properties.getProperty(key));
		} catch (NumberFormatException nfe) {
			throw new AccessPropertyException(nfe.getCause());
		}
	}

	/**
	 * Obtiene el valor de la propiedad especificada por key y lo convierte a
	 * fecha, considerando que la fecha se encuentra en el formato espeficado
	 * por la propiedad con identificador mx.edu.eld.formatDate .
	 * 
	 * @param key
	 * @return
	 * @throws AccessPropertyException
	 *             cuando ocurre una {@link ParseException} al convertir el
	 *             valor de key a Date
	 */
	public static Date getDateProperty(String key) throws AccessPropertyException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(getProperty("mx.edu.eld.formatDate"));
		try {
			return dateFormat.parse(getProperty(key));
		} catch (ParseException pe) {
			throw new AccessPropertyException(pe.getCause());
		}
	}

	/**
	 * Obtiene el valor de la propiedad especificada por key y lo convierte a
	 * fecha, considerando que la fecha se encuentra en el formato espeficado
	 * format.
	 * 
	 * @param key
	 * @return
	 * @throws AccessPropertyException
	 *             cuando ocurre una {@link ParseException} al convertir el
	 *             valor de key a Date
	 */
	public static Date getDateProperty(String key, String format) throws AccessPropertyException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(getProperty(format));
		try {
			return dateFormat.parse(getProperty(key));
		} catch (ParseException pe) {
			throw new AccessPropertyException(pe.getCause());
		}
	}
}
