/*
 * Author : Kavitha
 * This class uses generics implementation and method overloading concepts to parse java object to JSON string using gson api
 */

package com.wiu.findstuff.transformer;

import java.util.Collection;

import com.google.gson.Gson;

public class FeedTransformer<T> 
{
	static String feeds  = null;
	static Gson gson = new Gson();
	
	//This method accepts list of objects
  public static <T> String UserFeed(Collection<T>  feedData)
	{
	feeds = gson.toJson(feedData);
	return feeds;
	}
  
  //This method accepts any object
  public static <T> String  UserFeed(T  t)
	{
	feeds = gson.toJson(t);
	return feeds;
	}
}
