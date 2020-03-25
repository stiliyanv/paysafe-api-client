package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.Monitor;

@RestController
public class ServiceMonitorController {
	
	@Value("${paysafe.service.baseurl}")
	private String serviceBaseUrl;
	
	@Value("${paysafe.service.monitor}")
	private String serviceMonitor;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/verifyservice")
	public String getServiceStatus() {
		Monitor monitor = restTemplate.getForObject(serviceBaseUrl.concat(serviceMonitor), Monitor.class);
		return "3DS Service Status: " + monitor.getStatus();
	}
}
