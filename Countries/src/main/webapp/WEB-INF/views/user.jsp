<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subscripciones</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
		<div class="col-2 offset-lg-9">
			<form action="/logout" method="post">
				<input class="btn btn-danger" type="submit"
					value="Cerrar Sesion" />
			</form>
		</div>

	<div class='container-fluid col-6'>
		<h1>Bienvenido ${user.firstName}!</h1>

		<form:form action="/users/${user.id}/changePackage"
			modelAttribute="pack" method="post">
			<div class="form-group d-flex">
				<form:label path="name">Paquete actual:</form:label>
				<form:input class="mx-auto" path="name" disabled="true" />
			</div>
			<div class="form-group d-flex">
				<form:label path="cost">Costo del paquete:</form:label>
				<form:input class="mx-auto" path="cost" disabled="true" />
			</div>
			<div class="form-group d-flex">
				<form:label path="id">Seleccione su nuevo paquete:</form:label>
				<form:select class="mx-auto text-center col-3 form-control"
					path="id" required="required" items="${packages}" itemLabel="name"
					itemValue="id" />
			</div>
			<div class="form-group d-flex justify-content-center">
				<input class="btn btn-success btn-block" type="submit" />
			</div>

		</form:form>
	</div>
</body>
</html>