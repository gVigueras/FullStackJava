package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Language;
import com.codingdojo.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {
	//Agregando el language al repositorio como una dependencia
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	//Devolviendo todos los libros.
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	//Creando un libro.
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	//Obteniendo la información de un libro
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	//Actualiza el libro dado
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Language lang = new Language(name, creator, version);
		lang.setId(id);
		return languageRepository.save(lang);
	}
	public Language updateLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	//Eliminando un libro
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
