package com.wangli.data.etl.report.gfanmarket.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wangli.data.etl.report.gfanmarket.module.SearchHotwordsLog;
import com.wangli.data.etl.report.gfanmarket.module.SearchHotwordsLogExample;
import java.sql.SQLException;
import java.util.List;

public class SearchHotwordsLogDAOImpl implements SearchHotwordsLogDAO {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public SearchHotwordsLogDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public int countByExample(SearchHotwordsLogExample example)
			throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"search_hotwords_log.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public int deleteByExample(SearchHotwordsLogExample example)
			throws SQLException {
		int rows = sqlMapClient.delete(
				"search_hotwords_log.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public void insert(SearchHotwordsLog record) throws SQLException {
		sqlMapClient.insert("search_hotwords_log.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public void insertSelective(SearchHotwordsLog record) throws SQLException {
		sqlMapClient.insert(
				"search_hotwords_log.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public List selectByExample(SearchHotwordsLogExample example)
			throws SQLException {
		List list = sqlMapClient.queryForList(
				"search_hotwords_log.ibatorgenerated_selectByExample", example);
		return list;
	}
	
	public List selectHotWordsReplaceByExample(SearchHotwordsLogExample example)
			throws SQLException {
		List list = sqlMapClient.queryForList(
				"search_hotwords_log.ibatorgenerated_selectHotWordsReplaceByExample", example);
		return list;
	}
	
	public List selectHotWordsAllByExample(SearchHotwordsLogExample example)
			throws SQLException {
		List list = sqlMapClient.queryForList(
				"search_hotwords_log.ibatorgenerated_selectHotWordsAllByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public int updateByExampleSelective(SearchHotwordsLog record,
			SearchHotwordsLogExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"search_hotwords_log.ibatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public int updateByExample(SearchHotwordsLog record,
			SearchHotwordsLogExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"search_hotwords_log.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	private static class UpdateByExampleParms extends SearchHotwordsLogExample {
		private Object record;

		public UpdateByExampleParms(Object record,
				SearchHotwordsLogExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}