<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
    <jsp:directive.page language="java"
        contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
    <html xmlns="http://www.w3.org/1999/xhtml">
		<head>

		</head>
		<body>
			<div class="form-group">
	        	<label class="col-md-4 control-label label-obligatorio" for="">
	            	<s:text name="IU1.4-4_LBL15" />
		       	</label>
		        <div class="col-md-8">
		        	 <s:select id="slcListaMunicipios" list="listaMunicipios"
	                        name="model.idMunicipio" listValue="nombre" listKey="id.getIdMunicipio()" headerKey="%{COM.ELD.DEFAULT_HEADER_KEY}"
	                        headerValue="Seleccione su municipio" cssClass="form-control" required="true"
	                        cssErrorClass="error" /><br/>
				</div>
	        </div>
		</body>
    </html>
</jsp:root>