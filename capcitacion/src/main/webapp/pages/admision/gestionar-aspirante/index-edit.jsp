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
				<s:text name="CAP-TITLE2"/>
			</h1>
		</div>
	</div>
	<!-- Action error -->
	<div class="row">
		<div class="col-md-12">
			<s:actionerror theme="%{getText('mx.edu.eld.defaulTheme')}"/>
		</div>
	</div>

	<s:form action="%{pageContext.request.contextPath}/admision/gestionar-aspirante/%{model.id}" id="formAspirante">
		<fieldset class="form-section form-horizontal form-medium text-justify">
		<legend class="form-section">
			<s:text name="CAP-LBL11"/>
		</legend>
		<!-- Emulando metodo PUT -->
		<s:hidden name="_method" value="put"/>
		<!-- Actualizando nombre -->
		<div class="form-group">
			<label class="col-md-4 control-label label-obligatorio" for="">
            	<s:text name="IU1.4-2_LBL2" />
        	</label>
        	<div class="col-md-8 ">
				<s:textfield name="model.nombre" id="txtNombre" cssClass="form-control" cssErrorClass="field-error" maxlength="100" /><br/>
				<s:fielderror fieldName="model.nombre" cssClass="error" theme="%{getText('mx.edu.eld.defaulTheme')}"/>
			</div>
		</div>
		<!-- Actualizando Primer apellido -->
		<div class="form-group">
			<label class="col-md-4 control-label label-obligatorio">
				<s:text name="IU1.4-2_LBL3"/>
			</label>
			<div class="col-md-8">
				<s:textfield name="model.primerAp" id="txtPrimerAp" cssClass="form-control" cssErrorClass="field-error"/><br/>
				<s:fielderror fieldName="model.primerAp" theme="bootstrap"/>
			</div>
		</div>
		<!-- Actualizando Segundo Apellido -->
		<div class="form-group">
			<label class="col-md-4 control-label label-obligatorio">
				<s:text name="IU1.4-2_LBL4"/>
			</label>
			<div class="col-md-8">
				<s:textfield name="model.segundoAp" id="txtSegundoAp" cssClass="form-control" cssErrorClass="field-error"/>
				<s:fielderror fieldName="model.segundoAp" theme="bootstrap"/>
			</div>
		</div>
		<!-- Actualizando CURP -->
		<div class="form-group">
			<label class="col-md-4 control-label label-obligatorio">
				<s:text name="IU1.4-2_LBL7"/>
			</label>
			<div class="col-md-8">
				<s:textfield name="model.curp" id="txtCurp" cssClass="form-control" cssErrorClass="field-erro"/>
				<s:fielderror fieldName="model.curp" theme="bootstrap"/>
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