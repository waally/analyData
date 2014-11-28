package com.wangli.data.inter;

import java.sql.Date;
/**
 * 数据处理器
 * @ClassName DataCleanHandler
 * @Description 描述
 * @author wangli
 * @date 2014-11-26 上午11:35:39
 */
public interface DataHandler{

	/**
	 * 进行分析处理
	 */
	void processAnalysis();
	/**
	 * 设置日期
	 * @param date
	 */
	void setDate(Date date);
	/**
	 * 获取日期
	 * @return
	 */
	Date getDate();
	/**
	 * 设置清洗器的名称
	 * @param name
	 */
	void setName(String name);
	/**
	 * 获取清洗器的名称
	 * @return
	 */
	String getName();
	
}
