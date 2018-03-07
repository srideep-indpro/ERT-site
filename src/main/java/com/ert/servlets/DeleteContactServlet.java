package com.ert.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ert.utils.DBUtils;


@WebServlet(urlPatterns = "/deleteContact")
public class DeleteContactServlet extends HttpServlet {

	private static final long serialVersionUID = 2046831602621655230L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer contactId = Integer.parseInt(request.getParameter("contactId"));
		String errorString = null;
		try {
			DBUtils.deleteContact(contactId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}
