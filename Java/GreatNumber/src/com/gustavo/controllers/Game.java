package com.gustavo.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gustavo.models.User;

/**
 * Servlet implementation class Game
 */
@WebServlet("/")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		HttpSession session = request.getSession();
		User user;
		if(null != session.getAttribute("user") )
			user = (User)session.getAttribute("user");
		else
			user = new User(0);

		session.setAttribute("user", user);
		request.setAttribute("user", user);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		int number = Integer.valueOf(request.getParameter("number"));
		User user = (User)session.getAttribute("user");
		user.setLastTry(number);
		user.setAttempts(user.getAttempts()+1);
		session.setAttribute("user", user);
		request.setAttribute("user", user);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

}
