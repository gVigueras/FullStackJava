package com.gustavo.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gustavo.models.Timer;
import com.gustavo.models.TimerLog;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("timerList", Timer.getList());
		session.setAttribute("currentTime", LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
		LocalTime start = (LocalTime) session.getAttribute("startTime");
		if(start!=null) {
			long millis = start.until(LocalTime.now(), ChronoUnit.MILLIS);;
			String total = String.format("%02d min, %02d sec", 
				    TimeUnit.MILLISECONDS.toMinutes(millis),
				    TimeUnit.MILLISECONDS.toSeconds(millis) - 
				    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
				);
			session.setAttribute("runningTime", total);
		}else {
			session.setAttribute("runningTime", "");
		}
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = (String)request.getParameter("action");
		HttpSession session = request.getSession();
		LocalTime start = (LocalTime) session.getAttribute("startTime");

		switch (button) {
		case "stop":
			if(start != null) 
				Timer.addLog(new TimerLog(start));
			session.setAttribute("startTime", null);
			break;
		case "start":
			session.setAttribute("startTime", LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
			break;
		case "reset":
			Timer.reset();
			session.setAttribute("startTime", null);
			break;
		default:
			System.out.println("ERROR!");
			break;
		}
		
		doGet(request, response);
	}

}
