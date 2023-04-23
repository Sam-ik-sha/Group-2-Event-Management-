package com.group2.event_management.service;
import com.group2.event_management.entity.Registration;
public interface RegistrationService {
		public Registration saveRegistration (Registration registration);
		//R - Retrieve or find 
		public Registration  getRegistrationByFirstName(String firstName);
		public Registration  getRegistrationById(Integer regId);
		//U - Update a record
		public Registration  updateRegistration (Registration  registration );
		//D - Delete a record 
		public void deleteRegistration (Registration  registration );
		public void deleteRegistrationById(Integer regId);
	}
