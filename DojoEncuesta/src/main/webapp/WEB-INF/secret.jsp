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
<title>Resultados</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container justify-content-center">

		<form>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Nombre:</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="staticEmail" value="${name}">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Ubicación:</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="staticEmail" value="${location}">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Lenguaje
					favorito:</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="staticEmail" value="${language}">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Comentarios:</label>
				<div class="col-sm-10">
					<textarea readonly class="form-control-plaintext" id="staticEmail"
						value="email@example.com">${comments}</textarea>
				</div>
			</div>
		</form>
	</div>
</body>
</html>