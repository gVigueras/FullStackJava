package com.codingdojo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.mvc.models.License;
import com.codingdojo.mvc.models.Person;
import com.codingdojo.mvc.services.LicenseService;
import com.codingdojo.mvc.services.UserService;

@Controller
public class LicenseController {
	private final UserService userService;
	private final LicenseService licenseService;

	public LicenseController(LicenseService licenseService, UserService userService) {
		this.userService = userService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/persons/new")
	public String newPerson(Model model, @Valid @ModelAttribute("user") Person user) {
		return "/views/newUser.jsp";
	}

	@RequestMapping("/licenses/new")
	public String newLicense(Model model,  @Valid @ModelAttribute("license") License license) {
		return "/views/newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String newLicense(@RequestParam("answer") String answer, Model model, @Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("error", "Valores ingresados no son válidos");
			return "/views/newLicense.jsp";
		}
		licenseService.saveLicense(license);
		return "redirect:/licenses/new";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String index(@RequestParam("answer") String answer, Model model, @Valid @ModelAttribute("user") Person user, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("error", "Valores ingresados no son válidos");
			return "/views/newUser.jsp";
		}
		userService.create(user);
		return "redirect:/persons/new";
	}

}
