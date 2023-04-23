package com.group2.event_management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.group2.event_management.entity.Registration;
import com.group2.event_management.exception.ResourceNotFoundException;
import com.group2.event_management.repository.RegistrationRepository;


@RestController
public class RegistrationController {	
	@Autowired
	private RegistrationRepository registrationRepository;

	@GetMapping("/registrations")
	public List<Registration> getAllregistration() {
		return (List<Registration>) registrationRepository.findAll();
	}

	@GetMapping("/registrations/{id}")
	public ResponseEntity<Registration> getRegistrationById(@PathVariable(value = "id") Integer regId)
			throws ResourceNotFoundException {
		Registration registration = registrationRepository.findById(regId)
				.orElseThrow(() -> new ResourceNotFoundException("Registrationnot found for this id :: " + regId));
		return ResponseEntity.ok().body(registration);
	}

	@PostMapping("/registrations")
	public Registration createRegistration(@Validated @RequestBody Registration registration) {
		return registrationRepository.save(registration);
	}

	@PutMapping("/registrations/{id}")
	public ResponseEntity<Registration> updateRegistration(@PathVariable(value = "id") Integer regId,
			@Validated @RequestBody Registration registrationDetails) throws ResourceNotFoundException {
		Registration registration= registrationRepository.findById(regId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration not found for this id :: " +regId));

		registration.setFirstName(registrationDetails.getFirstName());
		registration.setLastName(registrationDetails.getLastName());
		registration.setOrgName(registrationDetails.getOrgName());
		registration.setDesignation(registrationDetails.getDesignation());
		final Registration updatedRegistration= registrationRepository.save(registration);
		return ResponseEntity.ok(updatedRegistration); 
	}

	@DeleteMapping("/registrations/{id}")
	public Map<String, Boolean> deleteRegistration(@PathVariable(value = "id") Integer regId)
			throws ResourceNotFoundException {
		Registration registration = registrationRepository.findById(regId)
				.orElseThrow(() -> new ResourceNotFoundException("Registrationnot found for this id :: " + regId));

		registrationRepository.delete(registration);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
//			@Autowired
//			private RegistrationService registrationService;
//		
//			//C - Create or Insert
//			//http://localhost:8080/saveemployee
//			// In request body employee object will send in JSON - Java Script Object Notation
//			@PostMapping("/saveregistration")
//			public Registration saveRegistration(@RequestBody Registration registration) {
//				Registration reg = registrationService.saveRegistration(registration);
//				return reg;	
//			}
//			
//			//R - Retrieve or find 
//			//Below url we are passing data as query string so in java method you have to use @RequestParam
//			
//			//http://localhost:8080/getRegistrationByIdUsingRequestParam?eventId=1
//			@GetMapping("/getRegistrationByIdUsingRequestParam")
//			//public Event getRegistrationByIdUsingRequestParam(@RequestParam("eventId") Integer eventId, @RequestParam("name") String eventName){
//			public Registration getRegistrationByIdUsingRequestParam(@RequestParam("regId") Integer regId) {
//				return registrationService.getRegistrationById(regId);
//			}
//			
//			//Below url we passing data in Path Variable
//			//http://localhost:8080/getevent/1
//			@GetMapping("/getregistration/{regId}")
//			public Registration getRegistrationById(@PathVariable("regId") Integer regId){
//				return registrationService.getRegistrationById(regId);
//			}
//			//U - Update a record
//			//http://localhost:8080/updateevent
//			@PutMapping("/updateregistration")
//			public Registration updateRegistration(@RequestBody Registration registration){
//				return registrationService.updateRegistration(registration);
//			}
//			//D - Delete a record 
//			//http://localhost:8080/deleteevent/1
//			@GetMapping("/deleteregistration/{regId}")
//			public void deleteRegistrationById(@PathVariable("regId") Integer registrationId){
//				registrationService.deleteRegistrationById(registrationId);
//			}


