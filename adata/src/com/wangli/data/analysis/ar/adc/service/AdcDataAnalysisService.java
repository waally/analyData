package com.wangli.data.analysis.ar.adc.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.wangli.data.analysis.ar.adc.module.CorpOrder;
import com.wangli.data.analysis.ar.adc.module.DeviceAppInfo;
import com.wangli.data.analysis.ar.adc.module.FactAppStat;
import com.wangli.data.analysis.ar.adc.module.InstallAppLog;

public interface AdcDataAnalysisService {

	/**
	 * 根据日期从installAppLog表中获取当天接受的新增数据
	 * @param date 新增信息接收时间
	 * @return
	 * @throws SQLException
	 */
	int getInstallCount(Date date) throws SQLException;
	/**
	 * 根据日期和起始位置从installAppLog表中获取当天接受的新增数据
	 * @param date 新增信息接收时间
	 * @param start 开始位置
	 * @param length 长度
	 * @return
	 * @throws SQLException
	 */
	List<InstallAppLog> getInstallList(Date date,int start,int length) throws SQLException;
	/**
	 * 获取当前条件下的新增的总数
	 * @param installDate 安装日期
	 * @param model 手机型号
	 * @param orderId 订单号
	 * @param identityId PC/BOX身份编号
	 * @param identityMark PC/BOX身份区分
	 * @return
	 * @throws SQLException
	 */
	int getDeviceAppCount(String installDate,String model,int orderId,int identityId,int identityMark) throws SQLException;
	/**
	 * 获取设备应用信息
	 * @param imei 移动设备唯一编号
	 * @param orderId 订单编号
	 * @return
	 * @throws SQLException
	 */
	DeviceAppInfo getDeviceApp(String imei,int orderId) throws SQLException;
	/**
	 * 根据日期获取接收日期是当天的所有的设备应用信息
	 * @param receiveDate 接收日期
	 * @return
	 * @throws SQLException
	 */
	List<DeviceAppInfo> getDeviceApps(Date receiveDate) throws SQLException;
	/**
	 * 插入设备应用信息到数据库
	 * @param da 设备应用信息
	 * @throws SQLException
	 */
	void insertDeviceApp(DeviceAppInfo da) throws SQLException;
	/**
	 * 根据日期删除接收日期是当天的所有的设备应用信息
	 * @param receiveDate 接收日期
	 * @throws SQLException
	 */
	void deleteDeviceApp(String receiveDate) throws SQLException;
	/**
	 * 更新设备应用信息到数据库
	 * @param da 设备应用信息
	 * @throws SQLException
	 */
	void updateDeviceApp(DeviceAppInfo da) throws SQLException;
	/**
	 * 获取应用新增的信息
	 * @param model
	 * @param dataTime
	 * @param orderId
	 * @param identityId
	 * @param identityMark
	 * @return
	 * @throws SQLException
	 */
	FactAppStat getFactAppStat(String model,java.util.Date dataTime,int orderId,int identityId,int identityMark) throws SQLException;
	/**
	 * 插入应用新增的信息到数据库
	 * @param fAppStat
	 * @throws SQLException
	 */
	void insertFactAppStat(FactAppStat fAppStat) throws SQLException;
	/**
	 * 根据主键删除应用新增的信息
	 * @param id
	 * @throws SQLException
	 */
	void deleteFactAppStat(long id) throws SQLException;
	/**
	 * 根据主键获取订单信息
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	CorpOrder getCorpOrder(int orderId) throws SQLException;
	
}
