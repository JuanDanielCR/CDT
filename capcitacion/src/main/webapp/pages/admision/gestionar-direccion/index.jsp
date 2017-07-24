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
        src="${pageContext.request.contextPath}/pages/admision/gestionar-direccion/js/index.js"
        type="text/javascript"></script>
    ]]>
    </jsp:text>
</head>
<body>
	<s:url var="localeMX" namespace="/example" action="menu">
		<s:param name="request_locale">es_MX</s:param>
	</s:url>
	<!-- Titulo -->
	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="IU1.4-4_TITLE"></s:text>
			</h1>
		</div>	
	</div>
	<!-- Actionerror -->
	<div class="form form-large">
		<table id="tblDirecciones" class="table table-striped">
			<thead>
				<tr>
					<td><s:text name="IU1.4-4_LBL14"></s:text></td>
					<td><s:text name="IU1.4-4_LBL15"></s:text></td>
					<td><s:text name="IU1.4-4_LBL16"></s:text></td>
					<td><s:text name="IU1.2-1_LBL3"></s:text></td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listaAspiranteDirecciones" var="aspDir">
					<tr>
					<!-- s:text = Obtiene valores provenientes del package properties
						(si, es raro no usar el s:property para obtener properties)
						nota: Observar que podemos acceder a el valor de una property con solo poner su nombre ya que:
						La ruta de paquetes del action tiene el mismo formato que la del .properties-->
				
					<!-- s:property =  Obtiene valores provenientes de un action o del interior del jsp
						Interior JSP: #nombre usado en el interior del jsp
						Action: no usar #
						-->
						<td><s:property value="#aspDir.direccion.municipio.entidad.nombre"/> </td>
						<td><s:property value="#aspDir.direccion.municipio.nombre"/> </td>
						<td>
							<s:property value="#aspDir.direccion.colonia"/>
							<s:property value="#aspDir.direccion.calle"/>
							<s:property value="#aspDir.direccion.numeroExt"/>
							<s:property value="#aspDir.direccion.numeroInt"/>
							<s:property value="#aspDir.direccion.cp"/>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/admision/gestionar-direccion/${aspDir.direccion.id}/edit"><i class="material-icons md-24 md-eld">&#xE254;</i></a>
							<!--a href="${pageContext.request.contextPath}/admision/gestionar-direccion"><i class="material-icons">&#xE872;</i></a-->
						</td>
					</tr>
				</s:iterator>
			</tbody>		
		</table>
	</div>
	<div>
		<a class="btn btn-default btn-default-eld" href="${pageContext.request.contextPath}/admision/gestionar-direccion/new"><s:text name="CAP-LBL3"/></a> 
	</div>
</body>
	</html>
</jsp:root>