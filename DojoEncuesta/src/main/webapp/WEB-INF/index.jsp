<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Encuesta</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container justify-content-center">

		<form method="post" action="/sendPost" class="col-3">
			<div class="form-group">
			<label for="name">Nombre:</label>
				<input type="text" class="form-control" id="name" name="name"
					required="required">
			</div>
			<div class="form-group">
				<label for="location">Ubicación del Dojo:</label> <select
					class="form-control" id="location" name="location">
					<option>Temuco</option>
					<option>Padre las Casas</option>
					<option>Labranza</option>
				</select>
			</div>
			<div class="form-group">
				<label for="language">Lenguaje favorito:</label> <select
					class="form-control" id="language" name="language">
					<option>Python</option>
					<option>Java</option>
					<option>c++</option>
				</select>
			</div>
			<div class="form-group">
				<label for="comments">Comentarios (opcionales)</label>
				<textarea class="form-control" id="comments" name="comments"
					rows="3"></textarea>
			</div>
			<button type="submit" class="btn btn-block btn-primary">Enviar</button>
		</form>
	</div>
</body>
</html>