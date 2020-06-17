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
<title>CheckBoard</title>
</head>
<body>
	<%
		String blockA = "<div class='col px-0'> <img src='resources/img/black.jpg' class='img-fluid mx-0 w-100 h-100'> </img></div>";
		String blockB = "<div class='col px-0'> <img src='resources/img/blank.jpg' class='img-fluid mx-0 w-100 h-100'> </img></div>";
		int rows = 0;
		int cols = 0;
		if (request.getParameter("rows") != null)
			rows = Integer.valueOf(request.getParameter("rows"));
		if (request.getParameter("cols") != null)
			cols = Integer.valueOf(request.getParameter("cols"));
	%>
	<div class="container bg-success p-5">
		<div class="col-10 mx-auto">
			<%
				for (int j = 0; j < rows; j++) {
			%><div class="row">
				<%
					for (int i = 0; i < cols; i++) {
							if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
				%>
				<%=blockA%>
				<%
					} else {
				%>
				<%=blockB%>
				<%
					}
						}
				%>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>