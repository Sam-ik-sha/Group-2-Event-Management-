package com.group2.event_management.repository;
import org.springframework.data.repository.CrudRepository;

import com.group2.event_management.entity.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
	public Registration findByFirstName(String firstName);
}

