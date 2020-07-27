package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;

	public SongsController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/songs")
	public String index(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/views/index.jsp";
	}

	@RequestMapping("/songs/{id}")
	public String index(Model model, @PathVariable("id") String id) {
		Song song = songService.findSong(Long.parseLong(id));
		model.addAttribute("song", song);
		return "/views/show.jsp";
	}

	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/view/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/songs";
		}
	}
	
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/songs";
    }

    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/views/edit.jsp";
    }

    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/views/edit.jsp";
        } else {
        	songService.updateSong(song);
            return "redirect:/songs";
        }
    }
}
