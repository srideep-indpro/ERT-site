package com.ert.schemas.registration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "userId", "name", "email", "phoneNumber", "password" })
@XmlRootElement(name = "Registration")
public class Registration {

	@XmlElement(name = "UserId", required = true)
	protected String userId;
	@XmlElement(name = "Name", required = true)
	protected String name;
	@XmlElement(name = "Email", required = true)
	protected String email;
	@XmlElement(name = "PhoneNumber", required = true)
	protected String phoneNumber;
	@XmlElement(name = "Password", required = true)
	protected String password;

	public Registration() {

	}

	public Registration(String name, String email, String phoneNumber, String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public Registration(String userId, String name, String email, String phoneNumber, String password) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String value) {
		this.userId = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

}
