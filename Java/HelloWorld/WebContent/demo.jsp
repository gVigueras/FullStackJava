<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <!-- Obtenemos el valor del parámetro name -->
    <% String req = request.getParameter("name"); %>
    <!-- Mostramos el valor que obtuvimos -->
    <h1><%= req %></h1>
</body>
</html>