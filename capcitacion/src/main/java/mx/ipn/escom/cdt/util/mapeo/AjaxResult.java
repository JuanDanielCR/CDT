package mx.ipn.escom.cdt.util.mapeo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Ricardo Ruiz
 *
 */
public class AjaxResult {
    /**
     * Enum de respuesta de un Ajax.
     * 
     * @author CDT-ESCOM
     *
     */
    public enum EnumRespuestaAjax {
        ENCONTRADO(1), NO_ENCONTRADO(2);
        private Integer tipoRespuesta;
        private EnumRespuestaAjax(Integer tipoRespuesta) {
            this.tipoRespuesta = tipoRespuesta;
        }
        /**
         * @return the tipoRespuesta
         */
        public Integer getTipoRespuesta() {
            return tipoRespuesta;
        }
    }
    /**
     * Respuesta que se enviara mediante ajax, esta compuesta por el nombre del
     * campo y un objeto de valor indefinido, por ejemplo: String, Integer,
     * Float ó entidades mapeadas de la base de datos
     */
    private Map<String, Object> response;
    /**
     * Lista con los posibles mensajes que pudieran presentarse con la peticion
     */
    private List<Mensaje> listMessages;
    public AjaxResult() {
        this.response = new HashMap<>();
        this.listMessages = new ArrayList<>();
    }
    public AjaxResult(Map<String, Object> response, List<Mensaje> listMessages) {
        super();
        this.response = response;
        this.listMessages = listMessages;
    }
    /**
     * Permite agregar un nuevo campo a la respuesta
     * 
     * @param nombreCampo
     * @param objeto
     */
    public void addCampo(String nombreCampo, Object objeto) {
        response.put(nombreCampo, objeto);
    }
    /**
     * @return the response
     */
    public Map<String, Object> getResponse() {
        return response;
    }
    /**
     * @param response
     *            the response to set
     */
    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }
    /**
     * @return the listMessages
     */
    public List<Mensaje> getListMessages() {
        return listMessages;
    }
    /**
     * @param listMessages
     *            the listMessages to set
     */
    public void setListMessages(List<Mensaje> listMessages) {
        this.listMessages = listMessages;
    }
}
