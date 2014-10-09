
/*
 * Author : Kavitha
 * Rest service methods for shopping cart application
 */
package com.wiu.findstuff.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;
import com.wiu.findstuff.dao.DaoManager;
import com.wiu.findstuff.dto.Customer;
import com.wiu.findstuff.dto.ShoppingCart;
import com.wiu.findstuff.dto.ShoppingCartItem;
import com.wiu.findstuff.transformer.FeedTransformer;

//Displays SubCategories
@Produces({ "application/xml", "application/json" })
@Path("shoppingCart")
@Singleton
public class ShoppingResource {
	DaoManager daoManager = new DaoManager();	
	
	@POST
	@Path("AddToCart")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String AddToCart(String json) {
		try {
			Gson gson = new Gson();
			ShoppingCartItem shoppingCartItem = gson.fromJson(json, ShoppingCartItem.class);
			//Insert customer details in db
			ShoppingCart shoppingCart = daoManager.addToCart(shoppingCartItem);
			//Convert to JSON
			json=FeedTransformer.UserFeed(shoppingCart);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}
	
	@POST
	@Path("GetCartItems")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String GetProfile(String json) {
		try {
			Gson gson = new Gson();
			ShoppingCart shoppingCart = gson.fromJson(json, ShoppingCart.class);
			//Insert customer details in db
			shoppingCart = daoManager.retrieveShoppingCart(shoppingCart);
			for ( ShoppingCartItem  item: shoppingCart.getShoppingItems()) {
				System.out.println("Printing from Manager");
				System.out.println(item.getItemDesc());
			}
			json=FeedTransformer.UserFeed(shoppingCart);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}
	
	@POST
	@Path("UpdateProfile")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String UpdateProfile(String json) {
		try {
			Gson gson = new Gson();
			Customer customerResult = new Customer();
			Customer customer = gson.fromJson(json, Customer.class);
			//Insert customer details in db
			customerResult = daoManager.updateCustomer(customer);
			//Convert to JSON
			json=FeedTransformer.UserFeed(customerResult);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}
	  
}