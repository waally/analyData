package com.wangli.data.init;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wangli.data.datasource.ConnectionUtil;

public class DeleteDatas {

	public static void main(String[] args) throws SQLException {
		String[] tables = new String[]{"rep_game"};
//		String[] tables = new String[]{"consume_log","pay_log",
//				"log_player_active","log_player_game_active","fact_download","rep_game"};
		for(String table :tables){
			String sql = "DELETE from "+table;
			Connection conn = ConnectionUtil.getConn();
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.execute();
			stmt2.close();
			conn.close();
			System.out.println("已删除表:"+table);
		}
	}
}
