package com.codingdojo.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
    //Este método recupera todas las preguntas de la base de datos
    List<Tag> findAll();
    //Recupera todos los tags pertenecientes a una pregunta
    List<Tag> findByQuestionId(Long questionId);
    //Recupera Tag por nombre
    Tag findBySubject(String subject);
}
