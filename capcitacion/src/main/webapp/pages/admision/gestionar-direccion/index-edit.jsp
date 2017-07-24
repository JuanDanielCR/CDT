<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Head -->
</head>
<body>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<!-- Titulo -->
	<div class="row">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="CAP-TITLE4"/>
			</h1>
		</div>
	</div>
	<!-- Action error -->
	<div class="row">
		<div class="col-md-12">
			<s:actionerror theme="%{getText('mx.edu.eld.defaulTheme')}"/>
		</div>
	</div>
	<!-- Formulario -->
	<s:form action="%{pageContext.request.contextPath}/admision/gestionar-direccion/%{model.id}" id="formDireccion">
		<fieldset class="form-section form-horizontal form-medium text-justify">
			<legend class="form-section">
				<s:text name="CAP-LBL12"/>			
			</legend>
			<!-- Emulando metodo PUT -->
			<s:hidden name="_method" value="put"/>
			<!-- Colonia -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL16" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.colonia" id="txtColonia" cssClass="form-control" cssErrorClass="field-error" maxlength="51" /><br/>
					<s:fielderror fieldName="model.colonia" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
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
	        	 	<s:textfield name="model.numeroInt" id="txtCalle" cssClass="form-control" cssErrorClass="field-error" maxlength="100" /><br/>
					<s:fielderror fieldName="model.numeroInt" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		<!-- Codigo Postal -->
			<div class="form-group">
				<label class="col-md-4 control-label label-obligatorio" for="">
            		<s:text name="IU1.4-4_LBL13" />
	        	</label>
	        	<div class="col-md-8">
	        	 	<s:textfield name="model.cp" id="txtCp" cssClass="form-control" cssErrorClass="field-error" maxlength="100" /><br/>
					<s:fielderror fieldName="model.cp" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
				</div>
			</div>
		</fieldset>	
		<div class="row">
			<div class="outter-section form-medium">
				<div class="col-md-12 text-right">
					<s:submit value="%{getText('mx.com.eld.boton.aceptar')}" class="btn btn-default btn-default-eld"/>
					<a class="btn btn-default btn-default-eld"
					   href="${pageContext.request.contextPath}/admision/gestionar-aspirante">
					   <s:text name="mx.com.eld.boton.cancelar"/>
					</a>
				</div>
			</div>
		</div>
	</s:form>
</body>
	</html>
</jsp:root>