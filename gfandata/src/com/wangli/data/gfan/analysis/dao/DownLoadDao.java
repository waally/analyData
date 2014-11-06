package com.wangli.data.gfan.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wangli.data.gfan.analysis.bean.DownLoad;
import com.wangli.data.gfan.datasource.ConnectionUtil;

public class DownLoadDao {

	private static Logger logger = Logger.getLogger(DownLoadDao.class);
	
	private String tableName = "`client_event_log_201411`";
	
	public int getCount(String dataTime){
		Connection conn = ConnectionUtil.getConn();
		String sql = "select count(1) from "+tableName+" where data_time='"+dataTime
				+"' and version='2'  and event_id='2102'";
		PreparedStatement stmt2 = null;
		ResultSet result = null;
		try {
			stmt2 = conn.prepareStatement(sql);
			result = stmt2.executeQuery();
			while(result.next()){
				return result.getInt(1);
			}
		} catch (Exception e) {
			logger.error("query count failed");
		}finally{
			try {
				result.close();
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("close Connection failed");
			}
		}
		return 0;
	}
	
	public List<DownLoad> getDownLoad(String dataTime,int startIndex,int endIndex){
		List<DownLoad> list = new ArrayList<DownLoad>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from "+tableName+" where data_time='"+dataTime
				+"' and version='2'  and event_id='2102' limit "+startIndex+","+endIndex;
		PreparedStatement stmt2 = null;
		ResultSet result = null;
		try {
			stmt2 = conn.prepareStatement(sql);
			result = stmt2.executeQuery();
			while(result.next()){
				DownLoad downLoad = new DownLoad();
				downLoad.setId(result.getInt("id"));
				downLoad.setImei(result.getString("imei"));
				downLoad.setClientName(result.getString("client_name"));
				downLoad.setClientId(result.getString("client_id"));
				downLoad.setClientVersion(result.getString("client_version"));
				downLoad.setCid(result.getString("cid"));
				downLoad.setEventId(result.getString("event_id"));
				downLoad.setEventValue(result.getString("event_value"));
				downLoad.setEventSource(result.getString("event_source"));
				downLoad.setArgs(result.getString("args").replace("&apos;", "'"));
				downLoad.setLogTime(result.getTimestamp("insert_time"));
				downLoad.setDataTime(dataTime);
				list.add(downLoad);
			}
		} catch (Exception e) {
			logger.error("query data failed");
		}finally{
			try {
				result.close();
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("close Connection failed");
			}
		}
		return list;
	}
	
	public void deleteDownLoad(String dataTime){
		String sql = "delete from `gfan_report_request_download` where data_time = ?";
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement stmt2 = null;
		try {
			stmt2 = conn.prepareStatement(sql);
			stmt2.setString(1,dataTime);
			stmt2.execute();
		} catch (SQLException e1) {
			logger.error("delete data failed");
		}finally{
			try {
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("close Connection failed");
			}
		}
	}
	
	public void insertDownLoad(List<DownLoad> list){
		String sql = "INSERT INTO `gfan_report_request_download` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement stmt2 = null;
		try {
			conn.setAutoCommit(false);
			stmt2 = conn.prepareStatement(sql);
			for(DownLoad downLoad : list){
				stmt2.setInt(1,downLoad.getId());
				stmt2.setString(2,downLoad.getDataTime());
				stmt2.setString(3,downLoad.getImei());
				stmt2.setString(4,downLoad.getClientName());
				stmt2.setString(5,downLoad.getClientId());
				stmt2.setString(6,downLoad.getClientVersion());
				stmt2.setString(7,downLoad.getCid());
				stmt2.setString(8,downLoad.getEventId());
				stmt2.setString(9,downLoad.getEventValue());
				stmt2.setString(10,downLoad.getEventSource());
				stmt2.setString(11,downLoad.getArgs());
				stmt2.setInt(12,downLoad.getPid());
				stmt2.setString(13,downLoad.getPath());
				stmt2.setTimestamp(14,downLoad.getLogTime());
				stmt2.setTimestamp(15,downLoad.getInsertTime());
				stmt2.addBatch();
			}
			stmt2.executeBatch();
			conn.commit();
		} catch (SQLException e1) {
			logger.error("batch insert data failed");
		}finally{
			try {
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("close Connection failed");
			}
		}
	}
	
	
}
