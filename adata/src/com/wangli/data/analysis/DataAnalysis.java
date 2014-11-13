package com.wangli.data.analysis;

import java.sql.Date;

public interface DataAnalysis {
	/**
	 * 获取改数据分析器再整个程序中的唯一值
	 * @return
	 */
	int getAnalysisType();
	/**
	 * 设置数据分析器在整个程序中的唯一值
	 */
	void setAnalysisType(int type);
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
}
