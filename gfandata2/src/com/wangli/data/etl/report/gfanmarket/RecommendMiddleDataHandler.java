package com.wangli.data.etl.report.gfanmarket;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.wangli.data.etl.report.gfanmarket.service.BannerDownLoadCleanService;
import com.wangli.data.etl.report.gfanmarket.service.CommonService;
import com.wangli.data.etl.report.gfanmarket.service.TransformService;
import com.wangli.data.inter.DataHandler;

public class RecommendMiddleDataHandler implements DataHandler{

	private Date date;
	
	private String name;
	
	private CommonService commonService;
	
	private TransformService transformService;
	
	private static Logger logger = Logger.getLogger(RecommendMiddleDataHandler.class);
	
	@Override
	public void processAnalysis() {
		logger.info("Handler:etl.report.gfanmarket handler date:"+date);
		try {
			logger.info("Handler:etl.report.gfanmarket etl p_hotwords date:"+date+" begin");
			transformService.transformData("am", "stat", "p_hotwords", 4);
			logger.info("Handler:etl.report.gfanmarket etl p_keyword_shielding date:"+date+" begin");
			transformService.transformData("am", "stat", "p_keyword_shielding", 9);
			logger.info("Handler:etl.report.gfanmarket etl p_hotwords_search date:"+date+" begin");
			transformService.transformData("am", "stat", "p_hotwords_search", 7);
			logger.info("Handler:etl.report.gfanmarket etl gfan_cfg_content_group date:"+date+" begin");
			transformService.transformData("am", "stat", "gfan_cfg_content_group", 12);
			logger.info("Handler:etl.report.gfanmarket etl gfan_cfg_content date:"+date+" begin");
			transformService.transformData("am", "stat", "gfan_cfg_content", 16);
			logger.info("Handler:etl.report.gfanmarket etl hot_words date:"+date+" begin");
			commonService.generateHotWords();
			logger.info("Handler:etl.report.gfanmarket handler date:"+date+" successful");
		} catch (SQLException e) {
			logger.error("Handler:etl.report.gfanmarket handler date:"+date+" failed",e);
		}
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public TransformService getTransformService() {
		return transformService;
	}

	public void setTransformService(TransformService transformService) {
		this.transformService = transformService;
	}
	
}
