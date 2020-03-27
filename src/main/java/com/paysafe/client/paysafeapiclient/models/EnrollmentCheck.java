package com.paysafe.client.paysafeapiclient.models;

public class EnrollmentCheck {
	
	private String merchantRefNum;
	private int amount;
    private String currency;
    private String customerIp;
    private String userAgent;
    private String acceptHeader;
    private String merchantUrl;
    private Card card;
    
    public EnrollmentCheck() {
    	
	}
    
    public EnrollmentCheck(String merchantRefNum, int amount, String currency, String customerIp, String userAgent,
			String acceptHeader, String merchantUrl, Card card) {
		this.merchantRefNum = merchantRefNum;
		this.amount = amount;
		this.currency = currency;
		this.customerIp = customerIp;
		this.userAgent = userAgent;
		this.acceptHeader = acceptHeader;
		this.merchantUrl = merchantUrl;
		this.card = card;
	}
    
	public String getMerchantRefNum() {
		return merchantRefNum;
	}
	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCustomerIp() {
		return customerIp;
	}
	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getAcceptHeader() {
		return acceptHeader;
	}
	public void setAcceptHeader(String acceptHeader) {
		this.acceptHeader = acceptHeader;
	}
	public String getMerchantUrl() {
		return merchantUrl;
	}
	public void setMerchantUrl(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
}
