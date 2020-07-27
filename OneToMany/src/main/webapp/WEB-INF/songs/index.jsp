<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<div class="container text-center mt-4 p-5 caja">
		<div class="mt-2">
			<a href="/songs/new" class="btn btn-success">Agregar Canción</a> <a
				href="/search/topten" class="btn btn-primary">Top 10 Canciones</a> <input
				type="text" id="buscar" name="buscar" placeholder="Busca un Artista">
			<button id="boton" class="btn btn-info">Buscar</button>
			${dashboard}
		</div>
		<div class="overflow-auto rounded">
			<table class="table">
				<thead class='thead-dark'>
					<tr>
						<th>Título</th>
						<th>Artista</th>
						<th>Puntuación</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${canciones}" var="cancion">
						<tr class='bg-light'>
							<td class='text-center align-middle'><a
								href="/songs/${cancion.id}"><c:out value="${cancion.title}" /></a></td>
							<td class='text-center align-middle'><c:out
									value="${cancion.artist}" /></td>
							<td class='text-center align-middle'><c:out
									value="${cancion.rating}" /></td>
							<td class='text-center'><a href="/songs/${cancion.id}/edit"
								class="btn btn-outline-warning">Editar</a>
								<form action="/songs/${cancion.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										class="btn btn-outline-danger" type="submit" value="Borrar">
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script src="/js/mechanics.js"></script>
</body>
</html>