package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.EnrollmentCheck;
import com.paysafe.client.paysafeapiclient.models.ThreeDEnrollment;
import com.paysafe.client.paysafeapiclient.services.EnrollmentCheckService;

@RestController
public class EnrollmentCheckController {

//	@Value("${paysafe.threedsecure.service.baseurl.production}")
//	using mock server instead of production
	@Value("${paysafe.threedsecure.service.baseurl.mock}")
	private String baseUrlPath;

	@Value("${paysafe.threedsecure.service.accounts}")
	private String accountsPath;

	@Value("${paysafe.threedsecure.service.enrollmentchecks}")
	private String enrollmentChecksPath;
	
	@Value("${test.account.id}")
	private String testAccountId;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EnrollmentCheckService enrollmentCheckService;
	
	private HttpEntity<EnrollmentCheck> request;

	@RequestMapping("/accounts/{id}/enrollmentchecks")
	public String checkCardholderAuthentication(@PathVariable String id) {

		request = new HttpEntity<>(enrollmentCheckService.getEnrollmentCheck());
		EnrollmentCheck enrollmentCheck = restTemplate
				.postForObject(baseUrlPath + accountsPath + id + enrollmentChecksPath, request, EnrollmentCheck.class);

		fillEnrollmentCheckService(enrollmentCheck);
		
		return getCardholderAuthentication(enrollmentCheck);
	}
	
	@RequestMapping("/testaccount/enrollmentchecks")
	public String checkCardholderAuthentication() {

		request = new HttpEntity<>(enrollmentCheckService.getEnrollmentCheck());
		EnrollmentCheck enrollmentCheck = restTemplate
				.postForObject(baseUrlPath + accountsPath + testAccountId + enrollmentChecksPath, request, EnrollmentCheck.class);

		fillEnrollmentCheckService(enrollmentCheck);
		
		return getCardholderAuthentication(enrollmentCheck);
	}

	private String getCardholderAuthentication(EnrollmentCheck enrollmentCheck) {
		if (enrollmentCheck.getThreeDEnrollment() == ThreeDEnrollment.Y) {
			return "Cardholder authentication available.";
		} else if (enrollmentCheck.getThreeDEnrollment() == ThreeDEnrollment.U) {
			return "Cardholder authentication unavailable.";
		} else {
			return "Cardholder not enrolled in authentication.";
		}
	}
	
	private void fillEnrollmentCheckService(EnrollmentCheck enrollmentCheck) {
		enrollmentCheckService.getEnrollmentCheck().setAcsURL(enrollmentCheck.getAcsURL());
		enrollmentCheckService.getEnrollmentCheck().setTxnTime(enrollmentCheck.getTxnTime());
		enrollmentCheckService.getEnrollmentCheck().setStatus(enrollmentCheck.getStatus());
		enrollmentCheckService.getEnrollmentCheck().setThreeDEnrollment(enrollmentCheck.getThreeDEnrollment());
		enrollmentCheckService.getEnrollmentCheck().setId(enrollmentCheck.getId());
		enrollmentCheckService.getEnrollmentCheck().setPaReq(enrollmentCheck.getPaReq());
		enrollmentCheckService.getEnrollmentCheck().setEci(enrollmentCheck.getEci());
	}
}
