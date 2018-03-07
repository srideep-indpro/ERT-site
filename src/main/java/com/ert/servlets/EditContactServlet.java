package com.ert.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ert.schemas.phonebook.PhoneBook;
import com.ert.utils.DBUtils;

@WebServlet(urlPatterns = "/editContact")
public class EditContactServlet extends HttpServlet {

	private static final long serialVersionUID = -1555293842768021110L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contactId = request.getParameter("contactId");
		PhoneBook singleContact = null;
		String errorString = null;

		try {
			singleContact = DBUtils.findContact(contactId);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && singleContact == null) {
			response.sendRedirect(request.getServletPath() + "/userInfo");
			return;
		}
		request.setAttribute("singleContactDetails", singleContact);
		request.getRequestDispatcher("/WEB-INF/views/editContactView.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contactId =  request.getParameter("contactId");
		String contactName = request.getParameter("contactName");
		String phoneNumber = request.getParameter("phoneNumber");
		PhoneBook updateRequestedContact = new PhoneBook(Integer.parseInt(contactId), contactName, phoneNumber);
		String errorString = null;

		try {
			DBUtils.updateContact(updateRequestedContact);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("updateRequestedContact", updateRequestedContact);
		if (errorString != null) {
			request.getRequestDispatcher("/WEB-INF/views/editContacttView.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}
