package com.wangli.data.analysis;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.wangli.data.analysis.bean.AnalysisLog;
import com.wangli.data.analysis.log.AnalysisLogSave;
import com.wangli.data.datasource.ConnectionUtil;

public class AnalysisUtil {

	private static Logger logger = Logger.getLogger(AnalysisUtil.class);
	private static AnalysisLogSave logSave = new AnalysisLogSave();
	
	
	public static void indexRepGameAnalysis(String callName,Date logTime){
		AnalysisLog alog = new AnalysisLog();
		alog.setCallCode(callName);
		alog.setDateTime(logTime);
		logSave.saveAnalysisLog(alog);
		logger.debug(callName+":"+logTime.toString());
		try {
			Connection conn = ConnectionUtil.getConn();
			String sql = "{CALL "+callName+"(?)}";
			CallableStatement cstm = conn.prepareCall(sql);
			cstm.setString(1, logTime.toString()); 
			cstm.execute();
			cstm.close(); 
			conn.close();
			alog.setType(1);
			alog.setInsertTime(new Timestamp(new java.util.Date().getTime()));
			logSave.saveAnalysisLog(alog);
		} catch (Exception e) {
			alog.setType(2);
			alog.setInsertTime(new Timestamp(new java.util.Date().getTime()));
			logSave.saveAnalysisLog(alog);
			logger.error(callName+"call failed",e);
		}
	}
	
}
