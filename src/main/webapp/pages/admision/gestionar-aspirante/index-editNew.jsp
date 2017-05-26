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
	<h1 class="title">Formulario Registrar Aspirante </h1>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	
	<s:actionerror />
	
	<s:form method="POST" action="%{pageContext.request.contextPath}/admision/gestionar-aspirante" id="formAspirante">
		<s:textfield name="model.nombre" placeholder="Nombre del Aspirante" maxlength="100"></s:textfield><br/>
		<s:textfield name="model.primerAp" placeholder="Apellido Paterno" maxlength="100"></s:textfield><br/>
		<s:textfield name="model.segundoAp" placeholder="Apellido Materno" maxlength="100"></s:textfield><br/>
		<s:textfield name="model.curp" placeholder="CURP" maxlength="18"></s:textfield><br/>
		<!--<s:submit>%{getText('mx.btnRegistrarAspirante')}</s:submit>-->
		<s:submit value="Registrar Aspirante"></s:submit>
	</s:form>
	<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante">Index</a><br/>
</body>
	</html>
</jsp:root>