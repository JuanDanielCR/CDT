<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:text>
	<![CDATA[
	<script
		src="${pageContext.request.contextPath}/pages/example/example/js/index.js" type="text/javascript"></script>
	]]>
</jsp:text>
</head>
<body>
	<h1 class="title">Componentes visuales para el proyecto</h1>

	<!-- Accordion -->
	<div class="row form">
		<s:form>
			<div class="section first">Accordion</div>
			<div class="form-group">
				<sj:accordion id="accordion" heightStyle="content" animate="true">
					<sj:accordionItem title="Acordion 1">
			Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.	
		</sj:accordionItem>
					<sj:accordionItem title="Acordion 2">
		Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.
	</sj:accordionItem>
					<sj:accordionItem title="Acordion 3">
		Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
	</sj:accordionItem>
					<sj:accordionItem title="Acordion 4">
		Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.	
	</sj:accordionItem>
				</sj:accordion>
			</div>
			<!-- Autocomplete -->
			<div class="section">Autocomplete</div>
			<div class="form-group">
				<sj:autocompleter id="languages" name="echo"
					list="%{'Elemento 1','Elemento 2', 'Elemento 3'}"
					label="Select Languages" />
				<br />
			</div>
			<!-- Tabs -->
			<div class="section">Tabs</div>
			<sj:tabbedpanel id="localtabs">
				<sj:tab id="tab1" target="tone" label="Local Tab One" />
				<sj:tab id="tab2" target="ttwo" label="Local Tab Two" />
				<sj:tab id="tab3" target="tthree" label="Local Tab Three" />
				<sj:tab id="tab4" target="tfour" label="Local Tab Four" />
				<div id="tone">Mauris mauris ante, blandit et, ultrices a,
					suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie
					vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec
					suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur
					malesuada. Vestibulum a velit eu ante scelerisque vulputate.</div>
				<div id="ttwo">Sed non urna. Donec et ante. Phasellus eu
					ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at
					aliquet laoreet, mauris turpis porttitor velit, faucibus interdum
					tellus libero ac justo. Vivamus non quam. In suscipit faucibus
					urna.</div>
				<div id="tthree">Nam enim risus, molestie et, porta ac,
					aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus
					in massa. Aenean in pede. Phasellus ac libero ac tellus
					pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia
					ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.</div>
				<div id="tfour">Cras dictum. Pellentesque habitant morbi
					tristique senectus et netus et malesuada fames ac turpis egestas.
					Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
					posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse
					eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
					Class aptent taciti sociosqu ad litora torquent per conubia nostra,
					per inceptos himenaeos.</div>
			</sj:tabbedpanel>

			<div class="section">Dialog</div>
			<div class="form-group">
				<sj:dialog id="myclickdialog" autoOpen="false" modal="true"
					title="Modal Dialog">
 Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
</sj:dialog>
				<sj:a openDialog="myclickdialog" button="true"
					buttonIcon="ui-icon-newwin">
    Open modal dialog
    </sj:a>

			</div>

			<!-- Slider -->
			<div class="section">Slider</div>
			<div class="form-group">
				<sj:slider id="simpleslider" />
			</div>


			<!-- Datepicker -->
			<div class="section">Datepicker</div>
			<div class="form-group">
				<sj:datepicker id="datepeaker" changeYear="true" changeMonth="true"
					buttonImageOnly="true" />
			</div>


			<!-- Progressbar -->
			<div class="section">Progressbar</div>
			<div class="form-group">
				<sj:progressbar id="progressbar" value="50" />
			</div>
			<!-- Spinner -->
			<div class="section">Spinner</div>
			<div class="form-group">
				<sj:spinner name="spinner1" id="spinner1" />
			</div>
			<!-- Highlight / Error -->
			<div class="section">Highlight / Error</div>
			<div class="ui-widget">
				<div class="ui-state-highlight ui-corner-all"
					style="margin-top: 20px; padding: 0 .3em; padding-top: 12px !important;">
					<p>
						<span class="ui-icon ui-icon-info"
							style="float: left; margin-right: .3em;"> <!-- -->
						</span> <strong>Hey!</strong> Sample ui-state-highlight style.
					</p>
				</div>
			</div>
			<br />
			<div class="ui-widget">
				<div class="ui-state-error ui-corner-all"
					style="padding: 0 .3em; padding-top: 12; padding-top: 12px !important;">
					<p>
						<span class="ui-icon ui-icon-alert"
							style="float: left; margin-right: .3em;"> <!-- -->
						</span> <strong>Alert:</strong> Sample ui-state-error style.
					</p>
				</div>
			</div>
		</s:form>
		<div class="row">
			<div class="col-md-12 buttons">
				<a id="btnAcpt" class="btn btn-default" onclick=""> <s:text
						name="Aceptar" /></a> <a id="btnCncl" class="btn btn-default"
					onclick=""> <s:text name="Cancelar" /></a>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>