package com.wangli.data.etl.report.gfanmarket.dao;

import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventBannerclick;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventBannerclickExample;
import java.sql.SQLException;
import java.util.List;

public interface GfanClientEventBannerclickDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int countByExample(GfanClientEventBannerclickExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int deleteByExample(GfanClientEventBannerclickExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int deleteByPrimaryKey(Long id) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	void insert(GfanClientEventBannerclick record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	void insertSelective(GfanClientEventBannerclick record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	List selectByExampleWithBLOBs(GfanClientEventBannerclickExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	List selectByExampleWithoutBLOBs(GfanClientEventBannerclickExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	GfanClientEventBannerclick selectByPrimaryKey(Long id) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int updateByExampleSelective(GfanClientEventBannerclick record,
			GfanClientEventBannerclickExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int updateByExampleWithBLOBs(GfanClientEventBannerclick record,
			GfanClientEventBannerclickExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int updateByExampleWithoutBLOBs(GfanClientEventBannerclick record,
			GfanClientEventBannerclickExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int updateByPrimaryKeySelective(GfanClientEventBannerclick record)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int updateByPrimaryKeyWithBLOBs(GfanClientEventBannerclick record)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_bannerclick
	 * @ibatorgenerated  Fri Nov 28 11:13:57 CST 2014
	 */
	int updateByPrimaryKeyWithoutBLOBs(GfanClientEventBannerclick record)
			throws SQLException;
}