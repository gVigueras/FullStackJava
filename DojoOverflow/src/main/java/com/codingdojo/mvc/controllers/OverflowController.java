package com.codingdojo.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.services.AnswerService;
import com.codingdojo.mvc.services.QuestionService;
import com.codingdojo.mvc.services.TagService;

@Controller
public class OverflowController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;

	public OverflowController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}

	@RequestMapping("/questions")
	public String index(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "/views/index.jsp";
	}

	@RequestMapping("/questions/{id}")
	public String index(Model model, @PathVariable("id") Long id) {
		Question question = questionService.findQuestion(id);
		model.addAttribute("question", question);
		return "/views/question.jsp";
	}
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
	public String index(@RequestParam("answer") String answer, @PathVariable("id") Long id) {
		Question question = questionService.findQuestion(id);
		Answer ans = new Answer(answer);
		ans.setQuestion(question);
		answerService.createAnswer(ans);
		//question.getAnswers().add(ans);
		//questionService.updateQuestion(question);
		return "redirect:/questions";
	}

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String create(@RequestParam("question") String pregunta, @RequestParam("tags") String etiquetas, RedirectAttributes errors) {
		Question question = new Question(pregunta);
		List<Tag> tags = new ArrayList<>();
		String tagArray[] = etiquetas.split(",");
		Tag aux;
		if(tagArray.length > 3) {
			System.out.println(tagArray.length);
			errors.addFlashAttribute("errors", "Solo se pueden maximo 3 Etiquetas");
			return "redirect:/new";
		}
		for (String string : tagArray) {

			aux = tagService.findTagBySubject(string);
			if(aux == null)
				aux = new Tag(string);
			tagService.createTag(aux);
			tags.add(aux);
		}
		question.setTags(tags);
		questionService.createQuestion(question);
		return "redirect:/questions";
	}

	@RequestMapping("/new")
	public String newQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		return "/views/new.jsp";
	}
	/*
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
    }*/
}
