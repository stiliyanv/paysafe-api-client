package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.Authentication;
import com.paysafe.client.paysafeapiclient.services.AuthenticationService;

@RestController
public class AuthenticationController {

	@Value("${paysafe.threedsecure.service.baseurl.mock}")
	private String baseUrlPath;

	@Value("${paysafe.threedsecure.service.accounts}")
	private String accountsPath;

	@Value("${test.account.id}")
	private String testAccountId;

	@Value("${paysafe.threedsecure.service.authentications}")
	private String authenticationsPath;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping("/testaccount/authentication")
	public String getAuthentication() {
		String authId = authenticationService.getAuthentication().getId();
		String url = baseUrlPath + accountsPath + testAccountId + authenticationsPath + "/" + authId;

		Authentication authentication = restTemplate.getForObject(url, Authentication.class);
		return "Successfully retrieved authentication with id: " + authentication.getId();
	}
}
