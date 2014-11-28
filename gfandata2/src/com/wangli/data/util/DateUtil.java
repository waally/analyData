package com.wangli.data.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * 
 * @ClassName DateUtil
 * @Description 日期工具类
 * @author wangli
 * @date 2014-8-4 下午6:38:41
 */
public class DateUtil {

	private static Logger logger = Logger.getLogger(DateUtil.class);
	/**
	 * 获取和指定时间间隔指定天数的时间
	 * @param date
	 * @param last
	 * @return
	 */
	public static Date getLastDate(Date date,int last){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, last);
		return new Date(c.getTimeInMillis());
	}
	/**
	 * 获取和现在间隔指定天数的时间
	 * @param last
	 * @return
	 */
	public static Date getLastDate(int last){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, last);
		return new Date(c.getTimeInMillis());
	}
	/**
	 * 从开始时间到结束时间获取间隔的每一天
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Date[] getIntervalDays(Date beginDate,Date endDate){
		List<Date> dates = new ArrayList<Date>();
		Calendar bc = Calendar.getInstance();
		bc.setTime(beginDate);
		Calendar ec = Calendar.getInstance();
		ec.setTime(endDate);
		while(bc.getTimeInMillis()<=ec.getTimeInMillis()){
			dates.add(new Date(bc.getTimeInMillis()) );
			bc.add(Calendar.DATE, 1);
		}
		return dates.toArray(new Date[dates.size()]);
	}
	/**
	 * 转换字符串格式到日期格式
	 * @param date
	 * @return
	 */
	public static Date getFormString(String date){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date time = dateFormat.parse(date);
			return new Date(time.getTime());
		} catch (Exception e) {
			logger.error("formart string to date failed",e);
		}
		return null;
	}
	/**
	 * 转换日期格式到字符串格式
	 * @param date
	 * @return
	 */
	public static String getFormDate(java.util.Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	public static java.util.Date getLastTimeOfDate(java.util.Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return new java.util.Date(c.getTimeInMillis());
	}
	/**
	 * 是否是一个星期最后一天，星期天是这个星期的最后一天。
	 * @param date
	 * @return
	 */
	public static boolean isLastWeekDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK)==1;
	}
	/**
	 * 是否是一个月的最后一天
	 * @param date
	 * @return
	 */
	public static boolean isLastMonthDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.get(Calendar.DAY_OF_MONTH)==1;
	}
	
}
