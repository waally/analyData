package com.wangli.data.analysis.ar.adc.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.wangli.data.analysis.ar.adc.dao.CorpOrderDAO;
import com.wangli.data.analysis.ar.adc.dao.DeviceAppAddInfoDAO;
import com.wangli.data.analysis.ar.adc.dao.FactAppAddStatDAO;
import com.wangli.data.analysis.ar.adc.dao.InstallAppLogDAO;
import com.wangli.data.analysis.ar.adc.module.CorpOrder;
import com.wangli.data.analysis.ar.adc.module.DeviceAppAddInfo;
import com.wangli.data.analysis.ar.adc.module.DeviceAppAddInfoExample;
import com.wangli.data.analysis.ar.adc.module.FactAppAddStat;
import com.wangli.data.analysis.ar.adc.module.FactAppAddStatExample;
import com.wangli.data.analysis.ar.adc.module.InstallAppLog;
import com.wangli.data.analysis.ar.adc.module.InstallAppLogExample;
import com.wangli.data.util.DateUtil;

@SuppressWarnings("unchecked")
public class AdcDataAnalysisServiceImpl implements AdcDataAnalysisService{

	private InstallAppLogDAO installAppLogDAO;
	private DeviceAppAddInfoDAO deviceAppAddInfoDAO;
	private CorpOrderDAO corpOrderDAO;
	private FactAppAddStatDAO factAppAddStatDAO;
	
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
		DeviceAppAddInfoExample example = new DeviceAppAddInfoExample();
		example.createCriteria().andInstallDateEqualTo(installDate).andOrderIdEqualTo(orderId)
		.andModelEqualTo(model).andIdentityIdEqualTo(identityId).andIdentityMarkEqualTo((byte)identityMark);
		return deviceAppAddInfoDAO.countByExample(example);
	}
	
	public DeviceAppAddInfo getDeviceApp(String mac,String imei,int orderId) throws SQLException{
		DeviceAppAddInfoExample example = new DeviceAppAddInfoExample();
		example.createCriteria().andMacEqualTo(mac).andImeiEqualTo(imei).andOrderIdEqualTo(orderId);
		List<DeviceAppAddInfo> list = deviceAppAddInfoDAO.selectByExample(example);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0); 
	}
	
	public List<DeviceAppAddInfo> getDeviceApps(Date receiveDate) throws SQLException{
		DeviceAppAddInfoExample example = new DeviceAppAddInfoExample();
		example.createCriteria().andReceiveDateEqualTo(DateUtil.getFormDate(receiveDate));
		return deviceAppAddInfoDAO.selectByExample(example);
	}
	
	public void insertDeviceApp(DeviceAppAddInfo da) throws SQLException{
		deviceAppAddInfoDAO.insert(da);
	}
	
	public void deleteDeviceApp(String receiveDate) throws SQLException{
		DeviceAppAddInfoExample example = new DeviceAppAddInfoExample();
		example.createCriteria().andReceiveDateEqualTo(receiveDate);
		deviceAppAddInfoDAO.deleteByExample(example);
	}
	
	public void updateDeviceApp(DeviceAppAddInfo da) throws SQLException{
		deviceAppAddInfoDAO.updateByPrimaryKey(da);
	}
	
	public FactAppAddStat getFactAppStat(String model,java.util.Date dataTime,int orderId,int identityId,int identityMark) throws SQLException{
		FactAppAddStatExample example = new FactAppAddStatExample();
		example.createCriteria().andDataTimeEqualTo(dataTime).andOrderIdEqualTo(orderId)
		.andIdentityIdEqualTo(identityId).andIdentityMarkEqualTo((byte)identityMark)
		.andModelEqualTo(model);
		List<FactAppAddStat> list = factAppAddStatDAO.selectByExample(example);
		if(list == null||list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
	public void insertFactAppStat(FactAppAddStat fAppStat) throws SQLException{
		factAppAddStatDAO.insert(fAppStat);
	}
	
	public void deleteFactAppStat(long id) throws SQLException{
		factAppAddStatDAO.deleteByPrimaryKey(id);
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

	public DeviceAppAddInfoDAO getDeviceAppAddInfoDAO() {
		return deviceAppAddInfoDAO;
	}

	public void setDeviceAppAddInfoDAO(DeviceAppAddInfoDAO deviceAppAddInfoDAO) {
		this.deviceAppAddInfoDAO = deviceAppAddInfoDAO;
	}

	public CorpOrderDAO getCorpOrderDAO() {
		return corpOrderDAO;
	}

	public void setCorpOrderDAO(CorpOrderDAO corpOrderDAO) {
		this.corpOrderDAO = corpOrderDAO;
	}

	public FactAppAddStatDAO getFactAppAddStatDAO() {
		return factAppAddStatDAO;
	}

	public void setFactAppAddStatDAO(FactAppAddStatDAO factAppAddStatDAO) {
		this.factAppAddStatDAO = factAppAddStatDAO;
	}
	
}
