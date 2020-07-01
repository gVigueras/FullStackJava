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

<title>Timer</title>

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
					<h1 class="h3 mb-2 text-gray-800">Timer</h1>
					<p class="mb-4">Bienvenido a tu cronómetro online favorito.</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<div class="row">
								<form action="./Home" method="post" class="mx-auto">
									<input type="hidden" name="action" value="start" /> <input
										type="submit" class="btn btn-success" value="Iniciar" />
								</form>
								<form action="./Home" method="post" class="mx-auto">
									<input type="hidden" name="action" value="stop" /> <input
										type="submit" class="btn btn-danger" value="Parar" />
								</form>
								<form action="./Home" method="post" class="mx-auto">
									<input type="hidden" name="action" value="reset" /> <input
										type="submit" class="btn btn-warning" value="Reiniciar" />
								</form>
							</div>
							<div class="row">
								<div class="col-3 mx-auto">
									<h4 class="text-center">
										<c:out value="${startTime}" />
									</h4>
								</div>
								<div class="col-3 mx-auto">
									<h4 class="text-center">
										<c:out value="${currentTime}" />
									</h4>
								</div>
								<div class="col-3 mx-auto">
									<h4 class="text-center">
										<c:out value="${runningTime}" />
									</h4>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>Comienzo</th>
											<th>Fin</th>
											<th>Duración</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='timer' items='${timerList}'>
											<tr>
												<td><c:out value="${timer.getStartTime()}" /></td>
												<td><c:out value="${timer.getEndTime()}" /></td>
												<td><c:out value="${timer.getTotal()}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

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

</body>

</html>
