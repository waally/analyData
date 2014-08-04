package com.wangli.data.remain.processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.wangli.data.datasource.ConnectionUtil;
import com.wangli.data.remain.RemainProcessor;
import com.wangli.data.remain.RemainUtil;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.util.DateUtil;

public class SimpleRemainProcessor implements RemainProcessor{

	@Override
	public int handleRemain(Remain remain) throws SQLException {
		return getAtiveCount(remain);
	}
	
	private int getAtiveCount(Remain remain) throws SQLException{
		Set<Integer> addSets = getAddSet(remain);
		int activeCount = 0;
		Connection conn = ConnectionUtil.getConn();
		String sql = "select DISTINCT UID from "+RemainUtil.getGameActiveTableName(DateUtil.getFormString(remain.getActiveBeginTime()))+" t where t.LOG_TIME >='"+remain.getActiveBeginTime()+"' and t.LOG_TIME<'"+remain.getActiveEndTime()+"' AND t.UID >= "+remain.getBeginUid()+" AND t.UID<="+remain.getEndUid()+" AND t.ACTIVE_TYPE = 2 and APP_KEY ="+remain.getAppKey();
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		ResultSet result = stmt2.executeQuery();
		while(result.next()){
			if(addSets.contains(result.getInt("uid"))){
				activeCount++;
				addSets.remove(result.getInt("uid"));
			}
		}
		result.close();
		stmt2.close();
		conn.close();
		return activeCount;
	}
	
	private Set<Integer> getAddSet(Remain remain) throws SQLException{
		Set<Integer> addSets = new HashSet<Integer>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select DISTINCT UID from "+RemainUtil.getGameActiveTableName(DateUtil.getFormString(remain.getAddBeginTime()))+" t where t.LOG_TIME >='"+remain.getAddBeginTime()+"' and t.LOG_TIME<'"+remain.getAddEndTIme()+"' AND t.UID >= "+remain.getBeginUid()+" AND t.UID<="+remain.getEndUid()+" AND t.ACTIVE_TYPE = 1 and APP_KEY ="+remain.getAppKey();
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		ResultSet result = stmt2.executeQuery();
		while(result.next()){
			addSets.add(result.getInt("uid"));
		}
		result.close();
		stmt2.close();
		conn.close();
		return addSets;
	}

}
