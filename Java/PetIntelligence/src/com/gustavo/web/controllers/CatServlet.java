package com.gustavo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gustavo.web.models.*;

/**
 * Servlet implementation class Cat
 */
@WebServlet("/cat")
public class CatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cat.jsp");
		System.out.println(request.getParameter("weight"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("breed"));
		Cat cat = new Cat(request.getParameter("name"),request.getParameter("breed"),Integer.parseInt(request.getParameter("weight")));
		request.setAttribute("cat", cat);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
