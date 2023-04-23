package com.group2.event_management.service;

import com.group2.event_management.entity.Event;
public interface EventService {
	//C - Create or Insert
	public Event saveEvent(Event event);
	//R - Retrieve or find 
	public Event getEventByLocation(String location);
	public Event getEventById(Integer eventId);
	//U - Update a record
	public Event updateEvent(Event event);
	//D - Delete a record 
	public void deleteEvent(Event event);
	public void deleteEventById(Integer eventId);
}
