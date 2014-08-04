package com.wangli.data.datasource;

import java.sql.Connection;

import com.wangli.data.util.SpringUtil;
/**
 * 数据库连接工具类
 * @ClassName ConnectionUtil
 * @Description 描述
 * @author wangli
 * @date 2014-8-4 下午6:29:03
 */
public class ConnectionUtil {

	private static DataSource dataSource = null;
	/**
	 * 获取数据库连接
	 * @return
	 */
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
