package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartBean;
import com.dao.CartDao;

public class MyCartServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		CartDao cartDao = new CartDao();

		ArrayList<CartBean> myCart = cartDao.getMyCart(userId);
		System.out.println(myCart.size());

		request.setAttribute("myCart", myCart);
		request.getRequestDispatcher("MyCart.jsp").forward(request, response);
	}

}
