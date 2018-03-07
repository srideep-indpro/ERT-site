package com.ert.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ert.schemas.registration.Registration;
import com.ert.testgeo.GeoLocation;
import com.ert.testgeo.LookUpProgram;
import com.ert.utils.DBUtils;
import com.ert.utils.FindIP;
import com.ert.utils.MyUtils;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7290005180615463899L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		Registration registeredUser = null;
		boolean hasError = false;
		String errorString = null;

		if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			try {
				registeredUser = DBUtils.findUser(userName, password);

				if (registeredUser == null) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
			if (hasError) {
				request.setAttribute("LoginErrorString", errorString);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
				
			} else {
				String publicIP = FindIP.getPublicIP();
				GeoLocation ipLocation = LookUpProgram.getIpLocation(publicIP);

				HttpSession session = request.getSession();
				MyUtils.storeLoginedUser(session, registeredUser);
				MyUtils.storeUserLocation(session, ipLocation);

				response.sendRedirect(request.getContextPath() + "/userInfo");
			}
		}

	}
}
