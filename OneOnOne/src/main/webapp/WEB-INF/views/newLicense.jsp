<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Licencia</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="mt-4 col-4 mx-auto">
			<h4 class="text-warning">Course</h4>
			<form:form action="/licenses/new" method="post"
				modelAttribute="license">

				<div class="form-group d-flex justify-content-center">
					<form:label path="name">Person: </form:label>
					<form:select class="mx-auto text-center col-3 form-control"
					path="person" required="required" items="${persons}" itemLabel="name"
					itemValue="person" />
				</div>
				<div class="form-group d-flex justify-content-center">
					<form:label path="instructor">Instructor: </form:label>
					<form:input class="ml-5 text-center col-12 form-control"
						required="required" placeholder="Instructor" type="text"
						name="instructor" path="instructor" />
				</div>
				<div class="form-group d-flex justify-content-center">
					<form:label path="capacity">Capacity: </form:label>
					<form:input class="ml-5 text-center col-12 form-control"
						required="required" type="number" name="capacity" path="capacity" />
				</div>
				<p class="text-danger">${error}</p>
				<div class="form-group d-flex justify-content-center">
					<input class="btn btn-success" type="submit" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>