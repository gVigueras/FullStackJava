<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos a los Eventos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class='container text-center'>
		<h1 class="text-success">Bienvenido al sistema</h1>
		<p>Registrate y crea una cuenta ahora, o si ya
			tienes una ingresa.</p>
		<div class='row justify-content-center'>

			<div class='ml-5 col-4'>
				<h4 class="text-primary">Registrate</h4>
				<form:form action="/register" method="post" modelAttribute="user">

					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-2 text-center col-8 form-control"
							placeholder="Nombre" required="required" type="text"
							path="firstName" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-8 form-control"
							placeholder="Apellido" required="required" type="text"
							name="lastName" path="lastName" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-8 form-control"
							placeholder="E-mail" required="required" type="email"
							name="email" path="email" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-8 form-control"
							placeholder="Contraseña" required="required" type="password"
							name="password" path="password" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-8 form-control"
							placeholder="Confirmar Contraseña" required="required"
							type="password" name="confirmPassword"
							path="passwordConfirmation" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-4 form-control btn btn-primary"
							type="submit" value="Registrarse" />
					</div>
				</form:form>
			</div>

			<div class='ml-5 col-4'>
				<h4 class="text-warning">Ingresar</h4>
				<form action="/login" method="post">

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="E-mail" required="required" type="email"
							name="email" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="Contraseña" required="required" type="password"
							name="password" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-4 form-control btn btn-warning"
							type="submit" value="Ingresar" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>