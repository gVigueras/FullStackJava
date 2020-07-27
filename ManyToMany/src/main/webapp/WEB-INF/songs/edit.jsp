<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editando <c:out value="${cancion.title}" /></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<div class="container text-center mt-4 p-5 caja">
		<h2 class="display-4 text-light">Editando Lenguaje</h2>
		<div class="formulario">
			<form:form action="/songs/${cancion.id}/edit" method="post"
				modelAttribute="cancion">
				<input type="hidden" name="_method" value="put">
				<p class="form-group row">
					<form:label class="text-light col col-form-label" path="title">Título</form:label>
					<form:input path="title" class="col form-control" />
				</p>
				<p class="form-group row">
					<form:label class="text-light col col-form-label" path="artist">Artista</form:label>
					<form:input path="artist" class="col form-control" />
				</p>
				<p class="form-group row">
					<form:label class="text-light col col-form-label" path="url">Vínculo</form:label>
					<form:input path="url" class="col form-control" />
				</p>
				<p class="form-group row">
					<form:label class="text-light col col-form-label" path="rating">Puntuación</form:label>
					<form:input type="number" path="rating" class="col form-control" />
				</p>
				<input type="submit" class="btn btn-success" value="Cambiar" />
				<a href="/dashboard" class="btn btn-warning">Cancelar</a>
			</form:form>
		</div>
		<% if(request.getAttribute("errors") != null){ %>
		<fieldset class="mt-3">
			<legend class="errores">Errores</legend>
			<c:forEach items="${errors}" var="error">
				<p class="errores">
					<c:out value="${error.getDefaultMessage()}" />
				</p>
			</c:forEach>
		</fieldset>
		<% } %>
	</div>
</body>
</html>