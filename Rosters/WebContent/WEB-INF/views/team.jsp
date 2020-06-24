<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Tables</title>

<!-- Custom fonts for this template -->
<link href="static/css/all.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="static/css/sb-admin-2.css" rel="stylesheet" type='text/css'>

<!-- Custom styles for this page -->
<link href="static/css/dataTables.bootstrap4.css" rel="stylesheet"
	type='text/css'>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Rosters</h1>
					<p class="mb-4">En esta página podrás revisar los equipos
						existentes en nuestros registros, agregarlos. Como también
						modificar el plantel, agregando y eliminando jugadores.</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<div class="row">
								<h6 class="m-0 font-weight-bold text-primary">
									Jugadores de
									<c:out value="${team.getName()}" />
								</h6>
								<button type="button" class="btn btn-success ml-auto"
									data-toggle="modal" data-target="#newPlayer">Agregar
									nuevo jugador</button>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Apellido</th>
											<th>Edad</th>
											<th>Acciones</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='player' items='${team.getPlayers()}'>
											<tr>
												<td><c:out value="${player.getFirstName()}" /></td>
												<td><c:out value="${player.getLastName()}" /></td>
												<td><c:out value="${player.getAge()}" /></td>
												<td>
													<div class="row">
														<form action="./Team" method="GET" class="mx-1">
															<input type="hidden" name="id"
																value="<c:out value='${team.getId()}' />" /> <input
																type="submit" class="btn btn-warning" value="Editar" />
														</form>
														<form action="./Team" method="GET">
															<input type="hidden" name="id"
																value="<c:out value='${team.getId()}' />"> <input
																type="hidden" name="delete" value="true"> <input
																type="submit" class="btn btn-danger" value="Eliminar">
														</form>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<a type="button" class="btn btn-primary" href="./Home">Volver
						atrás</a>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Gustavo Vigueras 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

		<!-- Modal -->
		<div class="modal fade" id="newPlayer" tabindex="-1" role="dialog"
			aria-labelledby="newPlayerLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="newTeamLabel">Agregar nuevo
							equipo</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="./Player" method="post">
						<div class="modal-body">
							<input type="text" class="form-control" placeholder="Nombre"
								aria-label="Nombre" name="firstName"> <input type="text"
								class="form-control" placeholder="Apellido"
								aria-label="Apellido" name="lastName"> <input
								type="text" class="form-control" placeholder="Edad"
								aria-label="Edad" name="age"> <input type="hidden"
								name="id" value="<c:out value='${team.getId()}' />">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancelar</button>
							<input type="submit" class="btn btn-primary"
								value="Agregar jugador">
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="static/js/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="static/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="static/js/jquery.dataTables.min.js"></script>
	<script src="static/js/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="static/js/datatables-demo.js"></script>

	<!-- End of Modal -->
</body>

</html>
