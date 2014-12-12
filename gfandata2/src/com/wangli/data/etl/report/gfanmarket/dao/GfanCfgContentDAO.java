package com.wangli.data.etl.report.gfanmarket.dao;

import com.wangli.data.etl.report.gfanmarket.module.GfanCfgContent;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgContentExample;
import java.sql.SQLException;
import java.util.List;

public interface GfanCfgContentDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int countByExample(GfanCfgContentExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int deleteByExample(GfanCfgContentExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int deleteByPrimaryKey(Integer id) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    void insert(GfanCfgContent record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    void insertSelective(GfanCfgContent record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    List selectByExample(GfanCfgContentExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    GfanCfgContent selectByPrimaryKey(Integer id) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int updateByExampleSelective(GfanCfgContent record, GfanCfgContentExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int updateByExample(GfanCfgContent record, GfanCfgContentExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int updateByPrimaryKeySelective(GfanCfgContent record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_cfg_content
     *
     * @ibatorgenerated Tue Dec 09 16:44:18 CST 2014
     */
    int updateByPrimaryKey(GfanCfgContent record) throws SQLException;
}