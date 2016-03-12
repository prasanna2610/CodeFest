package com.codefest.main.entity;

import java.io.Serializable;
import java.util.List;

public class Vendor implements Serializable{

	private static final long serialVersionUID = 3427775079243423359L;
	
	private Long vendorId;
	
	private String vendorName;
	
	private String password;
	
	private List<Transaction> transaction;
	
	private String vendorEmail;
	
	private Long vendorPhone;
	
	private String incharge;
	
	private String vendorDetail;
	
	private List<Menu> menu;
	
	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public Long getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(Long vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getIncharge() {
		return incharge;
	}

	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}

	public String getVendorDetail() {
		return vendorDetail;
	}

	public void setVendorDetail(String vendorDetail) {
		this.vendorDetail = vendorDetail;
	}
	
	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

}
