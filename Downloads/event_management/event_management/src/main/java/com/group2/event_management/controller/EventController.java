package com.group2.event_management.controller;

import java.util.*;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.group2.event_management.entity.Event;
import com.group2.event_management.exception.ResourceNotFoundException;
import com.group2.event_management.repository.EventRepository;

@RestController
@RequestMapping("/api/v1/")
public class EventController {	
	@Autowired
	private EventRepository eventRepository;

	@GetMapping("/events")
	public List<Event> getAllEvents() {
		return (List<Event>) eventRepository.findAll();
	}

	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Integer eventId)
			throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		return ResponseEntity.ok().body(event);
	}

	@PostMapping("/events")
	public Event createEvent(@Validated @RequestBody Event event) {
		return eventRepository.save(event);
	}

	@PutMapping("/events/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Integer eventId,
			@Validated @RequestBody Event eventDetails) throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		event.setEventName(eventDetails.getEventName());
		event.setLocation(eventDetails.getLocation());
		event.setStartDate(eventDetails.getStartDate());
		event.setEndDate(eventDetails.getEndDate());
		final Event updatedEvent= eventRepository.save(event);
		return ResponseEntity.ok(updatedEvent); 
	}

	@DeleteMapping("/events/{id}")
	public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Integer eventId)
			throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		eventRepository.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
//			@Autowired
//			private EventService eventService;
//			//C - Create or Insert
//			//http://localhost:8080/saveevent
//			// In request body employee object will send in JSON - Java Script Object Notation
//			@PostMapping("/saveevent")
//			public Event saveEvent(@RequestBody Event event) {
//				Event ev = eventService.saveEvent(event);
//				return ev;	
//			}
//			
//			//R - Retrieve or find 
////			//Below url we are passing data as query string so in java method you have to use @RequestParam
////			@GetMapping()
////			public List<Event> getAllEvents(){
////				return (List<Event>) eventRepository.findAll();
////			}
//			//http://localhost:8080/getEventByIdUsingRequestParam?eventId=1
//			@GetMapping("/getEventByIdUsingRequestParam")
//			//public Event getEventByIdUsingRequestParam(@RequestParam("eventId") Integer eventId, @RequestParam("name") String eventName){
//			public Event getEventByIdUsingRequestParam(@RequestParam("eventId") Integer eventId) {
//				return eventService.getEventById(eventId);
//			}
//			
//			//Below url we passing data in Path Variable
//			//http://localhost:8080/getevent/1
//			@GetMapping("/getevent/{eventId}")
//			public Event getEventById(@PathVariable("eventId") Integer eventId){
//				return eventService.getEventById(eventId);
//			}
//			//U - Update a record
//			//http://localhost:8080/updateevent
//			@PutMapping("/updateevent")
//			public Event updateEvent(@RequestBody Event event){
//				return eventService.updateEvent(event);
//			}
//			//D - Delete a record 
//			//http://localhost:8080/deleteevent/1
//			@GetMapping("/deleteevent/{eventId}")
//			public void deleteEventById(@PathVariable("eventId") Integer eventId){
//				eventService.deleteEventById(eventId);
//			}
//}
