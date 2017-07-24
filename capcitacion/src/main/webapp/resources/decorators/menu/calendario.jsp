<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<s:set var="usuario"
		value="%{#session[@mx.com.emeth.util.NombreObjetosSesion@USUARIO_SESION]}" />
	<nav role="navigation"
		class="navbar navbar-default navbar-fixed-top navbar-eld">
		<div class="container">
			<div class="navbar-header page-scroll">
				<div style="float: left; width: 45px; margin-left: 20px;">
					<img
						src="${pageContext.request.contextPath}/resources/images/logo.png"
						class="logo" />
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
				<ul class="nav navbar-nav">
					<li class="dropdown"><a title="Ciclo Escolar"
						data-toggle="dropdown" class="dropdown-toggle" href="#"
						aria-expanded="false">Ciclo Escolar<b class="caret"> <!--  -->
						</b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Gestionar Ciclos</a></li>
						</ul></li>
					<li class="dropdown"><a title="Proceso de Admisión"
						data-toggle="dropdown" class="dropdown-toggle" href="#"
						aria-expanded="false">Proceso de Admisión<b class="caret">
								<!--  -->
						</b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/general/gestionar-menu!students">Gestionar
									Registro de Aspirantes</a></li>
						</ul></li>
					<li class="dropdown"><a title="Inscripciones"
						data-toggle="dropdown" class="dropdown-toggle" href=""
						aria-expanded="false">Inscripciones<b class="caret"> <!--  -->
						</b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/general/gestionar-menu!groupsAdministration">Groups
									Administration</a></li>
						</ul></li>
					<li class="dropdown"><a title="Evaluaciones"
						data-toggle="dropdown" class="dropdown-toggle" href="#"
						aria-expanded="false">Evakuaciones<b class="caret"> <!--  -->
						</b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/general/gestionar-menu!books">Books
									Administration</a></li>
						</ul></li>
					<li class="dropdown"><a title="Egresados"
						data-toggle="Egresados" class="dropdown-toggle" href="#"
						aria-expanded="false">Account<b class="caret"> <!--  -->
						</b></a>
						<ul class="dropdown-menu">
							<!-- <li><a href="#">Check Account</a></li>  -->
							<li><a
								href="${pageContext.request.contextPath}/general/gestionar-menu!changePassword">Change
									Password</a></li>
						</ul></li>
					<li class="dropdown"><a
						href="${pageContext.request.contextPath}/general/gestionar-menu!logout">Logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
</jsp:root>