package com.wangli.data.etl.report.gfanmarket.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchHotwordsLogExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public SearchHotwordsLogExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	protected SearchHotwordsLogExample(SearchHotwordsLogExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table search_hotwords_log
	 * @ibatorgenerated  Thu Dec 11 19:28:48 CST 2014
	 */
	public static class Criteria {
		protected List criteriaWithoutValue;
		protected List criteriaWithSingleValue;
		protected List criteriaWithListValue;
		protected List criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList();
			criteriaWithSingleValue = new ArrayList();
			criteriaWithListValue = new ArrayList();
			criteriaWithBetweenValue = new ArrayList();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return this;
		}

		public Criteria andIdIn(List values) {
			addCriterion("id in", values, "id");
			return this;
		}

		public Criteria andIdNotIn(List values) {
			addCriterion("id not in", values, "id");
			return this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return this;
		}

		public Criteria andDataTimeIsNull() {
			addCriterion("data_time is null");
			return this;
		}

		public Criteria andDataTimeIsNotNull() {
			addCriterion("data_time is not null");
			return this;
		}

		public Criteria andDataTimeEqualTo(String value) {
			addCriterion("data_time =", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeNotEqualTo(String value) {
			addCriterion("data_time <>", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeGreaterThan(String value) {
			addCriterion("data_time >", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeGreaterThanOrEqualTo(String value) {
			addCriterion("data_time >=", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeLessThan(String value) {
			addCriterion("data_time <", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeLessThanOrEqualTo(String value) {
			addCriterion("data_time <=", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeLike(String value) {
			addCriterion("data_time like", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeNotLike(String value) {
			addCriterion("data_time not like", value, "dataTime");
			return this;
		}

		public Criteria andDataTimeIn(List values) {
			addCriterion("data_time in", values, "dataTime");
			return this;
		}

		public Criteria andDataTimeNotIn(List values) {
			addCriterion("data_time not in", values, "dataTime");
			return this;
		}

		public Criteria andDataTimeBetween(String value1, String value2) {
			addCriterion("data_time between", value1, value2, "dataTime");
			return this;
		}

		public Criteria andDataTimeNotBetween(String value1, String value2) {
			addCriterion("data_time not between", value1, value2, "dataTime");
			return this;
		}

		public Criteria andRankIsNull() {
			addCriterion("rank is null");
			return this;
		}

		public Criteria andRankIsNotNull() {
			addCriterion("rank is not null");
			return this;
		}

		public Criteria andRankEqualTo(Integer value) {
			addCriterion("rank =", value, "rank");
			return this;
		}

		public Criteria andRankNotEqualTo(Integer value) {
			addCriterion("rank <>", value, "rank");
			return this;
		}

		public Criteria andRankGreaterThan(Integer value) {
			addCriterion("rank >", value, "rank");
			return this;
		}

		public Criteria andRankGreaterThanOrEqualTo(Integer value) {
			addCriterion("rank >=", value, "rank");
			return this;
		}

		public Criteria andRankLessThan(Integer value) {
			addCriterion("rank <", value, "rank");
			return this;
		}

		public Criteria andRankLessThanOrEqualTo(Integer value) {
			addCriterion("rank <=", value, "rank");
			return this;
		}

		public Criteria andRankIn(List values) {
			addCriterion("rank in", values, "rank");
			return this;
		}

		public Criteria andRankNotIn(List values) {
			addCriterion("rank not in", values, "rank");
			return this;
		}

		public Criteria andRankBetween(Integer value1, Integer value2) {
			addCriterion("rank between", value1, value2, "rank");
			return this;
		}

		public Criteria andRankNotBetween(Integer value1, Integer value2) {
			addCriterion("rank not between", value1, value2, "rank");
			return this;
		}

		public Criteria andHotwordsIsNull() {
			addCriterion("hotwords is null");
			return this;
		}

		public Criteria andHotwordsIsNotNull() {
			addCriterion("hotwords is not null");
			return this;
		}

		public Criteria andHotwordsEqualTo(String value) {
			addCriterion("hotwords =", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsNotEqualTo(String value) {
			addCriterion("hotwords <>", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsGreaterThan(String value) {
			addCriterion("hotwords >", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsGreaterThanOrEqualTo(String value) {
			addCriterion("hotwords >=", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsLessThan(String value) {
			addCriterion("hotwords <", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsLessThanOrEqualTo(String value) {
			addCriterion("hotwords <=", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsLike(String value) {
			addCriterion("hotwords like", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsNotLike(String value) {
			addCriterion("hotwords not like", value, "hotwords");
			return this;
		}

		public Criteria andHotwordsIn(List values) {
			addCriterion("hotwords in", values, "hotwords");
			return this;
		}

		public Criteria andHotwordsNotIn(List values) {
			addCriterion("hotwords not in", values, "hotwords");
			return this;
		}

		public Criteria andHotwordsBetween(String value1, String value2) {
			addCriterion("hotwords between", value1, value2, "hotwords");
			return this;
		}

		public Criteria andHotwordsNotBetween(String value1, String value2) {
			addCriterion("hotwords not between", value1, value2, "hotwords");
			return this;
		}

		public Criteria andInsertTimeIsNull() {
			addCriterion("insert_time is null");
			return this;
		}

		public Criteria andInsertTimeIsNotNull() {
			addCriterion("insert_time is not null");
			return this;
		}

		public Criteria andInsertTimeEqualTo(Date value) {
			addCriterion("insert_time =", value, "insertTime");
			return this;
		}

		public Criteria andInsertTimeNotEqualTo(Date value) {
			addCriterion("insert_time <>", value, "insertTime");
			return this;
		}

		public Criteria andInsertTimeGreaterThan(Date value) {
			addCriterion("insert_time >", value, "insertTime");
			return this;
		}

		public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("insert_time >=", value, "insertTime");
			return this;
		}

		public Criteria andInsertTimeLessThan(Date value) {
			addCriterion("insert_time <", value, "insertTime");
			return this;
		}

		public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
			addCriterion("insert_time <=", value, "insertTime");
			return this;
		}

		public Criteria andInsertTimeIn(List values) {
			addCriterion("insert_time in", values, "insertTime");
			return this;
		}

		public Criteria andInsertTimeNotIn(List values) {
			addCriterion("insert_time not in", values, "insertTime");
			return this;
		}

		public Criteria andInsertTimeBetween(Date value1, Date value2) {
			addCriterion("insert_time between", value1, value2, "insertTime");
			return this;
		}

		public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
			addCriterion("insert_time not between", value1, value2,
					"insertTime");
			return this;
		}
	}
}