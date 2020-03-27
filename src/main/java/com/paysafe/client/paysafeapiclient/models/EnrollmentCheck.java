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
	private String acsURL;
	private String txnTime;
	private Status status;
	private ThreeDEnrollment threeDEnrollment;
	private String id;
	private String paReq;
	private int eci;

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

	public String getAcsURL() {
		return acsURL;
	}

	public void setAcsURL(String acsURL) {
		this.acsURL = acsURL;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ThreeDEnrollment getThreeDEnrollment() {
		return threeDEnrollment;
	}

	public void setThreeDEnrollment(ThreeDEnrollment threeDEnrollment) {
		this.threeDEnrollment = threeDEnrollment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaReq() {
		return paReq;
	}

	public void setPaReq(String paReq) {
		this.paReq = paReq;
	}

	public int getEci() {
		return eci;
	}

	public void setEci(int eci) {
		this.eci = eci;
	}
}