/**
 * Author : Kavitha
 */

var ProductLine = ProductLine || {};
ProductLine.ShoppingCart =  {};
ProductLine.ShoppingCartItem = {};

ProductLine.ShoppingCartItem = function (shoppingCartItemId,customerId, itemId ,itemName,size, quantity,price, SubCatId) {
	  this.shoppingCartItemId = shoppingCartItemId;
	  this.customerId = customerId;
	  this.itemId = itemId;
	  this.itemName = itemName;
	  this.size = size;
	  this.quantity = quantity;
	  this.price = price;
	  this.SubCatId = SubCatId;
	};

ProductLine.ShoppingCart =  {
		customerId : 0,
		//numberOfitems : 0,
		shoppingCartItems : []
};