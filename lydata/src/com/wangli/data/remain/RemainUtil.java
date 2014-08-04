package com.wangli.data.remain;

import java.sql.Date;
import java.util.Calendar;

public class RemainUtil {

	public static String getActiveTableName(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH)+1;
		return "LOG_PLAYER_ACTIVE_"+c.get(Calendar.YEAR)+(month<10?"0"+month:month);
	}
	
	public static String getGameActiveTableName(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH)+1;
		return "LOG_PLAYER_GAME_ACTIVE_"+c.get(Calendar.YEAR)+(month<10?"0"+month:month);
	}
	
}
