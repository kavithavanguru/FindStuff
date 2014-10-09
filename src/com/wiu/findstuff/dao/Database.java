/*
 * Author : Kavitha
 * This class contains database conn details
 */

package com.wiu.findstuff.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public Connection Get_Connection() throws Exception
	{
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:5797;" +
                "databaseName=AppProject;user=kavi;password=kavi;";
            Connection connection = DriverManager.getConnection(connectionUrl);
            return connection;
            
		}
		catch (SQLException e)
		{
		throw e;	
		}
		catch (Exception e)
		{
		throw e;	
		}
	}

}
