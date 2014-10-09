/*
 * Author : Kavitha
 * This class is written to access data from database using Ibatis, one of the ORM techniques
 */

package com.wiu.findstuff.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wiu.findstuff.dto.Customer;
import com.wiu.findstuff.dto.Item;
import com.wiu.findstuff.dto.ShoppingCart;
import com.wiu.findstuff.dto.ShoppingCartItem;
import com.wiu.findstuff.dto.Sub_Category;


public class DaoManager{
	
	public List<Sub_Category> RetrieveSubCategories() throws IOException,SQLException
	{
		List<Sub_Category> subCategories = new ArrayList<Sub_Category>();			
				SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	   
			    System.out.println("*------Information by SubCategory-------*");
			    subCategories = (List<Sub_Category>)sqlMap.queryForList("ShoppingList.retrieveSubCategories");
			    for (Sub_Category sub_Category : subCategories) {
					System.out.println(sub_Category.getSub_Cat_Name());
				}

        
		return subCategories;
	}
	
	public List<Item> RetrieveItems(int sub_Cat_Id) throws IOException,SQLException
	{
		List<Item> items = new ArrayList<Item>();
				SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	   
			    System.out.println("*------Information by Items-------*");
			    items = (List<Item>)sqlMap.queryForList("ShoppingList.retrieveItems",sub_Cat_Id);
			    for (Item item : items) {
					System.out.println(item.getItem_Name());
				}

        
		return items;
	}
	
	public Item RetrieveItemDetails(int Sub_Cat_Id, int Item_Id) throws IOException,SQLException
	{
				Item item = new Item();
				Item resultItem = new Item();
				item.setItem_Id(Item_Id);
				item.setSub_Cat_Id(Sub_Cat_Id);
				SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	   
			    System.out.println("*------Item Details-------*");
			    resultItem = (Item)sqlMap.queryForObject("ShoppingList.retrieveItemDetails",item);
			    System.out.println(resultItem.getItem_Desc());
			    return resultItem;
	}
	
	public  String insertCustomer(Customer customer) throws IOException, SQLException{
		 SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	   
		 sqlMap.insert("ShoppingList.insertCustomer",customer);
		 System.out.println("=================INSERTED======================");
		 return "Customer Inserted Successfully";
	}
	
	public  Customer retrieveCustomer(Customer customer) throws IOException, SQLException{
			Customer customerReturn = new Customer();
			SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	   
			System.out.println("Here");
			customerReturn = (Customer)sqlMap.queryForObject("ShoppingList.retrieveCustomer",customer);
			return customerReturn;
	}
	public  Customer updateCustomer(Customer customer) throws IOException, SQLException{
		Customer customerReturn = new Customer();
		SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	
		//sqlMap.update("ShoppingList.updateCustomer",customer);
		//System.out.println("Updated");
		sqlMap.update("ShoppingList.updateCustomer",customer);
		System.out.println("Updated Customer");
		customer.getPaymentInfo().setCustomerId(customer.getCustomterId());
		sqlMap.update("ShoppingList.updatePayment",customer.getPaymentInfo());
		System.out.println("Updated Payment");
		customerReturn = (Customer)sqlMap.queryForObject("ShoppingList.retrieveCustomer",customer);
		System.out.println("Retrieved");
		return customerReturn;
}
	public ShoppingCart addToCart(ShoppingCartItem shoppingCartItem) throws IOException, SQLException{
		ShoppingCart shoppingCart = new ShoppingCart();
		SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	
		//sqlMap.update("ShoppingList.updateCustomer",customer);
		//System.out.println("Updated");
		sqlMap.insert("ShoppingList.addToCart",shoppingCartItem);
		
		System.out.println("Added");
		shoppingCart.setShoppingItems((List<ShoppingCartItem>)sqlMap.queryForList("ShoppingList.retrieveShoppingCart",shoppingCartItem.getCustomerId()));
		System.out.println("Retrieved");
		return shoppingCart;
	}
	public ShoppingCart retrieveShoppingCart(ShoppingCart shoppingCart) throws IOException, SQLException{
		SqlMapClient sqlMap = SqlMapClientManager.getSqlMapClientManager();	
		shoppingCart.setShoppingItems((List<ShoppingCartItem>)sqlMap.queryForList("ShoppingList.retrieveShoppingCart",shoppingCart.getCustomerId()));
		for ( ShoppingCartItem  item: shoppingCart.getShoppingItems()) {
			System.out.println(item.getItemDesc());
		}
		System.out.println("Retrieved");
		return shoppingCart;
	}
	
}
