package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
	boolean isRecommend(String productId,int page,Date date) throws SQLException;
}
