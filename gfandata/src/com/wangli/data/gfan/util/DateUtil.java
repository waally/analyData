package com.wangli.data.gfan.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

public class DateUtil {

	private static Logger logger = Logger.getLogger(DateUtil.class);
	
	public static Date getLastDate(Date date,int last){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, last);
		return new Date(c.getTimeInMillis());
	}
	public static Date getLastDate(int last){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, last);
		return new Date(c.getTimeInMillis());
	}
	
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
	
	public static String getFormDate(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	public static boolean isLastWeekDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK)==1;
	}
	
	public static boolean isLastMonthDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.get(Calendar.DAY_OF_MONTH)==1;
	}
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(new java.util.Date()));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		System.out.println(dateFormat.format(c.getTime()));
	}
	
}
