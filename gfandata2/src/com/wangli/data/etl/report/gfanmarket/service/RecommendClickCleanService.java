package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventBannerclick;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventDownload;

public interface RecommendClickCleanService {

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
	void deleteRepeatDate(String dateTime) throws SQLException;
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
	void insertBannerClick(List<GfanClientEventBannerclick> list) throws SQLException;
	/**
	 * 检查数据，并添加behaviorId
	 * @param downLoad
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	GfanClientEventBannerclick markBehaviorId(GfanClientEventBannerclick downLoad,Date date) throws SQLException;
}
