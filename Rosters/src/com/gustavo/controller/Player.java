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
@WebServlet("/Player")
public class Player extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teamdb team = Roster.getTeams().get(Integer.valueOf((String)request.getParameter("id")));
		response.sendRedirect("./Team?id="+team.getId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Teamdb team = Roster.getTeams().get(Integer.valueOf((String)request.getParameter("id")));
		if(request.getParameter("idPlayer") == null) {
			String firstName = (String)request.getParameter("firstName");
			String lastName = (String)request.getParameter("lastName");
			int age = Integer.valueOf(((String)request.getParameter("age")));
			com.gustavo.models.Player player = new com.gustavo.models.Player();
			player.setAge(age);
			player.setFirstName(firstName);
			player.setLastName(lastName);
			player.setId(team.getPlayers().size());
			team.addPlayer(player);

		}else {
			com.gustavo.models.Player player = team.getPlayers().get(Integer.valueOf((String)request.getParameter("idPlayer")));
			if(request.getParameter("delete") == null && request.getParameter("edit") == null){
				request.setAttribute("editPlayer", player);
			}else {
				team.removePlayer(player);
			}
		}
		request.setAttribute("team", team);
		doGet(request, response);
	}

}
