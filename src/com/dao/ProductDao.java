package com.dao;

import java.util.ArrayList;

import com.bean.ProductBean;

public class ProductDao {

	private static ArrayList<ProductBean> products = new ArrayList<ProductBean>();

	static {
		ProductBean p1 = new ProductBean();
		p1.setName("iphone 14 pro");
		p1.setPrice(129000F);
		p1.setQty(5);

		ProductBean p2 = new ProductBean();
		p2.setName("Fold 3");
		p2.setPrice(60000F);
		p2.setQty(10);

		ProductBean p3 = new ProductBean();
		p3.setName("Legion y520");
		p3.setPrice(100000F);
		p3.setQty(7);

		products.add(p1);
		products.add(p2);
		products.add(p3);
	}

	public ArrayList<ProductBean> getAllProducts() {
		return products;
	}

	public static ProductBean getProductDetailById(int productId) {
		for (ProductBean p : products) {
			if (p.getProductId() == productId) {
				return p;
			}
		}
		return null;
	}
}
