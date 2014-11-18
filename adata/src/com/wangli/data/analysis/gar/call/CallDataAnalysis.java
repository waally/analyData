package com.wangli.data.analysis.gar.call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.wangli.data.analysis.DataAnalysis;

public class CallDataAnalysis implements DataAnalysis{

	private int analysisType;
	
	private Date date;
	
	private List<String> calls = new ArrayList<String>();
	
	private DataSource dataSource;
	
	private static Logger logger = Logger.getLogger(CallDataAnalysis.class);
	
	@Override
	public int getAnalysisType() {
		return this.analysisType;
	}

	@Override
	public void processAnalysis() {
		for(String callName:calls){
			processProduceCall(callName);
		}
	}
	
	private void processProduceCall(String callName){
		Connection conn = null;
		CallableStatement cstm = null;
		try {
			logger.info(callName+" call begin");
			conn = dataSource.getConnection();
			String sql = "{CALL "+callName+"(?)}";
			cstm = conn.prepareCall(sql);
			cstm.setString(1, date.toString()); 
			cstm.execute();
			logger.info(callName+" call successful");
		} catch (Exception e) {
			logger.error("gar system produceCall("+callName+") call data analysis failed", e);
		}finally{
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("gar system call data conn close failed", e);
			} 
		}
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	@Override
	public void setAnalysisType(int type) {
		this.analysisType = type;
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
