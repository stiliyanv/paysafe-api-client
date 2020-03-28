package com.paysafe.client.paysafeapiclient.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.Authentication;
import com.paysafe.client.paysafeapiclient.models.EnrollmentCheck;
import com.paysafe.client.paysafeapiclient.models.ThreeDEnrollment;
import com.paysafe.client.paysafeapiclient.models.ThreeDResult;
import com.paysafe.client.paysafeapiclient.services.EnrollmentCheckService;

@RestController
public class EnrollmentCheckController {

	@Value("${paysafe.threedsecure.service.baseurl.mock}")
	private String baseUrlPath;

	@Value("${paysafe.threedsecure.service.accounts}")
	private String accountsPath;

	@Value("${paysafe.threedsecure.service.enrollmentchecks}")
	private String enrollmentChecksPath;

	@Value("${paysafe.threedsecure.service.authentications}")
	private String authenticationsPath;

	@Value("${test.account.id}")
	private String testAccountId;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EnrollmentCheckService enrollmentCheckService;
	
	private HttpEntity<EnrollmentCheck> enrollmentCheckRequest;
	private HttpEntity<Map<String, String>> authRequest;

	@RequestMapping("/testaccount/enrollmentchecks")
	public String checkCardholderAuthentication() {

		String url = baseUrlPath + accountsPath + testAccountId + enrollmentChecksPath;
		enrollmentCheckRequest = new HttpEntity<>(enrollmentCheckService.getEnrollmentCheck());
		EnrollmentCheck enrollmentCheck = restTemplate.postForObject(url, enrollmentCheckRequest, EnrollmentCheck.class);

		fillEnrollmentCheckService(enrollmentCheck);

		return getCardholderAuthentication(enrollmentCheckService.getEnrollmentCheck());
	}

	@RequestMapping("/accounts/{id}/enrollmentchecks")
	public String checkCardholderAuthentication(@PathVariable String id) {

		String url = baseUrlPath + accountsPath + id + enrollmentChecksPath;
		enrollmentCheckRequest = new HttpEntity<>(enrollmentCheckService.getEnrollmentCheck());
		EnrollmentCheck enrollmentCheck = restTemplate.postForObject(url, enrollmentCheckRequest, EnrollmentCheck.class);

		fillEnrollmentCheckService(enrollmentCheck);

		return getCardholderAuthentication(enrollmentCheckService.getEnrollmentCheck());
	}
	
	@RequestMapping("/testaccount/enrollmentchecks/authentications")
	public String getAuthenticationResult() {

		String url = baseUrlPath + accountsPath + testAccountId + enrollmentChecksPath + "/"
				+ enrollmentCheckService.getEnrollmentCheck().getId() + authenticationsPath;
		
		// request body parameters
		Map<String, String> map = new HashMap<>();
		map.put("merchantRefNum", enrollmentCheckService.getEnrollmentCheck().getMerchantRefNum());
		map.put("paRes", enrollmentCheckService.getEnrollmentCheck().getPaReq());
		
		authRequest = new HttpEntity<>(map);
		Authentication authentication = restTemplate.postForObject(url, authRequest, Authentication.class);
		
		if (authentication.getThreeDResult() == ThreeDResult.Y) {
			return "The cardholder successfully authenticated with their card issuer.";
		} else if (authentication.getThreeDResult() == ThreeDResult.A) {
			return "The cardholder authentication was attempted.";
		} else if (authentication.getThreeDResult() == ThreeDResult.N) {
			return "The cardholder failed to successfully authenticate with their card issuer.";
		} else if (authentication.getThreeDResult() == ThreeDResult.U) {
			return "Authentication with the card issuer was unavailable.";
		} else {
			return "An error occurred during authentication.";
		}
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
