package com.wangli.data.service;


import java.sql.Date;
import java.util.Map;

import com.wangli.data.analysis.AnalysisUtil;
import com.wangli.data.quartz.StoredProcedureJobObject;
import com.wangli.data.sprocedure.Call;
import com.wangli.data.sprocedure.CallType;
import com.wangli.data.util.DateUtil;
import com.wangli.data.util.SpringUtil;

public class AnalysisServiceImpl implements AnalysisService {

	@Override
	public void analysisDayData(Date logTime) {
		Map<String, StoredProcedureJobObject> spjobs= SpringUtil.getSpringContext().getBeansOfType(StoredProcedureJobObject.class);
		for(StoredProcedureJobObject spjob:spjobs.values()){
			for(Call call : spjob.getCalls()){
				if(call.getCallType()==CallType.MONTH&&DateUtil.isLastMonthDay(logTime)){
					analysisData(call.getCallName(),logTime);
				}else if(call.getCallType()==CallType.WEEK&&DateUtil.isLastWeekDay(logTime)){
					analysisData(call.getCallName(),logTime);
				}else if(call.getCallType()==CallType.DAY){
					analysisData(call.getCallName(),logTime);
				}
			}
		}
	}

	@Override
	public void analysisData(String callName, Date date) {
		AnalysisUtil.indexRepGameAnalysis(callName, date);
	}

}
