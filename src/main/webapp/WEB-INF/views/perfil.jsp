<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.product-images {
	width: 100%;
	max-width: 100% !important;
}

.product-images-scroll {
	margin: 0px 0px 0 !important;
}

.product-container {
	display: flex;
	max-width: 80% !important;
}
</style>
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
				<strong>Nombre de usuario:</strong>
				<c:out value="${usuario.nombreUsuario}" />
			</p>
			<p>
				<strong>Nombre:</strong>
				<c:out value="${usuario.nombre}" />
			</p>
			<p>
				<strong>Apellidos:</strong>
				<c:out value="${usuario.apellidos}" />
			</p>
			<p>
				<strong>Localidad:</strong>
				<c:out value="${usuario.localidad}" />
			</p>
			<p>
				<strong>Datos de contacto:</strong>
				<c:out value="${usuario.infoContacto}" />
			</p>


			<div class="container">
				<div class="product-container">
					<div class="product-images">

						<c:forEach var="anuncio"
							items="${listaanunciosform.listaanunciospropios}">
							<div class="product-images-scroll">
								<div class="product">
									<img src="images/${anuncio.fotos[0]}" alt="${anuncio.titulo}">
									<p>${anuncio.titulo}</p>
									</a>
								</div>
							</div>
						</c:forEach>


					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/crearAnuncio" class="btn">Crear
				Anuncio</a>

		</div>
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