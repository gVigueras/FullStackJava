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
	<div class='container col-6'>
		<h1>Package: ${package.name}</h1>
		<form action="/packages/editCost/${package.id}" method="post">
			<div class="form-group d-flex justify-content-center">
				<input class="mt-1 text-center col-12 form-control"
					required="required" type="number" name="cost" value="${package.cost}" />
			</div>
			<p class="text-danger">${error}</p>
			<div class="row">
				<div class="form-group d-flex justify-content-center">
					<input class="btn btn-success" type="submit" />
				</div>
				<div class="form-group d-flex justify-content-center">
					<a class="btn btn-danger" href="/package/delete/${package.id}">Borrar</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>