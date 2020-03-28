package com.paysafe.client.paysafeapiclient.services;

import org.springframework.stereotype.Service;

import com.paysafe.client.paysafeapiclient.models.Card;
import com.paysafe.client.paysafeapiclient.models.CardExpiry;
import com.paysafe.client.paysafeapiclient.models.EnrollmentCheck;

@Service
public class EnrollmentCheckService {

	private CardExpiry cardExpiryMock = new CardExpiry(10, 2020);
	private Card cardMock = new Card("4111111111111111", cardExpiryMock);
	private EnrollmentCheck enrollmentCheckMock = new EnrollmentCheck("merchantABC-123-enrollmentchecks", 5000, "USD",
			"172.0.0.1",
			"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36",
			"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8", "https://www.merchant.com",
			cardMock);

	public EnrollmentCheck getEnrollmentCheck() {
		return enrollmentCheckMock;
	}
}