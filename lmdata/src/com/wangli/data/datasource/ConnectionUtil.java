package com.wangli.data.datasource;

import java.sql.Connection;

import com.wangli.data.util.SpringUtil;

public class ConnectionUtil {

	private static DataSource dataSource = null;
	
	public static Connection getConn() {
		if(dataSource==null){
			initConnection();
		}
		return dataSource.getCollection();
	}
	
	private static void initConnection(){
		dataSource = (DataSource) SpringUtil.getSpringContext().getBean("dataSource");
	}

}
