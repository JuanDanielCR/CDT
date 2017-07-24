<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!--Expresiones OGNL:
	%{} - usada dentro de tags de struts
	${} - usada con tags de html
-->
	<jsp:text>
        <![CDATA[
    <script
        src="${pageContext.request.contextPath}/pages/admision/gestionar-direccion/js/index-editNew.js"
        type="text/javascript"></script>
    ]]>
    </jsp:text>
</head>
<body>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<!-- Titulo domicilio -->
	<div class="row">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="CAP-LBL3"/>
			</h1>				
		</div>
	</div>
	<!-- Dialogo para los message errors -->
	<div class="row">
		<div class="col-md-12">
			<s:actionerror theme="%{getText('mx.edu.eld.defaulTheme')}"/>				
		</div>
	</div>
	<!-- Formulario de registro para una direccion de un aspirante -->
	<div id="divAutoCompletar">
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
	        	 	<s:select id="slcListaEstados" list="listaEstados"
                        name="model.idEntidad" listValue="nombre" listKey="id" headerKey="%{getText('COM.ELD.DEFAULT_HEADER_KEY')}"
                        headerValue="Seleccione su estado" cssClass="form-control" required="true"
                        cssErrorClass="error" 
                        onchange="obtenerMunicipios()"/>
                        <s:fielderror fieldName="model.idEntidad" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
         	</div>
         <!-- Municipio -->
	         <div id="divMunicipios">
	         	<div class="form-group">
	         		<label class="col-md-4 control-label label-obligatorio" for="">
	            		<s:text name="IU1.4-4_LBL15" />
		        	</label>
		        	<div class="col-md-8">
		        	 	<s:select id="slcListaMunicipios" list="listaMunicipios"
	                        name="model.idMunicipio" listValue="nombre" listKey="id.getIdMunicipio()" 
	                        headerKey="%{getText('COM.ELD.DEFAULT_HEADER_KEY')}"
	                        headerValue="Seleccione su municipio" cssClass="form-control" required="true"
	                        cssErrorClass="error" /><br/>
	                        <s:fielderror fieldName="model.idMunicipio" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
					</div>
	         	</div>
	        </div>
         <!-- Colonia -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL16" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.colonia" id="txtColonia" cssClass="form-control" cssErrorClass="field-error"/>
					<s:fielderror fieldName="model.colonia" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
         <!-- Calle -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL17" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.calle" id="txtCalle" cssClass="form-control" cssErrorClass="field-error" maxlength="100" />
					<s:fielderror fieldName="model.calle" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Numero Exterior -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL18" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.numeroExt" id="txtNumeroExt" cssClass="form-control" cssErrorClass="field-error" maxlength="2" />
					<s:fielderror fieldName="model.numeroExt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Numero Interior -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL19" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.numeroInt" id="txtNumeroInt" cssClass="form-control" cssErrorClass="field-error" maxlength="100" />
					<s:fielderror fieldName="model.numeroInt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Codigo Postal -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL13" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.cp" id="txtCp" cssClass="form-control" cssErrorClass="field-error" maxlength="100" onfocusout="autocompletar()"/><br/>
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
	</div>
	<s:form id="formMunicipios" method="POST" action="%{pageContext.request.contextPath}/admision/gestionar-direccion!obtenerMunicipios">
		<s:hidden name="idEstadoSel" id="idEstado" value="-1"/>
	</s:form>
	<s:form id="formCodigoPostal" method="POST" action="%{pageContext.request.contextPath}/admision/gestionar-direccion!autocompletarCp">
		<s:hidden name="cpSel" id="idCp" value="-1"/>
	</s:form>
</body>
	</html>
</jsp:root>