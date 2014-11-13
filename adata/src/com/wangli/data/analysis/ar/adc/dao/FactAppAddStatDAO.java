package com.wangli.data.analysis.ar.adc.dao;

import com.wangli.data.analysis.ar.adc.module.FactAppAddStat;
import com.wangli.data.analysis.ar.adc.module.FactAppAddStatExample;
import java.sql.SQLException;
import java.util.List;

public interface FactAppAddStatDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int countByExample(FactAppAddStatExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int deleteByExample(FactAppAddStatExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int deleteByPrimaryKey(Long id) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    void insert(FactAppAddStat record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    void insertSelective(FactAppAddStat record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    List selectByExample(FactAppAddStatExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    FactAppAddStat selectByPrimaryKey(Long id) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int updateByExampleSelective(FactAppAddStat record, FactAppAddStatExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int updateByExample(FactAppAddStat record, FactAppAddStatExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int updateByPrimaryKeySelective(FactAppAddStat record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_add_stat
     *
     * @ibatorgenerated Thu Nov 13 10:39:11 CST 2014
     */
    int updateByPrimaryKey(FactAppAddStat record) throws SQLException;
}