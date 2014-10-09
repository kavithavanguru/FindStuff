
/*
 * Author : Kavitha
 * Rest service methods for shopping cart application
 */
package com.wiu.findstuff.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;
import com.wiu.findstuff.dao.DaoManager;
import com.wiu.findstuff.dto.Customer;
import com.wiu.findstuff.transformer.FeedTransformer;

//Displays SubCategories
@Produces({ "application/xml", "application/json" })
@Path("profile")
@Singleton
public class CustomerResource {
	DaoManager daoManager = new DaoManager();	
	
	@POST
	@Path("InsertProfile")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String InsertCustomer(String json) {
		try {
			Gson gson = new Gson();
			Customer customer = gson.fromJson(json, Customer.class);
			//Insert customer details in db
			json = daoManager.insertCustomer(customer);
			//Convert to JSON
			json=FeedTransformer.UserFeed(json);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}
	
	@POST
	@Path("GetProfile")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String GetProfile(String json) {
		try {
			Gson gson = new Gson();
			Customer customer = gson.fromJson(json, Customer.class);
			//Insert customer details in db
			customer = daoManager.retrieveCustomer(customer);
			//Convert to JSON
			json=FeedTransformer.UserFeed(customer);
			
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