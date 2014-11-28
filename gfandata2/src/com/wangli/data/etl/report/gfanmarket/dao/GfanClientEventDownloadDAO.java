package com.wangli.data.etl.report.gfanmarket.dao;

import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventDownload;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventDownloadExample;
import java.sql.SQLException;
import java.util.List;

public interface GfanClientEventDownloadDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int countByExample(GfanClientEventDownloadExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int deleteByExample(GfanClientEventDownloadExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int deleteByPrimaryKey(Long id) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	void insert(GfanClientEventDownload record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	void insertSelective(GfanClientEventDownload record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	List selectByExampleWithBLOBs(GfanClientEventDownloadExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	List selectByExampleWithoutBLOBs(GfanClientEventDownloadExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	GfanClientEventDownload selectByPrimaryKey(Long id) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int updateByExampleSelective(GfanClientEventDownload record,
			GfanClientEventDownloadExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int updateByExampleWithBLOBs(GfanClientEventDownload record,
			GfanClientEventDownloadExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int updateByExampleWithoutBLOBs(GfanClientEventDownload record,
			GfanClientEventDownloadExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int updateByPrimaryKeySelective(GfanClientEventDownload record)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int updateByPrimaryKeyWithBLOBs(GfanClientEventDownload record)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table gfan_client_event_download
	 * @ibatorgenerated  Fri Nov 28 11:18:55 CST 2014
	 */
	int updateByPrimaryKeyWithoutBLOBs(GfanClientEventDownload record)
			throws SQLException;
}