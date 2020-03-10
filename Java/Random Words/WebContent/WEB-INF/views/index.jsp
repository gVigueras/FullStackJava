<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container p-5 justify-content-center">
		<form action="clicker">
			<div class="form-group">
				<h1>
					Has solicitado una nueva palabra
					<c:out value="${user.getClicks()}" />
					veces.
				</h1>
			</div>
			<div class="form-group">
				<label for="word">Palabra Aleatoria:</label> <input id="inputWord" name="word"
					type="text" class="text-center" value='<c:out value="${user.getWord()}" />' disabled>
			</div>
			<div class="form-group">
				<label for="date">Última solicitud:</label> <input class="text-center" id="date"
					type="text" value='<c:out value="${user.getDate()}" />' disabled>
			</div>
			<button type="submit" class="btn btn-primary">Generar!</button>
		</form>
	</div>
</body>
</html>