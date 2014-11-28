package com.wangli.data.etl.report.gfanmarket;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.wangli.data.inter.DataHandler;

public abstract class RecommendCleanHandler implements DataHandler {

	private Date date;
	
	private static final int maxLength = 10000;
	
	private static Logger logger = Logger.getLogger(RecommendCleanHandler.class);
	
	@Override
	public void processAnalysis() {
		logger.info("Handler:etl.report.gfanmarket handler date:"+date);
		try {
			int count = getCount();
			logger.info("Handler:etl.report.gfanmarket handler count "+count);
			int startIndex = 0;
			deleteAll();
			while(startIndex<count){
				logger.info("Handler:etl.report.gfanmarket handler ("+startIndex+","+maxLength+") begin");
				handleOnce(startIndex,maxLength);
				logger.info("Handler:etl.report.gfanmarket handler ("+startIndex+","+maxLength+") finish");
				startIndex+=maxLength;
			}
			logger.info("Handler:etl.report.gfanmarket handler date:"+date+" successful");
		} catch (Exception e) {
			logger.error("Handler:etl.report.gfanmarket handler date:"+date+" failed",e);
		}
	}

	/**
	 * 获取需要处理的数据的总数
	 * @return
	 * @throws Exception
	 */
	protected abstract int getCount()throws Exception;

	/**
	 * 删除历史数据
	 * @throws Exception
	 */
	protected abstract void deleteAll()throws Exception;

	/**
	 * 分批处理
	 * @param startIndex
	 * @param maxlength2
	 * @throws Exception
	 */
	protected abstract void handleOnce(int startIndex, int maxlength2) throws Exception;

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

}
