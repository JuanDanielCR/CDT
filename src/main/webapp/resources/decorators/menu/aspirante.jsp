<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<ul class="nav navbar-nav">
		<li class="dropdown"><a title="Proceso de admisión"
			data-toggle="dropdown" class="dropdown-toggle" href="#"
			aria-expanded="false">Proceso de admisión<b class="caret"> <!--  -->
			</b></a>
			<ul class="dropdown-menu">
				<!-- <li><a
					href="${pageContext.request.contextPath}/admision/realizar-registro/new">Realizar
						registro</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admision/realizar-pago">Realizar
						pago</a></li> -->
				<li class="dropdown-submenu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown">Examen CENEVAL</a>
					<ul class="dropdown-menu">
						<!-- <li><a href="#">Responder Entrevista</a></li> -->
						<li><a href="${pageContext.request.contextPath}/ceneval/gestionar-folios-examen/2">Visualizar Folio de Aplicación para
								Examen CENEVAL</a></li>
						<li><a href="${pageContext.request.contextPath}/ceneval/gestionar-resultados-examen/1">Visualizar resultados de EXAMEN</a></li>
					</ul></li>
			</ul></li>
		<li class="dropdown"><a title="Incripciones"
			data-toggle="dropdown" class="dropdown-toggle" href="#"
			aria-expanded="false">Incripciones</a></li>
		<li class="dropdown"><a title="Evaluaciones"
			data-toggle="dropdown" class="dropdown-toggle" href=""
			aria-expanded="false">Evaluaciones</a></li>
	</ul>
</jsp:root>