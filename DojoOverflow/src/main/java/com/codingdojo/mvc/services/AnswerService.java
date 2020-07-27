package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.repositories.AnswerRepository;

@Service
public class AnswerService {
	//Agregando el answer al repositorio como una dependencia
	private final AnswerRepository answerRepository;

	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public List<Answer> allAnswers() {
		return answerRepository.findAll();
	}
	
	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public Answer findAnswer(Long id) {
		Optional<Answer> optionalAnswer = answerRepository.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
	
	public Answer updateAnswer(Long id, String answerString) {
		Answer answer = new Answer(answerString);
		answer.setId(id);
		return answerRepository.save(answer);
	}
	public Answer updateAnswer(Answer lang) {
		return answerRepository.save(lang);
	}
	
	public void deleteAnswer(Long id) {
		answerRepository.deleteById(id);
	}
}
