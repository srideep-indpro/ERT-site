package com.ert.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(urlPatterns = "/userInfo")
public class UserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 4049016320102030805L;

	public UserInfoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Registration loginedUser = MyUtils.getLoginedUser(session);
		
		
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		request.setAttribute("userName", loginedUser.getName());
		try {
			List<PhoneBook> contactList = DBUtils.retrieveContacts(loginedUser);
			request.setAttribute("contactList", contactList);
			request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
