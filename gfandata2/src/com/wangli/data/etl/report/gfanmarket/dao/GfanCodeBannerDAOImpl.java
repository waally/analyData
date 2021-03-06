package com.wangli.data.etl.report.gfanmarket.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBanner;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBannerExample;
import java.sql.SQLException;
import java.util.List;

public class GfanCodeBannerDAOImpl implements GfanCodeBannerDAO {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    private SqlMapClient sqlMapClient;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public GfanCodeBannerDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public int countByExample(GfanCodeBannerExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("gfan_code_banner.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public int deleteByExample(GfanCodeBannerExample example) throws SQLException {
        int rows = sqlMapClient.delete("gfan_code_banner.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public void insert(GfanCodeBanner record) throws SQLException {
        sqlMapClient.insert("gfan_code_banner.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public void insertSelective(GfanCodeBanner record) throws SQLException {
        sqlMapClient.insert("gfan_code_banner.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public List selectByExample(GfanCodeBannerExample example) throws SQLException {
        List list = sqlMapClient.queryForList("gfan_code_banner.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public int updateByExampleSelective(GfanCodeBanner record, GfanCodeBannerExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("gfan_code_banner.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    public int updateByExample(GfanCodeBanner record, GfanCodeBannerExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("gfan_code_banner.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table gfan_code_banner
     *
     * @ibatorgenerated Tue Nov 25 10:22:39 CST 2014
     */
    private static class UpdateByExampleParms extends GfanCodeBannerExample {
        private Object record;

        public UpdateByExampleParms(Object record, GfanCodeBannerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}