package com.wangli.data.remain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangli.data.datasource.ConnectionUtil;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.util.DateUtil;

public class RemainProduce {

	public List<Remain> getRemains(Date date) throws SQLException{
		List<Remain> list = new ArrayList<Remain>();
		list.addAll(getRemains(date,2));
		list.addAll(getRemains(date,3));
		list.addAll(getRemains(date,4));
		list.addAll(getRemains(date,5));
		list.addAll(getRemains(date,6));
		list.addAll(getRemains(date,7));
		return list;
		
	}
	private List<Remain> getRemains(Date date,int day) throws SQLException{
		int countday = -day+1;
		List<Remain> list = new ArrayList<Remain>();
		Date addBeginTime = DateUtil.getLastDate(date, countday);
		Date addEndTime = DateUtil.getLastDate(addBeginTime,1);
		Date actvieEndTime = DateUtil.getLastDate(date, 1);
		Connection conn = ConnectionUtil.getConn();
		String sql = "select DISTINCT t.APP_KEY from "+RemainUtil.getGameActiveTableName(addBeginTime)+" t,BASE_UNION_GAME t2 where t.LOG_TIME >='"+addBeginTime.toString()+"' and t.LOG_TIME<'"+addEndTime.toString()+"' AND t.ACTIVE_TYPE = 1 AND t.APP_KEY = t2.APP_KEY AND t2.IS_UNION = 0";
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		ResultSet result = stmt2.executeQuery();
		while(result.next()){
			Remain temp = new Remain();
			temp.setActiveBeginTime(date.toString());
			temp.setActiveEndTime(actvieEndTime.toString());
			temp.setAddBeginTime(addBeginTime.toString());
			temp.setAddEndTIme(addEndTime.toString());
			temp.setAppKey(result.getInt("APP_KEY"));
			temp.setDay(day);
			list.add(temp);
		}
		result.close();
		stmt2.close();
		conn.close();
		return list;
	}
}
