<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WallaSwap</title>
<link rel="stylesheet" href="/css/Comun.css">
<script src="/scripts/mainscripts.js"></script>
<script>
	
</script>
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
			<c:forEach var="anuncio" items="${listaanunciosform.listaanuncios}">
				<div class="product">
					<a href="detalles?id=${anuncio.id}"> <img
						src="images/${anuncio.fotos[0]}" alt="${anuncio.titulo}">
						<h3>${anuncio.titulo}</h3>
					</a>
				</div>
			</c:forEach>
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