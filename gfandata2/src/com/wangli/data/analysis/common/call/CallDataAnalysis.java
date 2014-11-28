package com.wangli.data.analysis.common.call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.wangli.data.inter.DataHandler;

public class CallDataAnalysis implements DataHandler{

	private String name;
	
	private Date date;
	
	private List<String> calls = new ArrayList<String>();
	
	private DataSource dataSource;
	
	private static Logger logger = Logger.getLogger(CallDataAnalysis.class);
	
	@Override
	public void processAnalysis() {
		logger.info("Handler:analysis.common.call handler date:"+date);
		for(String callName:calls){
			processProduceCall(callName);
		}
		logger.info("Handler:analysis.common.call handler date:"+date+" successful");
	}
	
	private void processProduceCall(String callName){
		Connection conn = null;
		CallableStatement cstm = null;
		try {
			logger.info("Handler:analysis.common.call handle "+callName+" call begin");
			conn = dataSource.getConnection();
			String sql = "{CALL "+callName+"(?)}";
			cstm = conn.prepareCall(sql);
			cstm.setString(1, date.toString()); 
			cstm.execute();
			logger.info("Handler:analysis.common.call handle "+callName+" call successful");
		} catch (Exception e) {
			logger.info("Handler:analysis.common.call handle "+callName+" call failed",e);
		}finally{
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("Handler:analysis.common.call handle conn close failed",e);
			} 
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getCalls() {
		return calls;
	}

	public void setCalls(List<String> calls) {
		this.calls = calls;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
