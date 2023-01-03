package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDao;

public class RemoveCartServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Integer cartId = Integer.parseInt(request.getParameter("cartId"));
		
		CartDao cartDao = new CartDao();
		cartDao.removeCart(cartId);
		
		response.sendRedirect("MyCartServlet");
		
		
	}

}
