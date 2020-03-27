package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.Monitor;

@RestController
public class MonitorController {
	
//	@Value("${paysafe.threedsecure.service.baseurl.production}")
//	using mock server instead of production
	@Value("${paysafe.threedsecure.service.baseurl.mock}")
	private String baseUrlPath;
	
	@Value("${paysafe.threedsecure.service.monitor}")
	private String monitorPath;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/servicestatus")
	public String getServiceStatus() {
		Monitor monitor = restTemplate.getForObject(baseUrlPath + monitorPath, Monitor.class);
		
		return "3DS Service Status: " + monitor.getStatus();
	}
}