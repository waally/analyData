package com.wangli.data.sprocedure;
/**
 * 
 * @ClassName Call
 * @Description 用来描述存储过程对象
 * @author wangli
 * @date 2014-8-4 下午6:37:57
 */
public class Call {

	private int callType;
	
	private String callName;

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public String getCallName() {
		return callName;
	}

	public void setCallName(String callName) {
		this.callName = callName;
	}
	
}
