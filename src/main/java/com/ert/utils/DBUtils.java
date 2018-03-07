package com.ert.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ert.schemas.phonebook.PhoneBook;
import com.ert.schemas.registration.Registration;

public class DBUtils {

	public static void registerUser(Registration registration) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		conn = ConnectionUtils.getConnection();
		String sql = "insert into userregistration(UserId,Name,Email,PhoneNumber,Password) values (UUID(),?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, registration.getName());
		pstm.setString(2, registration.getEmail());
		pstm.setString(3, registration.getPhoneNumber());
		pstm.setString(4, registration.getPassword());
		pstm.executeUpdate();

	}

	public static Registration findUser(String userName, String password) throws ClassNotFoundException, SQLException {

		Connection conn = ConnectionUtils.getConnection();
		String sql = "Select a.UserId,a.Name, a.Password,a.Email,a.PhoneNumber from userregistration a " //
				+ " where a.Name = ? and a.Password= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);

		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {

			Registration registeredUser = new Registration();
			registeredUser.setUserId(rs.getString("UserId"));
			registeredUser.setName(userName);
			registeredUser.setPassword(password);
			registeredUser.setEmail(rs.getString("Email"));
			registeredUser.setPhoneNumber((rs.getString("PhoneNumber")));
			return registeredUser;
		}
		conn.close();
		return null;

	}

	public static void addContact(Registration loginedUser, PhoneBook contactDetails) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "insert into phonebook(UserId,ContactName,ContactNo) values (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loginedUser.getUserId());
			pstm.setString(2, contactDetails.getContactName());
			pstm.setString(3, contactDetails.getPhoneNumber());
			pstm.executeUpdate();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<PhoneBook> retrieveContacts(Registration loginedUser)
			throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select p.UserId,p.ContactId,p.contactName,p.contactNo from phonebook p inner join userregistration r "
				      	+ "on r.UserId= p.UserId where r.UserId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,loginedUser.getUserId());
		ResultSet rs = pstm.executeQuery();

		List<PhoneBook> contactList = new ArrayList<>();
		while (rs.next()) {
			PhoneBook phoneBook = new PhoneBook();
			int contactId = rs.getInt("ContactId");
			String contactName = rs.getString("ContactName");
			String contactNo = rs.getString("ContactNo");
			phoneBook.setContactId(contactId);
			phoneBook.setContactName(contactName);
			phoneBook.setPhoneNumber(contactNo);
			contactList.add(phoneBook);

		}
		conn.close();
		return contactList;
	}

	public static PhoneBook findContact(String contactId) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select * from phonebook where ContactId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, contactId);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			PhoneBook singleContact = new PhoneBook();
			singleContact.setContactId(rs.getInt("ContactId"));
			singleContact.setContactName(rs.getString("ContactName"));
			singleContact.setPhoneNumber((rs.getString("ContactNo")));
			return singleContact;
		}
		conn.close();
		return null;

	}

	public static void updateContact(PhoneBook updateRequestedContact) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionUtils.getConnection();
		String sql = "update phonebook set ContactName =?, ContactNo=? where ContactId=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, updateRequestedContact.getContactName());
		pstm.setString(2, updateRequestedContact.getPhoneNumber());
		pstm.setInt(3, updateRequestedContact.getContactId());
		pstm.executeUpdate();
		conn.close();
	}

	public static void deleteContact(Integer contactId) throws ClassNotFoundException, SQLException {

		Connection conn = ConnectionUtils.getConnection();
		String sql = "delete from phonebook where ContactId= ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, contactId);
		pstm.executeUpdate();
		conn.close();
	}
}
