<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>

<body>
<body>
	<div class="container">
		<h1>${question.question}</h1>
		<h2>
			Tags:
			<c:forEach var="tag" items="${question.tags}">
				<span class="border border-primary rounded">${tag.subject} </span>
			</c:forEach>
		</h2>
		<div class="container">
			<h2>Agrega tu respuesta:</h2>
			<form action="/questions/${question.id}" method="post">
				<div class="form-group">
		    	<label>Respuesta: <textarea required="required"
							name="answer" class="form-control" rows="4" cols="500"></textarea></label>
		    	</div>
		    	<input class="btn btn-success" type="submit" value="Crear" />
		    	<a class="btn btn-warning" href="/questions">Volver</a>
			</form>
		</div>
		<div class="container">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Respuestas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="answer" items="${question.answers}">
					<tr>
						<td>${answer.answer}</td>		
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
        </body>


        
</html>