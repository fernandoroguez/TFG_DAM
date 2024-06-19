<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${producto.nombre}</title>
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
		<div class="container">
			<div class="product-container">
				<div class="product-images">
					<c:forEach var="foto" items="${anuncio.fotos}">
						<div class="product-images-scroll">
							<img src="images/${foto}">
						</div>
					</c:forEach>

				</div>
				<div class="product-details">
					<h1>${anuncio.titulo}</h1>
					<p>${anuncio.descripcion}</p>
					<p>Anuncio de : ${vendedor.nombreUsuario}</p>
				</div>
			</div>
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