package com.codingdojo.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    //Este método recupera todos los libros de la base de datos
    List<Language> findAll();
    //Este método encuentra un libro por su descripción
    List<Language> findByNameContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByCreatorContaining(String search);
}
