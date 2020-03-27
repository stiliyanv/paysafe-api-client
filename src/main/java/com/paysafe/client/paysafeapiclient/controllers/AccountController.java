package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Value("${test.account.id}")
	private String testAccountId;
	
	@Value("${test.user.api.key}")
	private String testUserApiKey;
}