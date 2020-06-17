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
<title>Great number!</title>
</head>
<body>
	<div class="container p-5 justify-content-center">
		<div class="col-8 mx-auto">
			<form action="/greatnumber/" method="POST">
				<div class="form-group">
					<h1>
						Has intentado
						<c:out value="${user.getAttempts()}" />
						veces.
					</h1>
				</div>
				<div class="form-group">
					<label for="inputNumber">Adivine el número:</label> <input
						id="inputNumber" name="number" type="number" class="text-center"
						value='<c:out value="${user.getLastTry()}" />'>
				</div>
				<div class="form-group">
					<label for="flag">¿Cómo te va?:</label> <input
						class="text-center bg-light" id="flag" type="text"
						value='<c:out value="${user.getFlag()}" />' disabled>
				</div>
				<button type="submit" class="btn btn-primary mx-auto">
					<c:choose>
						<c:when test="${user.getLastTry()==user.getNumber()}">
        ¡Jugar de nuevo! 
    </c:when>
						<c:otherwise>
        ¡Adivinar! 
    </c:otherwise>
					</c:choose>
				</button>
			</form>
		</div>
	</div>
</body>
</html>