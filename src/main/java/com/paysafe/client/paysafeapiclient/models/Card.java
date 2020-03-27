package com.paysafe.client.paysafeapiclient.models;

public class Card {

	private String cardNum;
	private CardExpiry cardExpiry;
	
	public Card() {

	}

	public Card(String cardNum, CardExpiry cardExpiry) {
		this.cardNum = cardNum;
		this.cardExpiry = cardExpiry;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public CardExpiry getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(CardExpiry cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
}
