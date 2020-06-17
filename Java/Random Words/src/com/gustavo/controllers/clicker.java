package com.gustavo.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gustavo.models.User;

/**
 * Servlet implementation class clicker
 */
@WebServlet("/clicker")
public class clicker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int clicks = (Integer)session.getAttribute("clicks") + 1;
		Date date = new Date();
		User user = new User(clicks);
		String word = user.generateWord();
		user.setWord(word);
		System.out.println(word);
		session.setAttribute("word", word);
		session.setAttribute("date", date);
		session.setAttribute("clicks", clicks);
		request.setAttribute("user", user);
		response.sendRedirect("/randomwords");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
