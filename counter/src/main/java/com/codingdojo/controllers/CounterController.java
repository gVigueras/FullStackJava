package com.codingdojo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("counter") != null)
			session.setAttribute("counter", ((int)session.getAttribute("counter"))+1);
		else
			session.setAttribute("counter", 1);
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		model.addAttribute("counter", (int)session.getAttribute("counter"));
		return "counter.jsp";
	}

	@RequestMapping("/double")
	public String twice(HttpSession session) {
		if(session.getAttribute("counter") != null)
			session.setAttribute("counter", ((int)session.getAttribute("counter"))+2);
		else
			session.setAttribute("counter", 2);
		return "index.jsp";
	}

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		if(session.getAttribute("counter") != null)
			session.setAttribute("counter",0);
		return "counter.jsp";
	}

}
