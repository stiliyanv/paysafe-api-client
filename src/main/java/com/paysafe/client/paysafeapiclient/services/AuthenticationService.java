package com.paysafe.client.paysafeapiclient.services;

import org.springframework.stereotype.Service;

import com.paysafe.client.paysafeapiclient.models.Authentication;
import com.paysafe.client.paysafeapiclient.models.SignatureStatus;
import com.paysafe.client.paysafeapiclient.models.Status;
import com.paysafe.client.paysafeapiclient.models.ThreeDResult;

@Service
public class AuthenticationService {

	private Authentication authentication = new Authentication("merchantABC-123-authentications", ThreeDResult.Y,
			"2016-04-09T17:59:55Z", "AAABBhkXYgAAAAACBxdiENhf7A+=", SignatureStatus.Y, Status.COMPLETED,
			"aWg4N1ZZOE53TkFrazJuMmkyRDA=", 5, "5d4db3bc-34c9-417f-a051-0d992ad9284e");

	public Authentication getAuthentication() {
		return authentication;
	}
}
