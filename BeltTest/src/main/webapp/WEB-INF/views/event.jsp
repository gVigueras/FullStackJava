<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${event.name}</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body class="bg-dark">
	<c:set var="invitado" value="${false}" />
	<c:if test="${event.host.id eq user.id}">
		<c:set var="invitado" value="${true}" />
	</c:if>
	<div class="container">
		<div class="container d-flex justify-content-between">
			<h1 class="text-success mt-4">${event.name}</h1>
			<a href="/dashboard" class="mb-4 mt-4 btn btn-primary">Volver</a>
		</div>
		<div class="d-flex justify-content-between">
			<div class="">
				<p class="text-light">Anfitrión: ${event.host.firstName}
					${event.host.lastName}</p>
				<p class="text-light">
					Fecha:
					<fmt:formatDate pattern="dd-MMMM-yyyy" value="${event.date}" />
				</p>
				<p class="text-light">Localización: ${event.city},
					${event.region}</p>
				<h4 class="text-warning">Personas que actualmente estan unidos
					al evento</h4>
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th class='text-primary'>Nombre</th>
							<th class='text-primary'>Localización</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.guests}" var="persona">
							<tr>
								<td class="text-light">${persona.firstName}
									${persona.lastName}</td>
								<td class="text-light">${persona.city},${persona.region}</td>
							</tr>
							<c:if test="${persona.id eq user.id}">
								<c:set var="invitado" value="${true}" />
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="">
				<h4 class="text-warning">Comentarios</h4>
				<textarea class="rounded" readonly cols="50" rows="10">
				<c:forEach items="${event.coments}" var="mensaje">${mensaje.user.firstName} dice: ${mensaje.message}</c:forEach>
				</textarea>
				<c:if test="${invitado}">
					<h6 class="mt-4 text-warning">Nuevo Comentario</h6>
					<div class="form-group">
						<form action="/event/${event.id}" method="post">
							<input class="form-control" placeholder="Mensaje" type="text"
								name="message" /> <input class="mt-4 btn btn-primary"
								type="submit" value="Unirse" />
						</form>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>