package com.wangli.data.datasource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @ClassName DataSource
 * @Description 数据库连接封装类
 * @author wangli
 * @date 2014-8-4 下午6:29:26
 */
public class DataSource {

	private static Logger logger = Logger.getLogger(DataSource.class);
	/**
	 * 数据库驱动名称
	 */
	private String driverClassName;
	/**
	 * url连接
	 */
	private String url;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 连接池连接最大数
	 */
	private int maxPoolSize;
	/**
	 * 连接池连接最小数
	 */
	private int minPoolSize;
	/**
	 * 连接池初始化连接数量
	 */
	private int initPoolSize;
	
	private ComboPooledDataSource ds;
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getInitPoolSize() {
		return initPoolSize;
	}
	public void setInitPoolSize(int initPoolSize) {
		this.initPoolSize = initPoolSize;
	}
	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public int getMinPoolSize() {
		return minPoolSize;
	}
	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}
	
	
	public Connection getCollection(){
		if(ds==null){
			ds = new ComboPooledDataSource();
			try {
				ds.setDriverClass(driverClassName);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			ds.setJdbcUrl(url);
			ds.setPassword(password);
			ds.setUser(userName);
			ds.setMaxPoolSize(maxPoolSize);
			ds.setInitialPoolSize(initPoolSize);
			ds.setMinPoolSize(minPoolSize);
			ds.setCheckoutTimeout(5000);
//			ds.setMaxIdleTime(25200);
		}
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			logger.fatal("dataSource get error",e);
		}
		return null;
	}
}
