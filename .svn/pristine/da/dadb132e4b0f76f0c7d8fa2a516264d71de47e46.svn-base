package mx.ipn.escom.cdt.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.ipn.escom.cdt.util.PropertyAccess;

public class DateConverter extends StrutsTypeConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateConverter.class);

	public static final String DATE_FORMAT = PropertyAccess.getProperty("mx.edu.eld.formatDate");
	public static final String DATETIME_FORMAT = PropertyAccess.getProperty("mx.edu.eld.formatDateTime");

	private static final String DATE_FORMAT_SYS = "yyyy-MM-dd";

	private static final String TIME_FORMAT = "HH:mm";

	/**
	 * Convierte una cadena de caracteres a fecha, tomando como base el formato
	 * año-mes-dia (yyyy-MM-dd)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] dateS, Class arg2) {
		SimpleDateFormat dateTimeformatter = new SimpleDateFormat(DATETIME_FORMAT);
		try {
			return dateTimeformatter.parse(dateS[0]);
		} catch (ParseException e) {
			SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			try {
				return formatter.parse(dateS[0]);
			} catch (ParseException e1) {
				formatter = new SimpleDateFormat(DATE_FORMAT_SYS);
				try {
					return formatter.parse(dateS[0]);
				} catch (ParseException pe) {
					formatter = new SimpleDateFormat(TIME_FORMAT);
					try {
						System.out.println("******>" + formatter.parse(dateS[0]));
						return formatter.parse(dateS[0]);
					} catch (ParseException pe1) {
						LOGGER.error("Error al extraer la fecha de su representacion en cadena");
						return null;
					}
				}
			}
		}
	}

	/**
	 * Convierte una fecha a una cadera de caracteres con base en el formato
	 * año-mes-dia (yyyy-MM-dd)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object date) {
		SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
		return dateformat.format(date);
	}
}
