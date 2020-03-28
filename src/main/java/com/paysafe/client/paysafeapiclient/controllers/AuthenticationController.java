package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.paysafe.client.paysafeapiclient.services.EnrollmentCheckService;

@RestController
public class AuthenticationController {

	@Autowired
	private EnrollmentCheckService enrollmentCheckService;
}
