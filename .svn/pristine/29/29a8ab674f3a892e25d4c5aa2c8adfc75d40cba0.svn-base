<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<nav role="navigation"
		class="navbar navbar-default navbar-fixed-top navbar-eld">
		<div class="container">
			<div class="navbar-header page-scroll">
				<div style="float: left; width: 45px; margin-left: 20px;">
					<a href="${pageContext.request.contextPath}/control-acceso/login">
					<img
						src="${pageContext.request.contextPath}/resources/images/logo.png"
						class="logo" /></a>
				</div>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--  <a class="navbar-brand page-scroll" href=""><s:property
						value="getText('com.sprach.globalName')" /></a>-->
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<s:set var="usuario" value="%{#session['usuario']}" />

				<s:if test="#usuario eq 'aspirante'">
					<!--<s:include value="./menu/aspirante.jsp" />-->
				</s:if>
				<s:elseif test="#usuario eq 'entrevistador'">
				</s:elseif>
				<!--<s:elseif test="#usuario eq 'aspirante_eld'">
					<s:include value="./menu/eld.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'pago_examen'">
					<s:include value="./menu/aspirante.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'ceneval'">
					<s:include value="./menu/eld.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'gestion_entrevistas'">
					<s:include value="./menu/eld.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'evaluar_entrevistas'">
					<s:include value="./menu/eld.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'aplicacion_entrevistas'">
					<s:include value="./menu/eld.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'seleccion_estudiantes'">
					<s:include value="./menu/eld.jsp" />
				</s:elseif>-->
				<s:elseif test="#usuario eq 'coordinacion_control_escolar'">
					<s:include value="./menu/controlEscolar.jsp" />
				</s:elseif>
				<s:elseif test="#usuario eq 'secretaria_administracion'">
					<s:include value="./menu/secretariaAdministracion.jsp" />
				</s:elseif>
				<s:else></s:else>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
</jsp:root>