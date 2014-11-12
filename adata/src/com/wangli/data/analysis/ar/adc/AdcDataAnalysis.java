package com.wangli.data.analysis.ar.adc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wangli.data.analysis.DataAnalysis;
import com.wangli.data.analysis.ar.adc.module.DeviceAppInfo;
import com.wangli.data.analysis.ar.adc.module.FactAppStat;
import com.wangli.data.analysis.ar.adc.module.InstallAppLog;
import com.wangli.data.analysis.ar.adc.service.AdcDataAnalysisService;
import com.wangli.data.util.DateUtil;

public class AdcDataAnalysis implements DataAnalysis{

	private Date date;
	
	private static final int maxLength = 1000;
	
	private AdcDataAnalysisService adcDataAnalysisService;
	
	@Override
	public int getAnalysisType() {
		return 0;
	}

	@Override
	public void processAnalysis() {
		try {
			int addCount = handleInstall();
			int addStart = 0;
			adcDataAnalysisService.deleteDeviceApp(DateUtil.getFormDate(date));
			while(addStart<addCount){
				handleInstall(addStart,maxLength);
				addStart+=maxLength;
			}
			handleEnd();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取所有的新增数据
	 * @return
	 * @throws SQLException
	 */
	private int handleInstall() throws SQLException{
		return adcDataAnalysisService.getInstallCount(date);
	}
	/**
	 * 分批处理新增数据
	 * @param start
	 * @param length
	 * @throws SQLException
	 */
	private void handleInstall(int start,int length) throws SQLException{
		List<InstallAppLog> list = adcDataAnalysisService.getInstallList(date, start, length);
		for(InstallAppLog install : list){
			DeviceAppInfo da = new DeviceAppInfo();
			da.setImei(install.getImei());
			da.setMac(install.getMac());
			da.setOrderId(install.getOrderId());
			DeviceAppInfo temp = adcDataAnalysisService.getDeviceApp(da.getMac(),da.getImei(),da.getOrderId());
			if(temp==null){
				if(install.getClientName().equals("gfan.assistant.box")){
					da.setIdentityId(install.getTagId());
					da.setIdentityMark((byte) 1);
				}else{
					da.setIdentityId(install.getUserId());
					da.setIdentityMark((byte) 2);
				}
				da.setStatus(1);
				da.setPkg(install.getPkg());
				da.setInstallTime(install.getInstallTime());
				da.setInstallDate(DateUtil.getFormDate(da.getInstallTime()));
				da.setChannelId(install.getChannelId());
				da.setInsertTime(new java.util.Date());
				da.setReceiveDate(DateUtil.getFormDate(install.getCreateTime()));
				da.setModel(install.getModel());
				da.setUserId(install.getUserId());
				adcDataAnalysisService.insertDeviceApp(da);
			}else if(temp.getStatus() == 2){
				temp.setStatus(3);
				adcDataAnalysisService.updateDeviceApp(temp);
			}
		}
	}
	/**
	 * 维护应用信息表的新增数据
	 * @throws SQLException
	 */
	private void handleEnd() throws SQLException{
		List<DeviceAppInfo> list = adcDataAnalysisService.getDeviceApps(date);
		Map<String,DeviceAppInfo> map = new HashMap<String,DeviceAppInfo>();
		for(DeviceAppInfo da : list){
			String key = da.getInstallDate()+","+da.getOrderId()+","+da.getIdentityId()+"," +da.getIdentityMark()+","+da.getModel();
			map.put(key, da);
		}
		for(DeviceAppInfo da : map.values()){
			int installCount = adcDataAnalysisService.getDeviceAppCount(da.getInstallDate(),da.getModel(),da.getOrderId(),da.getIdentityId(),da.getIdentityMark());
			FactAppStat fAppStat = new FactAppStat();
			fAppStat.setDataTime(DateUtil.getFormString(da.getInstallDate()));
			fAppStat.setModel(da.getModel());
			fAppStat.setIdentityId(da.getIdentityId());
			fAppStat.setIdentityMark(da.getIdentityMark());
			fAppStat.setOrderId(da.getOrderId());
			FactAppStat temp = adcDataAnalysisService.getFactAppStat(fAppStat.getModel(),fAppStat.getDataTime(),fAppStat.getOrderId(),fAppStat.getIdentityId(),fAppStat.getIdentityMark());
			fAppStat.setInstallCount(installCount);
			fAppStat.setPkg(da.getPkg());
			fAppStat.setAppName(adcDataAnalysisService.getCorpOrder(fAppStat.getOrderId()).getOrderName());
			fAppStat.setChannelId(da.getChannelId());
			fAppStat.setUserId(da.getUserId());
			fAppStat.setInsertTime(DateUtil.getLastDate(0));
			if(temp!=null){
				adcDataAnalysisService.deleteFactAppStat(temp.getId());
			}
			adcDataAnalysisService.insertFactAppStat(fAppStat);
		}
	}
	
	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	public AdcDataAnalysisService getAdcDataAnalysisService() {
		return adcDataAnalysisService;
	}

	public void setAdcDataAnalysisService(
			AdcDataAnalysisService adcDataAnalysisService) {
		this.adcDataAnalysisService = adcDataAnalysisService;
	}
	
}
