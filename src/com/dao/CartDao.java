package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bean.CartBean;

public class CartDao {

	private static ArrayList<CartBean> carts = new ArrayList<CartBean>();

	public void addCart(CartBean cart) {
		boolean flag = false;
		for (int i = 0; i < carts.size(); i++) {
			if (carts.get(i).getUserId().equals(cart.getUserId())
					&& carts.get(i).getProductId().equals(cart.getProductId())) {

				carts.get(i).setQty(carts.get(i).getQty() + 1);
				flag = true;
				System.out.println("getting same cart Product...");
				break;
			}
		}

		if (flag == false) {
			carts.add(cart);
		}
	}

	public ArrayList<CartBean> getAllCarts() {
		return carts;
	}

	public ArrayList<CartBean> getMyCart(Integer userId) {
		// carts {cartId userId productId qty }
		ArrayList<CartBean> userCart = new ArrayList<CartBean>();
		System.out.println("Checking for => " + userId);
		for (CartBean c : carts) {
			System.out.println(c.getProductId() + "  :  " + c.getUserId());
			if (c.getUserId().equals(userId)) {
				System.out.println("match");
				userCart.add(c);
			}
		}

		return userCart;
	}

	public void removeCartByCartId(Integer cartId) {
		Integer removeId = -1;
		for (int i = 0; i < carts.size(); i++) {
			if (carts.get(i).getCartId().equals(cartId)) {
				if (carts.get(i).getQty() == 1) {
					// remove
					removeId = i;
					System.out.println("1 Qty Found");
					//
				} else {
					carts.get(i).setQty(carts.get(i).getQty() - 1);
					System.out.println("More than 1 Qty found");
				}
				break;
			}
		}
		if (removeId != -1) {
			System.out.println("Removing entire Cart..");
			carts.remove((int) removeId);// index ->primitive
		}
	}

	public void removeCartByUserId(Integer userId) { // 7
		List<CartBean> newCart = carts.stream().filter(cart -> !cart.getUserId().equals(userId))
				.collect(Collectors.toList());
		carts = (ArrayList<CartBean>) newCart;
	}
}
