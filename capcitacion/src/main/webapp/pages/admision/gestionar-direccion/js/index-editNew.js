$(function(){
	
});

function obtenerMunicipios(){
	var slcEstado = $("#slcListaEstados");
	var divMunicipios = $("#divMunicipios");
	var hidden = $('#idEstado');
	var form = $('#formMunicipios');
	
	hidden.val(slcEstado.val())
	
	$.ajax({
		type:form.attr("method"),
		url: form.attr("action"),
		data:form.serialize(),
		cache: false,
		async: true,
		success:function(data){
			console.log(data);
			var respuesta = data.ajaxResult;
			if(respuesta.response.estatus == "ENCONTRADO"){
				llenarSelect("slcListaMunicipios",respuesta.response.listaMunicipios,"idMunicipio","nombre");
			}else{
				alert("Oops algo malo sucedio con el edificio y no encontramos sus pisos")
			}
		},
		error:function(){
			alert("Oops algo malo sucedio con el edificio y no encontramos sus pisos");
		}
	})
}

function autocompletar(){
	var form = $("#formCodigoPostal");
	var txtCp = $("#txtCp");
	var hidden = $("#idCp");
	var divAutocompletar = $("#divAutoCompletar");
	
	hidden.val(txtCp.val());
	
	//Si algún otro campo ya esta lleno evitar el autocompletado
	var slcEstados = $("#slcListaEstados");
	var slcMunicipios = $("#slcListaMunicipios");
	var txtColonia = $("#txtColonia");
	var txtCalle = $("#txtCalle");
	var txtNe = $("#txtNumeroExt");
	var txtNi = $("#txtNumeroInt");
	
	console.log("E: "+slcEstados.val()+"M: "+slcMunicipios.val()+" Col: "+txtColonia.val().length+" Calle: "+ txtCalle.val().length);
	
	if(slcEstados.val() == -1 && 
	   slcMunicipios.val()== -1 && 
	   txtColonia.val().length <= 0 &&  
	   txtCalle.val().length <= 0 && 
	   txtNe.val().length <= 0 && 
	   txtNi.val().length <= 0){
		
		$.ajax({
			type:form.attr("method"),
			url: form.attr("action"),
			data:form.serialize(),
			cache: false,
			async: true,
			dataType: 'html',
			success:function(data){
				divAutocompletar.html("");
				divAutocompletar.html(data);
			},
			error:function(){
				alert("Oops algo malo sucedio con el codigo postal");
			}
		})
	}
}
/**
 * Funcion que permite llenar un select con una lista de objetos. Borra el
 * contenido del select y lo substituye por las nuevas opciones. Al principio
 * del select pone el valor y el id de header que se encuentren en los inputs
 * [ocultos] con id's #hdnHeaderKey y #hdnHeaderValue. En caso de que el select
 * esté desactivado, se activara.
 * 
 * @param {string}
 *            idSelect - id del select a modificar
 * @param {Object[]}
 *            listObjects - lista de objetos con atributos a utilizar como
 *            valores y llaves del select
 * @param {string}
 *            optionId - atributo de un objeto perteneciente a listObjects que
 *            sera utilizado como key del select
 * @param {string}
 *            optionValue - atributo de un objeto perteneciente a listObjects
 *            que sera utilizado como value del select
 */
function llenarSelect(idSelect, listObjects, optionId, optionValue) {
    var listOptions = '';
    var _slcObjects = $("#" + idSelect);
    // Elimina todas las opciones del select
    _slcObjects.find('option').remove().end();
    // Agrega el header key y el heder value al select
    listOptions += '<option value="-1">Seleccione un municipio</option>';
    // Agrega las nuevas opciones al select
    $.each(listObjects, function(index, value) {
        listOptions += '<option value="' + $(value).attr(optionId) + '">'
                + $(value).attr(optionValue) + '</option>';
    });
    // Habilita el select
    _slcObjects.append(listOptions).attr("disabled", false);
}