<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cancion.title}</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<div class="container text-center mt-4 p-4 caja">
		<h2 class="text-light">${cancion.title}</h2>
		<div class="row text-light">
			<p class="col">Artista: ${cancion.artist}</p>
			<a href="/dashboard" class="col-2 btn btn-warning">Dashboard</a>
			<p class="col">Puntuación: ${cancion.rating}</p>
		</div>
		<iframe class="mt-3" width="560" height="315"
			src="https://www.youtube.com/embed/${cancion.url}" frameborder="0"
			allowfullscreen></iframe>
		<div class="row mt-3 adios">
			<a href="/songs/${cancion.id}/edit" class="col-2 btn btn-primary">Editar</a>
			<form class="col-2" action="/songs/${cancion.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					class="btn btn-danger" type="submit" value="Borrar">
			</form>
		</div>
	</div>
</body>
</html>