package com.codefest.main.entity;

import java.io.Serializable;

public class OrderItems implements Serializable{

	private static final long serialVersionUID = 4900880706435123523L;
	
	private Long transactionId;
	
	private Long menuId;
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	private Long quantity;

}
