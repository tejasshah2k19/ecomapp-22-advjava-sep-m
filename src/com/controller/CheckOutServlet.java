package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartBean;
import com.bean.OrderBean;
import com.bean.OrderDetailBean;
import com.dao.CartDao;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.dao.ProductDao;

public class CheckOutServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");// 22

		CartDao cartDao = new CartDao();
		ArrayList<CartBean> myCart = cartDao.getMyCart(userId);

		// 3
		// orderDetail 3
		// order 1

		OrderBean order = new OrderBean();
		order.setUserId(userId);
		order.setOrderStatus("placed");

		LocalDate today = LocalDate.now();
		order.setOrderDate(today.toString());
		Float totalAmount = 0f;

		OrderDetailDao orderDetailDao = new OrderDetailDao();
		OrderDao orderDao = new OrderDao();
		for (CartBean c : myCart) {
			OrderDetailBean orderDetail = new OrderDetailBean();
			orderDetail.setOrderId(order.getOrderId());
			orderDetail.setProductId(c.getProductId());// iphone id
			orderDetail.setPrice(ProductDao.getProductDetailById(c.getProductId()).getPrice());// 97000
			orderDetail.setQty(c.getQty());
			// add orderDetail
			orderDetailDao.addOrderDetail(orderDetail);
			totalAmount = totalAmount + (orderDetail.getPrice() * orderDetail.getQty());
		}

		order.setOrderAmount(totalAmount);
		// add order
		orderDao.addOrder(order);

		//remove all cart items 
		cartDao.removeCartByUserId(userId);
		
		response.sendRedirect("OrderServlet");
	}

}
