package com.hibernate.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_status")
public class PaymentStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "payment_reference", updatable = false, nullable = false)
	 @GeneratedValue(generator = "payment_sequence")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int txReference;

	@Column(name = "payment_id", updatable = false, nullable = false)
	private int paymentId;

	@Column(name = "payment_status")
	private String paymentStatus;

	public int getTxReference() {
		return txReference;
	}

	public void setTxReference(int txReference) {
		this.txReference = txReference;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
