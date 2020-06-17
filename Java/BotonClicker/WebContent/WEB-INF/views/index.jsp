<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Boton clicker</title>
</head>
<body>
	<form action="clicker">
		<h1>
			Has hecho
			<c:out value="${user.getClicks()}" />
			clicks
		</h1>
		<button type="submit" class="btn btn-primary">Aumenta tu cuenta!</button>
</body>
</html>