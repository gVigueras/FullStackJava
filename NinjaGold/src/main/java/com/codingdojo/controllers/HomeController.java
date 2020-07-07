package com.codingdojo.controllers;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null)
			model.addAttribute("gold", 0);
		return "index.jsp";
	}

	@RequestMapping(value="/sendPost", method=RequestMethod.POST)
	public String sendPost(HttpSession session, Model model, @RequestParam(value="place") String place) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "");
		}
		Random rand = new Random();
		Date date = new Date();
		String activities = (String) session.getAttribute("activities");
		int gold = (int) session.getAttribute("gold");
		int goldDifference = 0;

		switch(place) {
		case "cave":
			goldDifference = rand.nextInt(6)+5;
			break;
		case "farm":
			goldDifference = rand.nextInt(11)+10;
			break;
		case "house":
			goldDifference = rand.nextInt(4)+2;
			break;
		case "casino":
			goldDifference = rand.nextInt(101)-50;
			break;
		}

		if(goldDifference >= 0)
			activities = activities.concat("<p style='color: green'> You entered a "+place+" and earned "+goldDifference+" gold. ("+date+")</p>");
		else
			activities = activities.concat("<p style='color: red'> You entered a "+place+" and lost "+goldDifference+" gold... Ouch ("+date+")</p>");

		gold += goldDifference;
		session.setAttribute("gold", gold);
		session.setAttribute("activities", activities);
		model.addAttribute("gold",gold);
		model.addAttribute("activities", activities);

		return "redirect:/";
	}

}
