package com.codefest.main.entity;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{

	private static final long serialVersionUID = 37052448607293442L;
	
	private Long transactionId;
	
	private Long userId;
	
	private Date date;
	
	private Long vendorId;
	
	private String menuName;
	
	private Long Price;

	public Long getPrice() {
		return Price;
	}

	public void setPrice(Long price) {
		Price = price;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

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
	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
