package com.gustavo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gustavo.models.Roster;
import com.gustavo.models.Teamdb;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * Servlet implementation class Team
 */
@WebServlet("/Team")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((null != request.getParameter("delete")) && (((String)request.getParameter("delete")).equals("true")) && (null != request.getParameter("id"))) {
			Teamdb team = new Teamdb();
			team.setId(Integer.valueOf((String)request.getParameter("id")));
			Roster.removeTeam(team);
			response.sendRedirect("./Home");
		}else {
			if(null != request.getParameter("id"))
				request.setAttribute("team", Roster.getTeams().get(Integer.valueOf((String)request.getParameter("id"))));
			else
				request.setAttribute("team", Roster.getTeams().get(Integer.valueOf((String)request.getAttribute("id"))));
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/team.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Roster.addTeam(request.getParameter("team"));
		String id = Integer.toString(Roster.getTeams().get(Roster.getTeams().size()-1).getId());
		request.setAttribute("id", id);
		doGet(request, response);
	}

}
