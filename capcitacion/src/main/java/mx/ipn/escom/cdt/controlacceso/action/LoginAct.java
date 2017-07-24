package mx.ipn.escom.cdt.controlacceso.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import mx.ipn.escom.cdt.util.action.ActionSupportCDT;

//@Namespace("/control-acceso")
public class LoginAct extends ActionSupportCDT {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpHeaders index() {
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}
}
