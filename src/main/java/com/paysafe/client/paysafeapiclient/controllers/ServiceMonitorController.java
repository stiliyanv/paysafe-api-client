package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.Monitor;

@RestController
public class ServiceMonitorController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/verifyservice")
	public String getServiceStatus() {
		Monitor monitor = restTemplate.getForObject("https://api.test.paysafe.com/threedsecure/monitor", Monitor.class);
		return "3DS Service Status: " + monitor.getStatus();
	}
}
