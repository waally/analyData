package com.wangli.data.etl.report.gfanmarket.dao;

import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBanner;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBannerExample;
import java.sql.SQLException;
import java.util.List;

public interface GfanCodeBannerDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    int countByExample(GfanCodeBannerExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    int deleteByExample(GfanCodeBannerExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    void insert(GfanCodeBanner record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    void insertSelective(GfanCodeBanner record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    List selectByExample(GfanCodeBannerExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    int updateByExampleSelective(GfanCodeBanner record, GfanCodeBannerExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    int updateByExample(GfanCodeBanner record, GfanCodeBannerExample example) throws SQLException;
}