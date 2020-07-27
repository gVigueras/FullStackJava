package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.repositories.SongRepository;

@Service
public class SongService {
	//Agregando el song al repositorio como una dependencia
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	//Devolviendo todas las canciones.
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	//Devolviendo el top 10 de canciones.
	public List<Song> topSongs() {
		return songRepository.findTop10ByRatingDesc();
	}
	//Creando una canción.
	public Song createSong(Song l) {
		return songRepository.save(l);
	}
	//Obteniendo la información de una canción
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	//Actualiza la canción dada
	public Song updateSong(Long id, String title, String artist, int rating) {
		Song song = new Song(title, artist, rating);
		song.setId(id);
		return songRepository.save(song);
	}
	public Song updateSong(Song lang) {
		return songRepository.save(lang);
	}
	//Eliminando un libro
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
}
