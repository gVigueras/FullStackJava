package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.repositories.QuestionRepository;

@Service
public class QuestionService {
	//Agregando el question al repositorio como una dependencia
	private final QuestionRepository questionRepository;

	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public List<Question> allQuestions() {
		return questionRepository.findAll();
	}
	
	public Question createQuestion(Question l) {
		return questionRepository.save(l);
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	public Question updateQuestion(Long id, String questionString) {
		Question question = new Question(questionString);
		question.setId(id);
		return questionRepository.save(question);
	}
	public Question updateQuestion(Question lang) {
		return questionRepository.save(lang);
	}
	
	public void deleteQuestion(Long id) {
		questionRepository.deleteById(id);
	}
}
