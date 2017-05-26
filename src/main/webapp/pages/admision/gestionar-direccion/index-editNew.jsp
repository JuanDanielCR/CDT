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
</head>
<body>
	<h1 class="title">Agregar Dirección</h1>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<form action="gestionar-direccion" method="POST">
		<div class="form-group">
			<!-- Nombre secundaria -->
			<div id="idNombreSecundaria" class="form-group ">
				<label class="col-md-4 control-label label-obligatorio" for=""><s:text
						name="IU1.4-7_LBL20" /></label>
				<div class="col-md-8">
					<s:textfield id="txNombreSecundaria" name="infoSecundaria.nombre"
						type="text" cssClass="form-control"
						placeholder="%{getText('IU1.4-7_LBL20')}"
						cssErrorClass="field-error" />
						
					<s:fielderror id="feTxNombreSecundaria"
						fieldName="infoSecundaria.nombre" cssClass="error"
						theme="%{getText('mx.edu.eld.defaulTheme')}" />
				</div>
			</div>
			<div id="idSecundariaMunicipio" class="form-group ">
				<label class="col-md-4 control-label label-obligatorio" for=""><s:text
						name="IU1.4-7_LBL36" /></label>
				<div class="col-md-8">
					<s:select id="slcListMunicipios" name="listMunicipios"
						headerKey="-1" headerValue="Select" cssClass="form-control"
						list="#{'1':'Ecatepec de Morelos', '2':'Toluca', '3':'Coacalco'}"
						value="selectedTipo" required="true" />
				</div>
			</div>
			<div class="row">
				<div class="outter-section form-medium text-left">
					<s:text name="IU1.4-2_LBL1" />
				</div>
			</div>
		</div>
	</form>
	<s:a href="%{localeMX}">Maqueta</s:a>
</body>
	</html>
</jsp:root>