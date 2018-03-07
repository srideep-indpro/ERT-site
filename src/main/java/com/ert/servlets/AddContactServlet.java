package com.ert.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ert.schemas.phonebook.PhoneBook;
import com.ert.schemas.registration.Registration;
import com.ert.utils.DBUtils;
import com.ert.utils.MyUtils;

@WebServlet(urlPatterns = "/addContact")
public class AddContactServlet extends HttpServlet{

	private static final long serialVersionUID = 4032174659102570360L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(request, response);
	}

    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Registration loginedUser = MyUtils.getLoginedUser(session);
		
		String contactName = request.getParameter("contactName");
		String phoneNumber = request.getParameter("phoneNumber");
		
		PhoneBook contactDetails = new PhoneBook(contactName,phoneNumber);
		
		try {
			DBUtils.addContact(loginedUser,contactDetails);
			request.setAttribute("successContactAddedMessage", "Contact added Successfully");
			response.sendRedirect(request.getContextPath() + "/userInfo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
