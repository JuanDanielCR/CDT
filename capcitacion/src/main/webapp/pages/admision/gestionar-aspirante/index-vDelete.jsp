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
	<h1 class="title">¿Seguro que deseas borrar?</h1>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<s:form action="%{pageContext.request.contextPath}/admision/gestionar-aspirante/%{model.id}">
		<s:hidden name="_method" value="delete"/>
		<s:submit class="btn btn-default btn-default-eld" value="Eliminar"/>
		<a class="btn btn-default btn-default-eld"
		   href="${pageContext.request.contextPath}/admision/gestionar-aspirante">
		   <s:text name="mx.com.eld.boton.cancelar"/>
		</a>
	</s:form>
</body>
	</html>
</jsp:root>