<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido ${user.firstName}</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class='container text-center'>
		<div class='mt-4 d-flex justify-content-between'>
			<h3 class='text-success'>Bienvenido ${user.firstName} a la vista
				de Administrador</h3>
			<form action="/logout" method="post">
				<input class="text-center col form-control btn btn-danger"
					type="submit" value="Cerrar Sesion" />
			</form>
		</div>
		<h6 class="d-flex justify-content-start">Customers</h6>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th class='text-primary'>Name</th>
					<th class='text-primary'>Next Due Date</th>
					<th class='text-primary'>Amount Due</th>
					<th class='text-primary'>Package Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="user">
					<tr>
						<td>${user.firstName}${user.lastName}</td>
						<td><fmt:formatDate pattern="dd-MMMM-yyyy"
								value="${user.nextDueDate}" /></td>
						<td>$ ${user.myPackage.cost}</td>
						<td>${user.myPackage.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<h6 class="text-light d-flex justify-content-start">Packages</h6>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th class='text-primary'>Name</th>
					<th class='text-primary'>Cost</th>
					<th class='text-primary'>Available</th>
					<th class='text-primary'>Users</th>
					<th class='text-primary'>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${packages}" var="pack">
					<tr>
						<td>${pack.name}</td>
						<td>$ ${pack.cost}</td>
						<td><c:if test="${pack.available}">Available</c:if> <c:if
								test="${!pack.available}">Unavailable</c:if></td>
						<td>${pack.customers.size()}</td>
						<td><a
							<c:if test="${pack.customers.size() == 0 || !pack.available}">href="/package/${pack.id}/toggleActivation"</c:if>><c:if
									test="${pack.available}">Desactivar</c:if> <c:if
									test="${!pack.available}">Activar</c:if></a> || <a
							href="packages/${pack.id}/edit">Editar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row">
			<div class="mt-4 col-4">
				<h4 class="text-warning">Create Package</h4>
				<form:form action="/package/new" method="post" modelAttribute="pack">

					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-12 form-control"
							placeholder="Nombre" required="required" type="text" name="name"
							path="name" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-12 form-control"
							required="required" placeholder="costo" type="number" name="cost"
							path="cost" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<form:input class="mt-1 text-center col-12 form-control"
							required="required" type="hidden" name="available"
							path="available" value="1" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="btn btn-success" type="submit" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>