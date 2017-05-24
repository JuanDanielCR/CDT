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
	<h1 class="title">Agregar Dirección</h1>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<form action="gestionar-direccion" method="POST">
		<div class="form-group">
			<div class="row">
			<div class="col-md-2"><label for="id_entidad">Entidad</label></div>
			<div class="col-md-6"><s:textfield name="model.idEntidad" id="id_entidad" class="form-control" placeholder="Entidad" maxlength="3" /></div>	
			</div>
		</div>
	</form>
	<s:a href="%{localeMX}">Maqueta</s:a>
</body>
	</html>
</jsp:root>