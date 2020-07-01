package com.codingdojo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoController {
	@RequestMapping("/{track}")
	public String showDojo(@PathVariable("track") String dojo){

		switch (dojo) {
		case "dojo":
			return "El Dojo es increíble";
		case "burbank-dojo":
			return "El Dojo Burbank está localizado al sur de California";
		case "san-jose":
			return "El Dojo SJ es el cuartel general";
		default:
			return "Mapping not found!";
		}

	}
}