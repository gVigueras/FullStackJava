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
<title>Prueba</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container justify-content-center">

		<form method="post" action="/login">
			<div class="form-group">
				<p style="color: red" class="text-center">
					<c:out value="${error}"></c:out>
				</p>
				<input type="password" class="text-center form-control" id="code"
					aria-describedby="codeHelp" placeholder="Ingrese el código"
					name="code" required="required"> <small id="codeHelp"
					class="text-center form-text text-muted">Solo los elegidos
					podrán atravesar este portal</small>
			</div>
			<button type="submit" class="btn btn-block btn-primary">Ingresar</button>
		</form>
	</div>
</body>
</html>