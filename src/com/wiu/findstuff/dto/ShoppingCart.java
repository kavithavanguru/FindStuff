/**
 * 
 */
package com.wiu.findstuff.dto;

import java.util.List;

/**
 * @author krv103
 *
 */
public class ShoppingCart {
	private int customerId;
	private List<ShoppingCartItem> shoppingItems;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<ShoppingCartItem> getShoppingItems() {
		return shoppingItems;
	}
	public void setShoppingItems(List<ShoppingCartItem> shoppingItems) {
		this.shoppingItems = shoppingItems;
	} 
	
}
