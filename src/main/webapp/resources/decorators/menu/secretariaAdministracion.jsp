<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<ul class="nav navbar-nav">
		<li class="dropdown"><a title="Ciclo Escolar"
			data-toggle="dropdown" class="dropdown-toggle" href="#"
			aria-expanded="false">Ciclo Escolar<b class="caret"> <!--  --></b></a>
			<ul class="dropdown-menu">
				<li><a href="${pageContext.request.contextPath}/calendario/gestionar-ciclos">Calendario Académico</a></li>
				<!-- IU1.1-7 -->
				<li><a
					href="${pageContext.request.contextPath}/convocatoria/gestionar-convocatoria">Convocatoria</a></li>
			</ul></li>
		<li class="dropdown"><a title="Proceso de Admisión"
			data-toggle="dropdown" class="dropdown-toggle" href="#"
			aria-expanded="false">Proceso de Admisión<b class="caret"> <!--  -->
			</b></a>
			<ul class="dropdown-menu">
				<li><a href="#">Examen Psicométrico</a></li>
				<li class="dropdown-submenu"><a href="#">Entrevistas</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/entrevistas/gestionar-entrevistas">Gestionar
								Aplicación de Entrevistas</a></li>
						<li><a
							href="${pageContext.request.contextPath}/entrevistas/gestionar-entrevistas!resultados">Resultados
								de Entrevistas</a></li>
					</ul></li>
				<li class="dropdown-submenu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown">Selección de
						Aspirantes</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/admision/aspirantes-aceptar">Aspirantes
								Aceptados</a></li>
					</ul></li>
			</ul></li>
		<li class="dropdown"><a title="Inscripciones"
			data-toggle="dropdown" class="dropdown-toggle" href="#"
			aria-expanded="false">Incripciones</a></li>
		<li class="dropdown"><a title="Evaluaciones"
			data-toggle="dropdown" class="dropdown-toggle" href="#"
			aria-expanded="false">Evaluaciones</a></li>
		<li class="dropdown"><a title="Seguimiento de Egresados"
			data-toggle="dropdown" class="dropdown-toggle" href=""
			aria-expanded="false">Egresados</a></li>
	</ul>
</jsp:root>