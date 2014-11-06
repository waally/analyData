package com.wangli.data.gfan.analysis.dao;

public class QueryCount {

	public static int length = 10000;
	
	private int startIndex;
	
	private int endIndex;

	public QueryCount(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
