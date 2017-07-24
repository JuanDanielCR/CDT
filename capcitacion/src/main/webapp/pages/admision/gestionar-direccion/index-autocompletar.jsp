<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
    <jsp:directive.page language="java"
        contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
    <html xmlns="http://www.w3.org/1999/xhtml">
		<head>

		</head>
		<body>
		<s:form 
		method="POST"
		action="%{pageContext.request.contextPath}/admision/gestionar-direccion"
		id="formDireccion"
		theme="simple"
		cssClass="form-horizontal">
		<!-- Formulario -->
		<fieldset class="form-section form-horizontal form-medium text-justify">
		 	<legend class="form-section">
         		<s:text name="IU1.4-4_TITLE"></s:text>
         	</legend>
         <!-- Campo hidden con el valor del idAspirante que dara de alta una dirección -->
         	<s:hidden name="idAspiranteSel"/>
         	
         <!-- Estado -->
         	<div class="form-group">
         		<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL14" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield value="%{entidadSel.nombre}" id="txtEntidad" cssClass="form-control" cssErrorClass="field-error" disabled="true"/><br/>
	        	 	<s:hidden name="model.idEntidad" value="%{entidadSel.id}" id="slcListaEstados"/>
					<s:fielderror fieldName="model.numeroExt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
         	</div>
         <!-- Municipio -->
	         <div id="divMunicipios">
	         	<div class="form-group">
	         		<label class="col-md-4 control-label label-obligatorio" for="">
	            		<s:text name="IU1.4-4_LBL15" />
		        	</label>
		        	<div class="col-md-8">
		        	 	<s:textfield name="model.numeroExt" value="%{municipioSel.nombre}" id="txtMunicipio" cssClass="form-control" cssErrorClass="field-error" maxlength="2" disabled="true"/><br/>
						<s:hidden name="model.idMunicipio" value="%{municipioSel.idMunicipio}" id="slcListaMunicipios"/>
						<s:fielderror fieldName="model.numeroExt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
					</div>
	         	</div>
	        </div>
         <!-- Colonia -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL16" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:select id="txtColonia" list="listaColonias"
	        	 			name="model.colonia" headerKey="%{getText('COM.ELD.DEFAULT_HEADER_KEY')}"
	                        headerValue="Seleccione su colonia" cssClass="form-control" required="true"
	                        cssErrorClass="error" />
				</div>
			</div>
         <!-- Calle -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL17" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.calle" id="txtCalle" cssClass="form-control" cssErrorClass="field-error" maxlength="100" /><br/>
					<s:fielderror fieldName="model.calle" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Numero Exterior -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL18" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.numeroExt" id="txtNumeroExt" cssClass="form-control" cssErrorClass="field-error" maxlength="2" /><br/>
					<s:fielderror fieldName="model.numeroExt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Numero Interior -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL19" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.numeroInt" id="txtNumeroInt" cssClass="form-control" cssErrorClass="field-error" maxlength="100" /><br/>
					<s:fielderror fieldName="model.numeroInt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Codigo Postal -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL13" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.cp" id="txtCp" value="%{codigoPostal.cp}" cssClass="form-control" cssErrorClass="field-error" maxlength="100" onfocusout="autocompletar()"/><br/>
					<s:fielderror fieldName="model.cp" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		</fieldset>
		<div class="row">
			<div class="outter-section form-medium">
				<div class="col-md-12 text-right">
					<s:submit value="%{getText('mx.com.eld.boton.aceptar')}" class="btn btn-default btn-default-eld"/>
					<a class="btn btn-default btn-default-eld"
						href="${pageContext.request.contextPath}/admision/gestionar-direccion?idAspiranteSel=${idAspiranteSel}">
						<s:text name="mx.com.eld.boton.cancelar"/>
					</a>
				</div>
			</div>
		</div>
	</s:form>
		</body>
    </html>
</jsp:root>