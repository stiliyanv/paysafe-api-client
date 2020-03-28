package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.services.EnrollmentCheckService;

@RestController
public class AuthenticationController {
	
	@Value("${test.account.id}")
	private String testAccountId;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EnrollmentCheckService enrollmentCheckService;
		
	// TODO
	@RequestMapping("")
	public void todo() {
		
	}
}
