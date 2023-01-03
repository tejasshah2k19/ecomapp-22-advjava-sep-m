package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class SignupController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// validate --> required , format , length

		// db store

		UserBean user = new UserBean(); // userId random
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setPassword(password);

		UserDao userDao = new UserDao();
		userDao.addUser(user);
		
		response.sendRedirect("Login.jsp");

	}

}
