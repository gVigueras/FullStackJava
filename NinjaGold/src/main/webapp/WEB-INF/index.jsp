<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<title>Gold!</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container justify-content-center">
		<div class="form-group row">
			<label for="gold" class="col-sm-2 col-form-label">Gold</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext" id="gold"
					value="${gold}">
			</div>
		</div>
		<div class="row">
			<form method="post" action="/sendPost" class="col-3">
				<div class="form-group">
					<h1>Farm</h1>
					<h5>(Earns 10-20 gold)</h5>
					<input type="text" class="form-control" name="place" value="farm"
						hidden>
					<button type="submit" class="btn btn-block btn-warning">Find
						Gold!</button>
				</div>
			</form>
			<form method="post" action="/sendPost" class="col-3">
				<div class="form-group">
					<h1>Cave</h1>
					<h5>(Earns 5-10 gold)</h5>
					<input type="text" class="form-control" name="place" value="cave"
						hidden>
					<button type="submit" class="btn btn-block btn-warning">Find
						Gold!</button>
				</div>
			</form>
			<form method="post" action="/sendPost" class="col-3">
				<div class="form-group">
					<h1>House</h1>
					<h5>(Earns 2-5 gold)</h5>
					<input type="text" class="form-control" name="place" value="house"
						hidden>
					<button type="submit" class="btn btn-block btn-warning">Find
						Gold!</button>
				</div>
			</form>
			<form method="post" action="/sendPost" class="col-3">
				<div class="form-group">
					<h1>Casino</h1>
					<h5>(Earns/Takes 0-50 gold)</h5>
					<input type="text" class="form-control" name="place" value="casino"
						hidden>
					<button type="submit" class="btn btn-block btn-warning">Find
						Gold!</button>
				</div>
			</form>
		</div>
		<div class="overflow-auto" id="scroll" style="max-height: 250px">${activities}</div>

	</div>
</body>

<script type="text/javascript">
$( document ).ready(function() {
	var objDiv = document.getElementById("scroll");
	objDiv.scrollTop = objDiv.scrollHeight;;
});
</script>

</html>