<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Lenguages</title>

<!-- Custom fonts for this template -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">


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

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Creador</th>
											<th>Version</th>
											<th>Acciones</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='lang' items='${languages}'>
											<tr>
												<td><c:out value="${lang.name}" /></td>
												<td><c:out value="${lang.creator}" /></td>
												<td><c:out value="${lang.version}" /></td>
												<td>
													<div class="row">
														<form action="/languages/${lang.id}" method="post" class="mx-1">
															<input type="hidden" name="_method" value="delete">
															<input type="submit" class="btn btn-danger"
																value="Eliminar">
														</form>
														<a class="btn btn-warning"
															href="/languages/${lang.id}/edit">Editar</a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<form:form action="/languages" method="post"
						modelAttribute="language">
						<p>
							<form:label path="name">Name</form:label>
							<form:errors path="name" />
							<form:input path="name" />
						</p>
						<p>
							<form:label path="creator">Creator</form:label>
							<form:errors path="creator" />
							<form:textarea path="creator" />
						</p>
						<p>
							<form:label path="version">Current version</form:label>
							<form:errors path="version" />
							<form:input path="version" />
						</p>
						<input type="submit" value="Submit" />
					</form:form>
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
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>

</body>

</html>
