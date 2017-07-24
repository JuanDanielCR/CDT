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
	<!-- Div contenedor con form, form-group para agregar contorno -->
	<!-- Titulo -->
	<div class="form-group">
		<div class="row">
			 <div class="col-md-12">
				<h1 class="title"><s:text name="IU1.4-2_TITLE"/></h1>
			</div>
		</div>
	</div>
	<div class="form form-medium">
		<!-- Información -->
		<div class="row">
			<div class="form-group">
				<label class="col-md-6 control-label">
					<s:text name="IU1.4-2_LBL2"/>
				</label>
				<div class="col-md-6">
					<s:property value="model.nombre"/><br/>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group">
			<label class="col-md-6 control-label">
				<s:text name="IU1.4-2_LBL3"/>
			</label>
			<div class="col-md-6">
				<s:property value="model.primerAp"/><br/>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="col-md-6 control-label">
					<s:text name="IU1.4-2_LBL4"/>
				</label>
				<div class="col-md-6">
					<s:property value="model.segundoAp"/><br/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="col-md-6 control-label">
					<s:text name="IU1.4-2_LBL7"/>
				</label>
				<div class="col-md-6">
					<s:property value="model.curp"/><br/>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="outter-section form-medium">
			<div class="col-md-12 text-right">
				<a	class="btn btn-default btn-default-eld" 
					href="${pageContext.request.contextPath}/admision/gestionar-aspirante">
					<s:text name="mx.com.eld.boton.regresar"></s:text>
				</a>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>