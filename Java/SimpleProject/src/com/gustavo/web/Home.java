package com.gustavo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String homeTown = request.getParameter("homeTown");
		String favoriteLanguage = request.getParameter("favoriteLanguage");
		if(userName == null)
			userName = "Unknown";
		if(lastName == null)
			lastName = "Unknown";
		if(homeTown == null)
			homeTown = "Unknown";
		if(favoriteLanguage == null)
			favoriteLanguage = "Unknown";
		response.getWriter().append("<h1>Hola "+userName+" "+lastName+"!</h1>");
		response.getWriter().append("<ul><li>Ciudad: "+homeTown+"</li><li>Lenguaje favorito: "+favoriteLanguage+"</li></ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
