package com.ert.schemas.phonebook;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "userId", "contactId", "contactName", "phoneNumber" })
@XmlRootElement(name = "PhoneBook")
public class PhoneBook {

	@XmlElement(name = "UserId", required = true)
	protected String userId;
	@XmlElement(name = "ContactId", required = true)
	protected Integer contactId;
	@XmlElement(name = "ContactName", required = true)
	protected String contactName;
	@XmlElement(name = "PhoneNumber", required = true)
	protected String phoneNumber;

	public PhoneBook() {

	}

	public PhoneBook(String contactName, String phoneNumber) {
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}

	public PhoneBook(Integer contactId, String contactName, String phoneNumber) {
		this.contactId = contactId;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}

	public PhoneBook(String userId, Integer contactId, String contactName, String phoneNumber) {
		this.userId = userId;
		this.contactId = contactId;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String value) {
		this.userId = value;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer value) {
		this.contactId = value;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String value) {
		this.contactName = value;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

}
