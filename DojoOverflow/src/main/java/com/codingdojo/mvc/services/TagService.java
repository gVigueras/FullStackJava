package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.repositories.TagRepository;

@Service
public class TagService {
	//Agregando el tag al repositorio como una dependencia
	private final TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public List<Tag> allTags() {
		return tagRepository.findAll();
	}
	
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public Tag findTag(Long id) {
		Optional<Tag> optionalTag = tagRepository.findById(id);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	
	public List<Tag> findTagsByQuestion(Question question) {
		return tagRepository.findByQuestionId(question.getId());
	}
	
	public Tag findTagBySubject(String subject) {
		return tagRepository.findBySubject(subject);
	}
	
	public Tag updateTag(Long id, String tagString) {
		Tag tag = new Tag(tagString);
		tag.setId(id);
		return tagRepository.save(tag);
	}
	public Tag updateTag(Tag lang) {
		return tagRepository.save(lang);
	}
	
	public void deleteTag(Long id) {
		tagRepository.deleteById(id);
	}
}
