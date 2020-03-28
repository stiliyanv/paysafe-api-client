package com.paysafe.client.paysafeapiclient.models;

public class Authentication {

	private String merchantRefNum;
	private ThreeDResult threeDResult;
	private String txnTime;
	private String cavv;
	private SignatureStatus signatureStatus;
	private Status status;
	private String xid;
	private int eci;
	private String id;

	public Authentication() {

	}

	public Authentication(String merchantRefNum, ThreeDResult threeDResult, String txnTime, String cavv,
			SignatureStatus signatureStatus, Status status, String xid, int eci, String id) {
		this.merchantRefNum = merchantRefNum;
		this.threeDResult = threeDResult;
		this.txnTime = txnTime;
		this.cavv = cavv;
		this.signatureStatus = signatureStatus;
		this.status = status;
		this.xid = xid;
		this.eci = eci;
		this.id = id;
	}

	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}

	public ThreeDResult getThreeDResult() {
		return threeDResult;
	}

	public void setThreeDResult(ThreeDResult threeDResult) {
		this.threeDResult = threeDResult;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getCavv() {
		return cavv;
	}

	public void setCavv(String cavv) {
		this.cavv = cavv;
	}

	public SignatureStatus getSignatureStatus() {
		return signatureStatus;
	}

	public void setSignatureStatus(SignatureStatus signatureStatus) {
		this.signatureStatus = signatureStatus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public int getEci() {
		return eci;
	}

	public void setEci(int eci) {
		this.eci = eci;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}