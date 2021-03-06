package com.wangli.data.analysis.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.wangli.data.analysis.bean.AnalysisLog;
import com.wangli.data.datasource.ConnectionUtil;

public class AnalysisLogSave {

	private static Logger logger = Logger.getLogger(AnalysisLogSave.class);
	
	public void saveAnalysisLog(AnalysisLog log){
		Connection conn = ConnectionUtil.getConn();
		String sql = "insert into ANALYSIS_LOG(CALL_CODE,CALL_NAME,DATA_TIME,TYPE,INSERT_TIME) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.setString(1,log.getCallCode());
			stmt2.setString(2,log.getCallName());
			stmt2.setString(3,log.getDateTime().toString());
			stmt2.setInt(4,log.getType());
			stmt2.setTimestamp(5,log.getInsertTime());
			stmt2.execute();
			stmt2.close();
			conn.close();
		} catch (SQLException e) {
			logger.error("analysis log insert database failed",e);
		}
	}
	
}
