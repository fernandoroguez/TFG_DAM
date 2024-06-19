<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Perfil del Usuario</title>
<link rel="stylesheet" href="/css/Comun.css">
<script src="/scripts/mainscripts.js"></script>
</head>
<body>
	<button id="toggle-btn" class="toggle-btn" onclick="toggleSidebar()">☰</button>
	<div id="sidebar" class="sidebar">
		<h2>Menú</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/">Inicio</a></li>
			<li><a href="${pageContext.request.contextPath}/verperfil">Informacion
					de Usuario</a></li>
		</ul>
	</div>
	<div id="main-content" class="main-content">
		<div class="profile">
			<h2>Perfil del Usuario</h2>
			<p>
				<strong>Nombre de usuario contacto:</strong>
				<c:out value="${usuario.nombreUsuario}" />
			</p>
			<p>
				<strong>Nombre:</strong>
				<c:out value="${usuario.nombre}" />
			</p>
			<p>
				<strong>Datos de contacto:</strong>
				<c:out value="${usuario.infoContacto}" />
			</p>

		</div>
	</div>
</body>
</html>