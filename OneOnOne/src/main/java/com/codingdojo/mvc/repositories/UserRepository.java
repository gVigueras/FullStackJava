package com.codingdojo.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Person;

@Repository
public interface UserRepository extends CrudRepository<Person, Long>{
    //Este método recupera todas las preguntas de la base de datos
    List<Person> findAll();
}
