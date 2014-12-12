package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehavior;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventClick;

public interface SearchClickCleanService {

	/**
	 * 获取总数
	 * @param dateTime
	 * @return
	 * @throws SQLException
	 */
	int getCount(String dateTime) throws SQLException;
	/**
	 * 删除历史数据(会重新生成新的数据)
	 * @param dateTime
	 * @throws SQLException
	 */
	void deleteRepeatDate(String dateTime,int behaviorId) throws SQLException;
	/**
	 * 用于分批获取部分数据
	 * @param dateTime
	 * @param start
	 * @param length
	 * @return
	 * @throws SQLException
	 */
	List<ClientEventLog> getEventList(String dateTime,int start,int length) throws SQLException;
	/**
	 * 插入数据
	 * @param list
	 * @throws SQLException
	 */
	void insertBannerClick(List<GfanClientEventClick> list) throws SQLException;
	/**
	 * 检查数据
	 * @param downLoad
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	Integer checkBannerId(String productId,GfanMarketBehavior behavior,Date date) throws SQLException;
}
