<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Canción</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="container text-center mt-4 p-5">
		<h2 class="display-4">Nueva Pregunta</h2>
		<div class="col-10">
			<form action="/new" method="post">
				<p class="form-group row">
					<label class="mx-2">Pregunta</label>
					<input name="question" class="col form-control" />
				</p>
				<p class="form-group row">
					<label class="mx-2">Tags</label>
					<input name="tags" class="col form-control" />
				</p>
				<input type="submit" class="btn btn-success" value="Crear" />
				<a href="/questions" class="btn btn-warning">Volver</a>
			</form>
		</div>
	</div>

</body>
</html>