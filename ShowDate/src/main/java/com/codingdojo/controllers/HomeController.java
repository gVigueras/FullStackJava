package com.codingdojo.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		model.addAttribute("date", date.toString());
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		model.addAttribute("time", date.getHours()+":"+date.getMinutes());
		return "time.jsp";
	}
}
