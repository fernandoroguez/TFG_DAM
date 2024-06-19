<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<style>
.main-content {
	margin-left: 300px !important;
}

.main-content.full-width {
	margin-left: 50px !important;
}
</style>
<head>
<meta charset="UTF-8">
<title>Crear Anuncio</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Comun.css">
<script src="${pageContext.request.contextPath}/scripts/mainscripts.js"></script>
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
		<h2>Crear Anuncio</h2>
		<form:form action="${pageContext.request.contextPath}/guardarAnuncio"
			modelAttribute="anuncioForm" method="post"
			enctype="multipart/form-data">
			<form:hidden path="id" />
			<p>
				<label for="titulo">Título:</label>
				<form:input path="titulo" required="true" />
			</p>
			<p>
				<label for="descripcion">Descripción:</label>
				<form:textarea path="descripcion" required="true" />
			</p>
			<p>
				<label for="fotos">Fotos:</label> <input type="file" name="fotos"
					multiple accept="image/*" />
			</p>
			<button type="submit">Guardar Anuncio</button>
		</form:form>
	</div>
	<div id="chat-box" class="chat-box hidden">
		<div class="chat-header" onclick="toggleChat()">Contactos</div>
		<div class="chat-content">
			<ul>
				<c:forEach var="chat" items="${listarusuariosform.listausuarios}">

					<c:if test="${chat.nombreUsuario ne nombreusuario}">
						<a
							href="${pageContext.request.contextPath}/chat?id=${chat.nombreUsuario}"
							class="link-like-text">
							<li>${chat.nombreUsuario}</li>
						</a>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<button id="chat-toggle-btn" class="chat-toggle-btn"
		onclick="toggleChat()">👤</button>
</body>
</html>
