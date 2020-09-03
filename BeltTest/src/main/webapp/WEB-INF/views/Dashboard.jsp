<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<body class='bg-dark'>
	<div class='container text-center'>
		<div class='mt-4 d-flex justify-content-between'>
			<h3 class='text-success'>Bienvenido ${user.firstName} este es tu
				organizador de Eventos</h3>
			<form action="/logout" method="post">
				<input class="text-center col form-control btn btn-danger"
					type="submit" value="Cerrar Sesion" />
			</form>
		</div>
		<c:if test="${events.size() > 0 || locales.size() > 0}">
			<c:if test="${locales.size() > 0}">
				<h6 class="text-light d-flex justify-content-start">Aqui estan
					los eventos en tu región</h6>
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th class='text-primary'>Nombre</th>
							<th class='text-primary'>Fecha</th>
							<th class='text-primary'>Ciudad</th>
							<th class='text-primary'>Anfitrion</th>
							<th class='text-primary'>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${locales}" var="local">
							<tr>
								<td><a class="btn btn-outline-primary border-0"
									href="/event/${local.id}">${local.name}</a></td>
								<td class="text-light"><fmt:formatDate
										pattern="dd-MMMM-yyyy" value="${local.date}" /></td>
								<td class="text-light">${local.city}</td>
								<td class="text-light">${local.host.firstName}</td>
								<td class="d-flex justify-content-center"><c:choose>
										<c:when test="${local.host.id == user.id}">
											<a class="btn btn-primary" href="/event/${local.id}/edit">Editar</a>
											<form action="/event/${local.id}/delete" method="post">
												<input class="ml-2 btn btn-danger" type="submit"
													value="Borrar" />
											</form>
										</c:when>
										<c:otherwise>
											<c:set var="invitado" value="${false}" />
											<c:forEach items="${user.events}" var="even">
												<c:if test="${even.id eq local.id}">
													<c:set var="invitado" value="${true}" />
												</c:if>
											</c:forEach>
											<c:choose>
												<c:when test="${invitado}">
													<form action="/event/${local.id}/cancel" method="post">
														<div class="d-flex justify-content-center">
															<p class="text-muted">Unido</p>
															<input class="ml-2 btn btn-danger" type="submit"
																value="Cancelar" />
														</div>
													</form>
												</c:when>
												<c:otherwise>
													<form action="/event/${local.id}/join" method="post">
														<input class="btn btn-primary" type="submit"
															value="Unirse" />
													</form>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${events.size() > 0}">
				<h6 class="text-light d-flex justify-content-start">Aqui hay
					eventos en otras regiones</h6>
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th class='text-primary'>Nombre</th>
							<th class='text-primary'>Fecha</th>
							<th class='text-primary'>Ciudad</th>
							<th class='text-primary'>Región</th>
							<th class='text-primary'>Anfitrion</th>
							<th class='text-primary'>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${events}" var="evento">
							<tr>
								<td><a class="btn btn-outline-primary border-0"
									href="/event/${evento.id}">${evento.name}</a></td>
								<td class="text-light"><fmt:formatDate
										pattern="dd-MMMM-yyyy" value="${evento.date}" /></td>
								<td class="text-light">${evento.city}</td>
								<td class="text-light">${evento.region}</td>
								<td class="text-light">${evento.host.firstName}</td>
								<td class="d-flex justify-content-center"><c:choose>
										<c:when test="${evento.host.id == user.id}">
											<a class="btn btn-primary" href="/event/${evento.id}/edit">Editar</a>
											<form action="/event/${evento.id}/delete" method="post">
												<input class="ml-2 btn btn-danger" type="submit"
													value="Borrar" />
											</form>
										</c:when>
										<c:otherwise>
											<c:set var="invitado2" value="${false}" />
											<c:forEach items="${user.events}" var="even">
												<c:if test="${even.id eq local.id}">
													<c:set var="invitado2" value="${true}" />
												</c:if>
											</c:forEach>
											<c:choose>
												<c:when test="${invitado2}">
													<form action="/event/${local.id}/cancel" method="post">
														<div class="d-flex justify-content-center">
															<p class="text-muted">Unido</p>
															<input class="ml-2 btn btn-danger" type="submit"
																value="Cancelar" />
														</div>
													</form>
												</c:when>
												<c:otherwise>
													<form action="/event/${local.id}/join" method="post">
														<input class="btn btn-primary" type="submit"
															value="Unirse" />
													</form>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</c:if>
		<div class="row">
			<div class="mt-4 col-4">
				<h4 class="text-warning">Nuevo Evento</h4>
				<form action="/event/new" method="post">

					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-12 form-control"
							placeholder="Nombre" required="required" type="text" name="name" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-12 form-control"
							required="required" type="date" name="date" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-12 form-control"
							placeholder="Ciudad" required="required" type="text" name="city" />
					</div>
					<div class="form-group d-flex justify-content-center">
						<select class="mt-1 text-center col-12 form-control"
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
						<input class="mt-1 text-center col-8 form-control btn btn-warning"
							type="submit" value="Ingresar" />
					</div>
				</form>
			</div>
			<div class="mt-4 col-6">
				<p class="text-center text-danger">${errorA}</p>
				<p class="text-center text-danger">${errorB}</p>
				<p class="text-center text-danger">${errorC}</p>
			</div>
		</div>
	</div>
</body>
</html>