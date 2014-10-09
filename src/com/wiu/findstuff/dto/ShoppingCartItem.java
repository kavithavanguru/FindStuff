/**
 * 
 */
package com.wiu.findstuff.dto;

/**
 * @author krv103
 *
 */
public class ShoppingCartItem {
	private int shoppingCartItemId;
	private int customerId;
	private int itemId;
	private String itemName;
	private String size;
	private int quantity;
	private int price;
	private int SubCatId;
	private String Item_Img;
	
	public String getItem_Img() {
		return Item_Img;
	}
	public void setItem_Img(String item_Img) {
		Item_Img = item_Img;
	}
	public int getSub_Cat_Id() {
		return SubCatId;
	}
	public void setSub_Cat_Id(int sub_Cat_Id) {
		SubCatId = sub_Cat_Id;
	}
	public int getShoppingCardId() {
		return shoppingCartItemId;
	}
	public void setShoppingCardId(int shoppingCardId) {
		this.shoppingCartItemId = shoppingCardId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDesc() {
		return itemName;
	}
	public void setItemDesc(String itemDesc) {
		this.itemName = itemDesc;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
