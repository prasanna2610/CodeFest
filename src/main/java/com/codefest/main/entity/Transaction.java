package com.codefest.main.entity;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{

	private static final long serialVersionUID = 37052448607293442L;
	
	private Long transactionId;
	
	private Long userId;
	
	private Date date;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
