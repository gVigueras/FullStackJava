package com.codingdojo.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.mvc.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
    //Este método recupera todos los libros de la base de datos
    List<Song> findAll();
    //Este método encuentra canciones de un artista
    List<Song> findByArtist(String search);
  //Este método encuentra los Top 10 por rating
    List<Song> findTop10ByRatingDesc();
}
