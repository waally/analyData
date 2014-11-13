package com.wangli.data.analysis.ar.adc.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wangli.data.analysis.ar.adc.module.DeviceAppAddInfo;
import com.wangli.data.analysis.ar.adc.module.DeviceAppAddInfoExample;
import java.sql.SQLException;
import java.util.List;

public class DeviceAppAddInfoDAOImpl implements DeviceAppAddInfoDAO {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    private SqlMapClient sqlMapClient;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public DeviceAppAddInfoDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int countByExample(DeviceAppAddInfoExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("device_app_add_info.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int deleteByExample(DeviceAppAddInfoExample example) throws SQLException {
        int rows = sqlMapClient.delete("device_app_add_info.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int deleteByPrimaryKey(Long id) throws SQLException {
        DeviceAppAddInfo key = new DeviceAppAddInfo();
        key.setId(id);
        int rows = sqlMapClient.delete("device_app_add_info.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public void insert(DeviceAppAddInfo record) throws SQLException {
        sqlMapClient.insert("device_app_add_info.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public void insertSelective(DeviceAppAddInfo record) throws SQLException {
        sqlMapClient.insert("device_app_add_info.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public List selectByExample(DeviceAppAddInfoExample example) throws SQLException {
        List list = sqlMapClient.queryForList("device_app_add_info.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public DeviceAppAddInfo selectByPrimaryKey(Long id) throws SQLException {
        DeviceAppAddInfo key = new DeviceAppAddInfo();
        key.setId(id);
        DeviceAppAddInfo record = (DeviceAppAddInfo) sqlMapClient.queryForObject("device_app_add_info.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int updateByExampleSelective(DeviceAppAddInfo record, DeviceAppAddInfoExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("device_app_add_info.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int updateByExample(DeviceAppAddInfo record, DeviceAppAddInfoExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("device_app_add_info.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int updateByPrimaryKeySelective(DeviceAppAddInfo record) throws SQLException {
        int rows = sqlMapClient.update("device_app_add_info.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    public int updateByPrimaryKey(DeviceAppAddInfo record) throws SQLException {
        int rows = sqlMapClient.update("device_app_add_info.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table device_app_add_info
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    private static class UpdateByExampleParms extends DeviceAppAddInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DeviceAppAddInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}