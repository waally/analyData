package com.wangli.data.service;


import java.sql.Date;

import com.wangli.data.analysis.AnalysisUtil;
import com.wangli.data.analysis.ProcedureCallConstant;
import com.wangli.data.analysis.RemainDataAnalysis;
import com.wangli.data.util.DateUtil;

public class AnalysisServiceImpl implements AnalysisService {

	private RemainDataAnalysis remainDataAnalysis = new RemainDataAnalysis();
	
	@Override
	public void analysisDayData() {
		Date logTime = DateUtil.getLastDate(-1);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEPAY, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEPAYUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMECONSUME, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMECONSUMEUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEINCOME, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEPAYCHANNEL, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEARPU, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEADDUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEACTIVEUSER, logTime);
		if(DateUtil.isLastWeekDay(logTime)){
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEPAY, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEPAYUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMECONSUME, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMECONSUMEUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEPAYCHANNEL, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEARPU, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEADDUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEACTIVEUSER, logTime);
		}
		if(DateUtil.isLastMonthDay(logTime)){
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEPAY, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEPAYUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMECONSUME, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMECONSUMEUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEPAYCHANNEL, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEARPU, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEADDUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEACTIVEUSER, logTime);
		}
	}
	@Override
	public void analysisDayData2() {
		Date logTime = DateUtil.getLastDate(-1);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEDOWNLOAD, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMECONVERSIONRATE, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMETOTAL, logTime);
		if(DateUtil.isLastWeekDay(logTime)){
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEDOWNLOAD, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMECONVERSIONRATE, logTime);
		}
		if(DateUtil.isLastMonthDay(logTime)){
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEDOWNLOAD, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMECONVERSIONRATE, logTime);
		}
	}

	@Override
	public void analysisDayData(Date logTime) {
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEPAY, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEPAYUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMECONSUME, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMECONSUMEUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEPAYCHANNEL, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEARPU, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEADDUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEACTIVEUSER, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMEDOWNLOAD, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMECONVERSIONRATE, logTime);
		AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.DAYREPGAMETOTAL, logTime);
		if(DateUtil.isLastWeekDay(logTime)){
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEPAY, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEPAYUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMECONSUME, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMECONSUMEUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEPAYCHANNEL, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEARPU, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEADDUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEACTIVEUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMEDOWNLOAD, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.WEEKREPGAMECONVERSIONRATE, logTime);
		}
		if(DateUtil.isLastMonthDay(logTime)){
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEPAY, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEPAYUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMECONSUME, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMECONSUMEUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEPAYCHANNEL, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEARPU, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEADDUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEACTIVEUSER, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMEDOWNLOAD, logTime);
			AnalysisUtil.indexRepGameAnalysis(ProcedureCallConstant.MONTHREPGAMECONVERSIONRATE, logTime);
		}
	}

	@Override
	public void analysisRemainData() {
		Date logTime = DateUtil.getLastDate(-1);
		remainDataAnalysis.dayRepGameRemain(logTime);
	}

	@Override
	public void analysisRemainData(Date date) {
		remainDataAnalysis.dayRepGameRemain(date);
	}

	@Override
	public void analysisData(String callName, Date date) {
		AnalysisUtil.indexRepGameAnalysis(callName, date);
	}

}
