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
 * Servlet implementation class Home
 */
@WebServlet("/")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		HttpSession session = request.getSession();
		User user;
		if(null != session.getAttribute("clicks") )
			user = new User((Integer)session.getAttribute("clicks"));
		else
			user = new User(0);
		if(null != session.getAttribute("date"))
			user.setDate((Date)session.getAttribute("date"));
		else
			user.setDate(null);
		if(null != session.getAttribute("word"))
			user.setWord((String)session.getAttribute("word"));
		else
			user.setWord("");
		session.setAttribute("clicks", user.getClicks());
		session.setAttribute("date", user.getDate());
		session.setAttribute("word", user.getWord());
		request.setAttribute("user", user);
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
