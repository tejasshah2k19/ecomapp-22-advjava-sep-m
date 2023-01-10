package com.dao;

import java.util.ArrayList;

import com.bean.OrderDetailBean;

public class OrderDetailDao {
	private static ArrayList<OrderDetailBean> orderDetails = new ArrayList<>();

	
	public void addOrderDetail(OrderDetailBean ob) {
		orderDetails.add(ob);
	}
	
	 
	
	
}
