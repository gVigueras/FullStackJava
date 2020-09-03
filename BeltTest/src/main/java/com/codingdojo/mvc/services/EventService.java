package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Event;
import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepo;

	public EventService (EventRepository a) {
		this.eventRepo = a;
	}

	public Event createEvent(Event a) {
		return eventRepo.save(a);
	}

	public Event findEvent (Long id) {
		Optional<Event> user = eventRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public List<Event> allEvents(){
		return eventRepo.findAll();
	}

	public List<Event> allEventsInRegion(String region){
		return eventRepo.findByRegionContaining(region);
	}

	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}

	public Event joinEvent(Event b) {
		Optional<Event> user = eventRepo.findById(b.getId());
		if(user.isPresent()) {
			user.get().setGuests(b.getGuests());
			return eventRepo.save(user.get());
		} else {
			return null;
		}   
	}
	public Event updateEvent(Long id, Event b) {
		Optional<Event> user = eventRepo.findById(id);
		if(user.isPresent()) {
			user.get().setName(b.getName());
			user.get().setDate(b.getDate());
			user.get().setCity(b.getCity());
			user.get().setRegion(b.getRegion());
			return eventRepo.save(user.get());
		} else {
			return null;
		}   
	}
}