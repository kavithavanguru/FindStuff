
/*
 * Author : Kavitha
 * Rest service methods for shopping cart application
 */
package com.wiu.findstuff.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;
import com.wiu.findstuff.dao.DaoManager;
import com.wiu.findstuff.dto.Customer;
import com.wiu.findstuff.dto.Item;
import com.wiu.findstuff.dto.Sub_Category;
import com.wiu.findstuff.transformer.FeedTransformer;

//Displays SubCategories
@Produces({ "application/xml", "application/json" })
@Path("shopping")
@Singleton
public class ItemResource {
	DaoManager daoManager = new DaoManager();
	@GET
	public String getSubCategories() {
		String json  = null;
		try 
		{
			List<Sub_Category> sub_categories = null;
			//Get Subcategories from database
			sub_categories = daoManager.RetrieveSubCategories();
			//Convert to JSON
			json=FeedTransformer.UserFeed(sub_categories);
			

		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return json;
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public String getItems(@PathParam("id") int sub_Cat_Id) {
		String json  = null;
		try 
		{
			List<Item> items = null;	
			//Get items by SubCategory from db
			items = daoManager.RetrieveItems(sub_Cat_Id);
			//Convert to JSON
			json=FeedTransformer.UserFeed(items);
			

		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return json;
	}

	@GET
	@Path("getItemDetails/{Sub_Cat_Id}/{Item_Id}")
	@Produces({ "application/xml", "application/json" })
	public String getItemDetails(@PathParam("Sub_Cat_Id") int Sub_Cat_Id,
			@PathParam("Item_Id") int Item_Id) {
		String json  = null;
		try 
		{
			Item item = null;
			//Get Item details from db
			item = daoManager.RetrieveItemDetails(Sub_Cat_Id,Item_Id);
			//Convert to JSON
			json=FeedTransformer.UserFeed(item);
			

		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return json;
	}
	
/*	@POST
	@Path("InsertCustomer")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String InsertCustomer(Customer customer) {
		String json  = null;
		try {
			//Insert customer details in db
			json = daoManager.insertCustomer(customer);
			//Convert to JSON
			json=FeedTransformer.UserFeed(json);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}*/
	
	@POST
	@Path("InsertCustomer")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String InsertCustomer(String strin) {
		String json  = null;
		try {
			Gson gson = new Gson();
			Customer customer = gson.fromJson(strin, Customer.class);
			//Insert customer details in db
			json = daoManager.insertCustomer(customer);
			//Convert to JSON
			json=FeedTransformer.UserFeed(json);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}
	  
}