package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Language;
import com.codingdojo.mvc.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> langs = languageService.allLanguages();
		model.addAttribute("languages", langs);
		return "/views/index.jsp";
	}

	@RequestMapping("/languages/{id}")
	public String index(Model model, @PathVariable("id") String id) {
		Language language = languageService.findLanguage(Long.parseLong(id));
		model.addAttribute("language", language);
		return "/views/show.jsp";
	}

	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/view/new.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }

    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language book = languageService.findLanguage(id);
        model.addAttribute("book", book);
        return "/views/edit.jsp";
    }

    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/views/edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
}
