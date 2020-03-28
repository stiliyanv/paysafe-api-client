package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.services.EnrollmentCheckService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EnrollmentCheckService enrollmentCheckService;
	
	@RequestMapping("/accounts/{id}/enrollmentchecks/e067d83f-add7-4b6b-8884-dfa8693dde1f/authentications")
	public String getThreeDResult(@PathVariable String id) {
		
		return "todo";
	}
}
