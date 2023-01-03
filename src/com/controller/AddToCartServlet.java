package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartBean;
import com.dao.CartDao;

public class AddToCartServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer productId = Integer.parseInt(request.getParameter("productId"));//12 
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");//22

		CartBean cart = new CartBean();
		cart.setProductId(productId);
		cart.setUserId(userId);
		cart.setQty(1);

		CartDao cartDao = new CartDao();
		cartDao.addCart(cart);
		System.out.println("cartsize => "+cartDao.getAllCarts().size());
		response.sendRedirect("MyCartServlet");
	}

}
