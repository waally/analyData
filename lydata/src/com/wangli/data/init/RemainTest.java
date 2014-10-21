package com.wangli.data.init;

import java.sql.Date;

import com.wangli.data.analysis.RemainDataAnalysis;
import com.wangli.data.util.DateUtil;

public class RemainTest {

	public static void main(String[] args) {
		Date logTime = DateUtil.getLastDate(-2);
		RemainDataAnalysis remainDataAnalysis = new RemainDataAnalysis();
		remainDataAnalysis.dayRepGameRemain(logTime);
	}
}
