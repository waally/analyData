package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehavior;

public interface CommonService {

	/**
	 * 获取需要处理的SDK的版本
	 * @return
	 * @throws SQLException
	 */
	List<String> getStatisticsVersion() throws SQLException;
	/**
	 * 检查数据是否属于对应的推荐位
	 * @param productId
	 * @param page
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	Integer isBehavior(String productId,GfanMarketBehavior type,Date date) throws SQLException;
	/**
	 * 生成热词
	 */
	void generateHotWords() throws SQLException;
	
}
