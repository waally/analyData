package com.wangli.data.analysis;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;

import com.wangli.data.analysis.bean.AnalysisLog;
import com.wangli.data.analysis.log.AnalysisLogSave;
import com.wangli.data.remain.RemainProduce;
import com.wangli.data.remain.RemainSave;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.remain.processor.SumRemainProcessor;

public class RemainDataAnalysis {

	private static Logger logger = Logger.getLogger(RemainDataAnalysis.class);
	private static AnalysisLogSave logSave = new AnalysisLogSave();
	
	public void dayRepGameRemain(Date logTime){
		AnalysisLog alog = new AnalysisLog();
		alog.setCallCode("DayRepGameRemainRate");
		alog.setDateTime(logTime);
		logSave.saveAnalysisLog(alog);
		try {
			logger.debug("DayRepGameRemainRate:"+logTime.toString());
			SumRemainProcessor processor = new SumRemainProcessor();
			RemainSave remainSave = new RemainSave();
			List<Remain> remains = new RemainProduce().getRemains(logTime);
			logger.debug("DayRepGameRemainRate:"+remains.size());
			for(final Remain remain :remains){
				logger.debug("DayRepGameRemainRate{GAME_ID:"+remain.getAppKey()+",ADD_TIME:"+remain.getAddBeginTime()+",REMAIN_DATE:"+remain.getDay()+"}");
				processor.handleRemain(remain);
				remainSave.saveRemain(remain);
			}
			alog.setType(1);
			alog.setInsertTime(new Timestamp(new java.util.Date().getTime()));
			logSave.saveAnalysisLog(alog);
		} catch (Exception e) {
			alog.setType(2);
			alog.setInsertTime(new Timestamp(new java.util.Date().getTime()));
			logSave.saveAnalysisLog(alog);
			logger.error("DayRepGameRemainRate call failed",e);
		}
		AnalysisUtil.indexRepGameAnalysis("DayRepGameRemain",logTime);
	}
}
