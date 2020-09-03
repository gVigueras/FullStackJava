<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body class='bg-dark'>
	<div class='container text-center'>
		<h1 class="text-success">Bienvenido al Organizador de Eventos</h1>
		<p class="text-light">Registrate y crea una cuenta ahora, o si ya
			tienes una ingresa.</p>
		<div class='row justify-content-center'>

			<div class='ml-5 col-4'>
				<h4 class="text-primary">Registrate</h4>
				<form action="/register" method="post">

					<div class="form-group d-flex justify-content-center">
						<input class="mt-2 text-center col-8 form-control"
							placeholder="Nombre" required="required" type="text"
							name="firstName" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="Apellido" required="required" type="text"
							name="lastName" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="E-mail" required="required" type="email" name="email" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="Ciudad" required="required" type="text" name="city" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<select class="mt-1 text-center col-8 form-control"
							required="required" name="region">
							<option value="null" selected>Región</option>
							<option value="Arica y Parinacota">Arica y Parinacota</option>
							<option value="Tarapacá">Tarapacá</option>
							<option value="Antofagasta">Antofagasta</option>
							<option value="Atacama">Atacama</option>
							<option value="Coquimbo">Coquimbo</option>
							<option value="Valparaíso">Valparaíso</option>
							<option value="Metropolitana">Metropolitana</option>
							<option value="Bernardo O'Higgins">Bernardo O'Higgins</option>
							<option value="Maule">Maule</option>
							<option value="Ñuble">Ñuble</option>
							<option value="Biobío">Biobío</option>
							<option value="Araucanía">Araucanía</option>
							<option value="Los Ríos">Los Ríos</option>
							<option value="Los Lagos">Los Lagos</option>
							<option value="Aysén">Aysén</option>
							<option value="Magallanes">Magallanes</option>
						</select>
					</div>

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="Contraseña" required="required" type="password"
							name="password" />
					</div>

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="Confirmar Contraseña" required="required"
							type="password" name="confirmPassword" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-4 form-control btn btn-primary"
							type="submit" value="Registrarse" />
					</div>
				</form>
			</div>

			<div class='ml-5 col-4'>
				<h4 class="text-warning">Ingresar</h4>
				<form action="/login" method="post">

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control"
							placeholder="E-mail" required="required" type="email" name="email" />
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
				${result}
				<p class="text-center text-danger">
					<small>${errorA}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorB}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorC}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorD}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorE}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorF}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorG}</small>
				</p>
				<p class="text-center text-danger">
					<small>${errorH}</small>
				</p>
			</div>
		</div>
	</div>
</body>
</html>