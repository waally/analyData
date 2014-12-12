package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class TransformServiceImpl implements TransformService {

	private Map<String,DataSource> dataSources = new HashMap<String,DataSource>();
	
	public void transformData(String source,String target,String tableName,int fieldCount){
		DataSource sourceDB = dataSources.get(source);
		DataSource targetDB = dataSources.get(target);
		List<Map<Integer,Object>> list = select(sourceDB, tableName, fieldCount);
		delete(targetDB, tableName);
		insert(targetDB, tableName, fieldCount, list);
	}
	
	private void delete(DataSource sourceDB,String tableName){
		Connection conn = null;
		PreparedStatement statement = null;
		String sql = "TRUNCATE "+tableName;
		try {
			conn = sourceDB.getConnection();
			statement = conn.prepareStatement (sql); 
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void insert(DataSource sourceDB,String tableName,int fieldCount,List<Map<Integer,Object>> list){
		Connection conn = null;
		PreparedStatement statement = null;
		String sql = "";
		for(int i=0;i<fieldCount;i++){
			if(i==0){
				sql+="?";
			}else{
				sql+=",?";
			}
		}
		sql = "insert into "+tableName +" values("+sql+")";
		try {
			conn = sourceDB.getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement (sql); 
			for(Map<Integer,Object> map:list){
				for(Integer index : map.keySet()){
					statement.setObject(index, map.get(index));
				}
				statement.execute();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private List<Map<Integer,Object>> select(DataSource sourceDB,String tableName,int fieldCount){
		List<Map<Integer,Object>> list = new ArrayList<Map<Integer,Object>>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = sourceDB.getConnection();
			statement = conn.createStatement();
			result = statement.executeQuery("select * from "+tableName);
			while (result.next()) {
				Map<Integer,Object> map = new HashMap<Integer,Object>();
				for(int i=1;i<=fieldCount;i++){
					map.put(i, result.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Map<String, DataSource> getDataSources() {
		return dataSources;
	}

	public void setDataSources(Map<String, DataSource> dataSources) {
		this.dataSources = dataSources;
	}
	
}
