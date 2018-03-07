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
import com.ert.testgeo.GeoLocation;
import com.ert.utils.DBUtils;
import com.ert.utils.MyUtils;

@WebServlet(urlPatterns = "/sendSMS")
public class SendSmsServlet extends HttpServlet {

	private static final long serialVersionUID = 2423077858035647753L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Registration loginedUser = MyUtils.getLoginedUser(session);
		GeoLocation userLocation = MyUtils.getUserLocation(session);
		
		List<PhoneBook> contactList;
		try {
			contactList = DBUtils.retrieveContacts(loginedUser);
			for (PhoneBook pb : contactList) {
				String phoneNumber = "91" + pb.getPhoneNumber();
				com.ert.utils.SendSMS.sendSMS(phoneNumber,userLocation);
			}
            request.setAttribute("successSMS", "SMS has been sent to them");
			response.sendRedirect(request.getContextPath() + "/userInfo");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
