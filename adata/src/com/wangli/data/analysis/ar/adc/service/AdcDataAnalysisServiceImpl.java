package com.wangli.data.analysis.ar.adc.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.wangli.data.analysis.ar.adc.dao.CorpOrderDAO;
import com.wangli.data.analysis.ar.adc.dao.DeviceAppInfoDAO;
import com.wangli.data.analysis.ar.adc.dao.FactAppStatDAO;
import com.wangli.data.analysis.ar.adc.dao.InstallAppLogDAO;
import com.wangli.data.analysis.ar.adc.module.CorpOrder;
import com.wangli.data.analysis.ar.adc.module.DeviceAppInfo;
import com.wangli.data.analysis.ar.adc.module.DeviceAppInfoExample;
import com.wangli.data.analysis.ar.adc.module.FactAppStat;
import com.wangli.data.analysis.ar.adc.module.FactAppStatExample;
import com.wangli.data.analysis.ar.adc.module.InstallAppLog;
import com.wangli.data.analysis.ar.adc.module.InstallAppLogExample;
import com.wangli.data.util.DateUtil;

@SuppressWarnings("unchecked")
public class AdcDataAnalysisServiceImpl implements AdcDataAnalysisService{

	private InstallAppLogDAO installAppLogDAO;
	private DeviceAppInfoDAO deviceAppInfoDAO;
	private CorpOrderDAO corpOrderDAO;
	private FactAppStatDAO factAppStatDAO;
	
	public int getInstallCount(Date date) throws SQLException{
		InstallAppLogExample example = new InstallAppLogExample();
		example.createCriteria().andCreateTimeGreaterThanOrEqualTo(date).andCreateTimeLessThan(DateUtil.getLastDate(date, 1))
		.andCodeEqualTo((byte) 0).andApkTagChannelIsNotNull();
		return installAppLogDAO.countByExample(example);
	}
	
	public List<InstallAppLog> getInstallList(Date date,int start,int length) throws SQLException{
		InstallAppLogExample example = new InstallAppLogExample();
		example.createCriteria().andCreateTimeGreaterThanOrEqualTo(date).andCreateTimeLessThan(DateUtil.getLastDate(date, 1))
		.andCodeEqualTo((byte) 0).andApkTagChannelIsNotNull();
		return installAppLogDAO.selectByExampleWithoutBLOBs(example,start,length);
	}
	
	public int getDeviceAppCount(String installDate,String model,int orderId,int identityId,int identityMark) throws SQLException{
		DeviceAppInfoExample example = new DeviceAppInfoExample();
		example.createCriteria().andInstallDateEqualTo(installDate).andOrderIdEqualTo(orderId)
		.andModelEqualTo(model).andIdentityIdEqualTo(identityId).andIdentityMarkEqualTo((byte)identityMark);
		return deviceAppInfoDAO.countByExample(example);
	}
	
	public DeviceAppInfo getDeviceApp(String mac,String imei,int orderId) throws SQLException{
		DeviceAppInfoExample example = new DeviceAppInfoExample();
		example.createCriteria().andMacEqualTo(mac).andImeiEqualTo(imei).andOrderIdEqualTo(orderId);
		List<DeviceAppInfo> list = deviceAppInfoDAO.selectByExample(example);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0); 
	}
	
	public List<DeviceAppInfo> getDeviceApps(Date receiveDate) throws SQLException{
		DeviceAppInfoExample example = new DeviceAppInfoExample();
		example.createCriteria().andReceiveDateEqualTo(DateUtil.getFormDate(receiveDate));
		return deviceAppInfoDAO.selectByExample(example);
	}
	
	public void insertDeviceApp(DeviceAppInfo da) throws SQLException{
		deviceAppInfoDAO.insert(da);
	}
	
	public void deleteDeviceApp(String receiveDate) throws SQLException{
		DeviceAppInfoExample example = new DeviceAppInfoExample();
		example.createCriteria().andReceiveDateEqualTo(receiveDate);
		deviceAppInfoDAO.deleteByExample(example);
	}
	
	public void updateDeviceApp(DeviceAppInfo da) throws SQLException{
		deviceAppInfoDAO.updateByPrimaryKey(da);
	}
	
	public FactAppStat getFactAppStat(String model,java.util.Date dataTime,int orderId,int identityId,int identityMark) throws SQLException{
		FactAppStatExample example = new FactAppStatExample();
		example.createCriteria().andDataTimeEqualTo(dataTime).andOrderIdEqualTo(orderId)
		.andIdentityIdEqualTo(identityId).andIdentityMarkEqualTo((byte)identityMark)
		.andModelEqualTo(model);
		List<FactAppStat> list = factAppStatDAO.selectByExample(example);
		if(list == null||list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
	public void insertFactAppStat(FactAppStat fAppStat) throws SQLException{
		factAppStatDAO.insert(fAppStat);
	}
	
	public void deleteFactAppStat(long id) throws SQLException{
		factAppStatDAO.deleteByPrimaryKey(id);
	}
	
	public CorpOrder getCorpOrder(int orderId) throws SQLException{
		CorpOrder order = corpOrderDAO.selectByPrimaryKey(orderId);
		if(order==null){
			return null;
		}
		return order;
	}
	
	
	
	public InstallAppLogDAO getInstallAppLogDAO() {
		return installAppLogDAO;
	}

	public void setInstallAppLogDAO(InstallAppLogDAO installAppLogDAO) {
		this.installAppLogDAO = installAppLogDAO;
	}

	public DeviceAppInfoDAO getDeviceAppInfoDAO() {
		return deviceAppInfoDAO;
	}

	public void setDeviceAppInfoDAO(DeviceAppInfoDAO deviceAppInfoDAO) {
		this.deviceAppInfoDAO = deviceAppInfoDAO;
	}

	public CorpOrderDAO getCorpOrderDAO() {
		return corpOrderDAO;
	}

	public void setCorpOrderDAO(CorpOrderDAO corpOrderDAO) {
		this.corpOrderDAO = corpOrderDAO;
	}

	public FactAppStatDAO getFactAppStatDAO() {
		return factAppStatDAO;
	}

	public void setFactAppStatDAO(FactAppStatDAO factAppStatDAO) {
		this.factAppStatDAO = factAppStatDAO;
	}
	
}
