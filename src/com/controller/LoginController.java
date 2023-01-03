package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class LoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println("logincontroller ");
		System.out.println(email);
		System.out.println(password);
		
		
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email, password);

		RequestDispatcher rd = null;
		if (user == null) {
			request.setAttribute("error", "Invalid Credentials");
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			
			
			rd = request.getRequestDispatcher("Home.jsp");
		}
		rd.forward(request, response);
	}

}
