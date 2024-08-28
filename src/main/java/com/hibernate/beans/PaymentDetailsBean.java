package com.hibernate.beans;

public class PaymentDetailsBean {

	private int paymentId;

	private String payername;
	private String payerBankName;
	private String payerAddress;

	private String benename;
	private String beneBankName;
	private String beneAddress;

	private float amount;
	private String currency;
	
	private int version;
	
	
	//getter and setter methods
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPayername() {
		return payername;
	}
	public void setPayername(String payername) {
		this.payername = payername;
	}
	public String getPayerBankName() {
		return payerBankName;
	}
	public void setPayerBankName(String payerBankName) {
		this.payerBankName = payerBankName;
	}
	public String getPayerAddress() {
		return payerAddress;
	}
	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}
	public String getBenename() {
		return benename;
	}
	public void setBenename(String benename) {
		this.benename = benename;
	}
	public String getBeneBankName() {
		return beneBankName;
	}
	public void setBeneBankName(String beneBankName) {
		this.beneBankName = beneBankName;
	}
	public String getBeneAddress() {
		return beneAddress;
	}
	public void setBeneAddress(String beneAddress) {
		this.beneAddress = beneAddress;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "PaymentDetailsBean [paymentId=" + paymentId + ", payername=" + payername + ", payerBankName="
				+ payerBankName + ", payerAddress=" + payerAddress + ", benename=" + benename + ", beneBankName="
				+ beneBankName + ", beneAddress=" + beneAddress + ", amount=" + amount + ", currency=" + currency + "]";
	}
	
	

}
