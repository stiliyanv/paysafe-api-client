package com.paysafe.client.paysafeapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.client.paysafeapiclient.models.Card;
import com.paysafe.client.paysafeapiclient.models.CardExpiry;
import com.paysafe.client.paysafeapiclient.models.EnrollmentCheck;
import com.paysafe.client.paysafeapiclient.models.ThreeDEnrollment;

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

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/accounts/{id}/enrollmentchecks")
	public String getThreeDEnrollmentStatus(@PathVariable String id) {

		// mock EnrollmentCheck for the POST request body
		CardExpiry cardExpiryMock = new CardExpiry(10, 2020);
		Card cardMock = new Card("4111111111111111", cardExpiryMock);
		EnrollmentCheck enrollmentCheckMock = new EnrollmentCheck("merchantABC-123-enrollmentchecks", 5000, "USD",
				"172.0.0.1",
				"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
				"https://www.merchant.com", cardMock);

		HttpEntity<EnrollmentCheck> request = new HttpEntity<>(enrollmentCheckMock);

		// call to /threedsecure/v1/accounts/{account_id}/enrollmentchecks with the
		// mocked EnrollmentCheck
		EnrollmentCheck enrollmentCheck = restTemplate
				.postForObject(baseUrlPath + accountsPath + id + enrollmentChecksPath, request, EnrollmentCheck.class);

		// check and return the threedenrollment status
		if (enrollmentCheck.getThreeDEnrollment() == ThreeDEnrollment.Y) {
			return "Cardholder authentication available.";
		} else if (enrollmentCheck.getThreeDEnrollment() == ThreeDEnrollment.U) {
			return "Cardholder authentication unavailable.";
		} else {
			return "Cardholder not enrolled in authentication.";
		}
	}
}
