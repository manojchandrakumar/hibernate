package org.manoj.javaminds.dao;

import java.util.List;

import org.manoj.javaminds.entity.Cart;
import org.manoj.javaminds.entity.Items;

public interface ShoppingDAO {

	public void addItemsToCart(Cart cart);
	
	public void addItems(List<Items> items);
}
