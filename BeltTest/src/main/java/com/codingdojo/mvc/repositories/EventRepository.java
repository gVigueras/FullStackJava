package com.codingdojo.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Event;
import com.codingdojo.mvc.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
    List<Event> findAll();
    List<Event> findByRegionContaining(String Region);
}
