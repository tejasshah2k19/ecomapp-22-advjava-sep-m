package com.dao;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.bean.OrderBean;

public class OrderDao {
	private static ArrayList<OrderBean> orders = new ArrayList<>();

	public void addOrder(OrderBean ob) {
		orders.add(ob);
	}

	public ArrayList<OrderBean> getOrderByUserId(Integer userId) {
		return (ArrayList<OrderBean>) orders.stream().filter(o -> o.getUserId().equals(userId))
				.collect(Collectors.toList());
	}
}
