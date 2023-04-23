package com.group2.event_management.repository;

import org.springframework.data.repository.CrudRepository;
import com.group2.event_management.entity.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
	public Event findByEventName(String eventName);
}
