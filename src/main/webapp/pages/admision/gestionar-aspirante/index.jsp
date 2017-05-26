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
	<!--Creacion de variables en struts:
		1. s:set
		2. s:date
		3. s:url
		...
	-->
	<s:set var="index">Index</s:set>
	<s:set var="nuevo">New aspirante</s:set>
	<s:set var="editar">Edit aspirante</s:set>
	<s:set var="show">Show aspirante</s:set>
	
	<h1 class="title">Aspirante</h1>
	<!--Sí deseamos usar OGNL con una etiqueta struts:
		1. Variable en un action: %{var}
		2. Variable en un jsp: %{#var}
	-->
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<!--Sí deseamos usar OGNL con una etiqueta HTML:
		Usar: ${var} 
	-->
	<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante">${index}</a><br/>
	<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante/new">${nuevo}</a><br/>
	<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante/1/edit">${editar}</a><br/>
	<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante/1">${show}</a>
	
</body>
</html>
</jsp:root>