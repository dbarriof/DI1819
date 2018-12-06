<helpset version="1.0">

	<title>Getion de carreras v1.0</title>
	
	<maps>
		<!-- Pagina inicial de ayuda -->
		<homeID>aplicacion</homeID>
	
		<!-- Mapa usado -->
		<mapref location="map_file.jhm"/>
	</maps>
	
	<!-- vistas mostradas en ayuda-->
	
	<!-- tabla de contenidos -->
	<view>
		<name>Tabla contenidos</name>
		<label>Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>toc.xml</data>
	</view>
	
	<!-- indice -->
	<view>
		<name>Indice</name>
		<label>Indice</label>
		<type>javax.help.IndexView</type>
		<data>indice.xml</data>
	</view>
	
	<!-- Pestaña de busqueda -->
	<view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine">
		JavaHelpSearch</data>
	</view>
	
</helpset>