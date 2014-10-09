/*
 * Author : Kavitha
 * This class returns an instance of SqlMapClient by accessing the database conn information provided in SqlMapConfig.xml
 */
package com.wiu.findstuff.dao;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientManager {

	/**
	 * 
	 */		
	static SqlMapClient sqlMap;
	static Reader reader;
	public static SqlMapClient getSqlMapClientManager() throws IOException {
			 reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			 sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		return sqlMap;

	}

}
