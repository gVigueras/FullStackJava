<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Pets</title>
</head>
<body>
	<div class="container pb-5">
		<div class="row mt-5">
			<!-- Formulario 1 -->
			<div class="col-5 bg-light mx-auto p-5">
				<form action="/PetIntelligence/dog">
					<div class="form-group">
						<h1>Nuevo perro:</h1>
						<label for="inputName">Nombre</label> <input type="text"
							class="form-control" id="inputName" name="name"
							placeholder="Ingresa su nombre">
					</div>
					<div class="form-group">
						<label for="inputBreed">Raza</label> <input type="text"
							class="form-control" id="inputBreed" name="breed"
							placeholder="Ingresa su raza">
					</div>
					<div class="form-group">
						<label for="inputWeight">Peso <span class="text-muted">(en
								libras)</span></label> <input type="number" name="weight" class="form-control"
							id="inputWeight">
					</div>
					<button type="submit" class="btn btn-primary">Ingresar
						mascota</button>
				</form>
			</div>
			<!-- Formulario 2 -->
			<div class="col-5 mx-auto p-5 bg-light">
				<form action="/PetIntelligence/cat">
					<div class="form-group">
						<h1>Nuevo gato:</h1>
						<label for="inputName">Nombre</label> <input type="text"
							class="form-control" id="inputName"
							placeholder="Ingresa su nombre" name="name">
					</div>
					<div class="form-group">
						<label for="inputBreed">Raza</label> <input type="text"
							name="breed" class="form-control" id="inputBreed"
							placeholder="Ingresa su raza">
					</div>
					<div class="form-group">
						<label for="inputWeight">Peso <span class="text-muted">(en
								libras)</span></label> <input type="number" class="form-control"
							id="inputWeight" name="weight">
					</div>
					<button type="submit" class="btn btn-primary">Ingresar
						mascota</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>