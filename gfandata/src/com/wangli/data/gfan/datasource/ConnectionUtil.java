package com.wangli.data.gfan.datasource;

import java.sql.Connection;

import com.wangli.data.gfan.util.ConfigurationUtil;

public class ConnectionUtil {

	private static DataSource dataSource = null;
	
	public static Connection getConn() {
		if(dataSource==null){
			initConnection();
		}
		return dataSource.getCollection();
	}
	
	private static void initConnection(){
		dataSource = new DataSource();
		dataSource.setDriverClassName(ConfigurationUtil.getProValue("DATABASEDRIVERCLASS"));
		dataSource.setUrl(ConfigurationUtil.getProValue("DATABASEURL"));
		dataSource.setUserName(ConfigurationUtil.getProValue("DATABASEUSERNAME"));
		dataSource.setPassword(ConfigurationUtil.getProValue("DATABASEPASSWORD"));
		dataSource.setInitPoolSize(Integer.parseInt(ConfigurationUtil.getProValue("DATABASEINITPOOLSIZE")));
		dataSource.setMinPoolSize(Integer.parseInt(ConfigurationUtil.getProValue("DATABASEMINPOOLSIZE")));
		dataSource.setMaxPoolSize(Integer.parseInt(ConfigurationUtil.getProValue("DATABASEMAXPOOLSIZE")));
	}

}
