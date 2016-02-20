package com.codefest.main.entity;

import java.io.Serializable;

public class CFUser implements Serializable{

	private static final long serialVersionUID = -2331273175855336080L;
	
	private Long userId;
	
	private String password;
	
	private String email;
	
	private Long phone;
	
	private String firstName;
	
	private String lastName;
	
	private String userTyp;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserTyp() {
		return userTyp;
	}

	public void setUserTyp(String userTyp) {
		this.userTyp = userTyp;
	}
	

}
