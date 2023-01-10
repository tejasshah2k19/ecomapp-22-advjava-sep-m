package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.OrderBean;
import com.dao.OrderDao;

public class OrderServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");// 22

		OrderDao orderDao = new OrderDao();
		ArrayList<OrderBean> orders =  orderDao.getOrderByUserId(userId);
	
		request.setAttribute("orders", orders);
		
		request.getRequestDispatcher("MyOrders.jsp").forward(request, response);
	}

}
