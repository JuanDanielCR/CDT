<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Head -->
	<jsp:text>
        <![CDATA[
    <script
        src="${pageContext.request.contextPath}/pages/admision/gestionar-aspirante/js/index.js"
        type="text/javascript"></script>
    ]]>
    </jsp:text>
</head>
<body>
	<!--Sí deseamos usar OGNL con una etiqueta struts:
		1. Variable en un action: %{var}
		2. Variable en un jsp: %{#var}
	-->
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<!--Creacion de variables en struts:
		1. s:set
		2. s:date
		3. s:url
		...
		<s:set var="index">Index</s:set>
	-->
	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="CAP-TITLE"/>
			</h1>
		</div>
	</div>

	<!--Sí deseamos usar una expression con una etiqueta HTML:
		Usar: ${var} 

		<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante">${index}</a><br/> -->
	<!-- Poner siempre un div con las clases: form, form-large [para poner un recuadro] -->
	<div class="form form-large">
		<table id="tblAspirantes" class="table table-striped">
			<thead>
			<tr>
				<th><s:text name="CAP-LBL1"></s:text></th>
				<th><s:text name="CAP-LBL2"></s:text></th>
				<th>Acción</th>
			</tr>
			</thead>
			<tbody>
				<s:iterator value="listAspirantes" var="aspirante">
					<tr>
						<td>${aspirante.nombre} ${aspirante.primerAp} ${aspirante.segundoAp}</td>
						<td>${aspirante.curp}</td>
						<td>
						<!-- Icono: mode_edit -->
						<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante/${aspirante.id}/edit"><i class="material-icons md-24 md-eld">&#xE254;</i></a>
						<!-- Icono: remove_red_eye -->
						<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante/${aspirante.id}"><i class="material-icons  md-24 md-eld">&#xE417;</i></a>
						<!-- Icono: delete -->
						<a href="${pageContext.request.contextPath}/admision/gestionar-aspirante!vDelete?idSel=${aspirante.id}"><i class="material-icons  md-24 md-eld">&#xE872;</i></a>
						<!-- Icono: addlocation -->
						<a href="${pageContext.request.contextPath}/admision/gestionar-direccion?idAspiranteSel=${aspirante.id}"><i class="material-icons md-24 md-eld">&#xE567;</i></a>
						</td>
					</tr>	
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div ><a class="btn btn-default btn-default-eld" href="${pageContext.request.contextPath}/admision/gestionar-aspirante/new"><s:text name="CAP-LBL4"></s:text></a></div>
</body>
</html>
</jsp:root>