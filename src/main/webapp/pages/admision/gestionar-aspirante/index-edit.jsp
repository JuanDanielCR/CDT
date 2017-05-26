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
	<h1 class="title">Formulario para actualizar un aspirante específico</h1>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante">Index</a><br/>
	<form method="POST" action="${pageContext.request.contextPath}/admision/gestionar-aspirante">
	<input type="submit" value="Agregar"/>
	</form>
</body>
	</html>
</jsp:root>