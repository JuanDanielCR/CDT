package mx.edu.eld.admision.action;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ModelDriven;

import mx.edu.eld.admision.mapeo.Direccion;
import mx.ipn.escom.cdt.util.action.ActionSupportCDT;

@Namespace("/admision")
public class GestionarDireccionAct extends ActionSupportCDT implements ModelDriven<Direccion> {
	private Direccion model;

	public String editNew() {

		return EDITNEW;
	}

	public Direccion getModel() {
		return model;
	}

	public void setModel(Direccion model) {
		this.model = model;
	}

}
