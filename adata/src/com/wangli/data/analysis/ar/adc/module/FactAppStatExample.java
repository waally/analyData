package com.wangli.data.analysis.ar.adc.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FactAppStatExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public FactAppStatExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected FactAppStatExample(FactAppStatExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table fact_app_stat
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List dateList = new ArrayList();
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(((Date)iter.next()).getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
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

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
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

        public Criteria andDataTimeEqualTo(Date value) {
            addCriterionForJDBCDate("data_time =", value, "dataTime");
            return this;
        }

        public Criteria andDataTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("data_time <>", value, "dataTime");
            return this;
        }

        public Criteria andDataTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("data_time >", value, "dataTime");
            return this;
        }

        public Criteria andDataTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("data_time >=", value, "dataTime");
            return this;
        }

        public Criteria andDataTimeLessThan(Date value) {
            addCriterionForJDBCDate("data_time <", value, "dataTime");
            return this;
        }

        public Criteria andDataTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("data_time <=", value, "dataTime");
            return this;
        }

        public Criteria andDataTimeIn(List values) {
            addCriterionForJDBCDate("data_time in", values, "dataTime");
            return this;
        }

        public Criteria andDataTimeNotIn(List values) {
            addCriterionForJDBCDate("data_time not in", values, "dataTime");
            return this;
        }

        public Criteria andDataTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("data_time between", value1, value2, "dataTime");
            return this;
        }

        public Criteria andDataTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("data_time not between", value1, value2, "dataTime");
            return this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return this;
        }

        public Criteria andOrderIdIn(List values) {
            addCriterion("order_id in", values, "orderId");
            return this;
        }

        public Criteria andOrderIdNotIn(List values) {
            addCriterion("order_id not in", values, "orderId");
            return this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return this;
        }

        public Criteria andPkgIsNull() {
            addCriterion("pkg is null");
            return this;
        }

        public Criteria andPkgIsNotNull() {
            addCriterion("pkg is not null");
            return this;
        }

        public Criteria andPkgEqualTo(String value) {
            addCriterion("pkg =", value, "pkg");
            return this;
        }

        public Criteria andPkgNotEqualTo(String value) {
            addCriterion("pkg <>", value, "pkg");
            return this;
        }

        public Criteria andPkgGreaterThan(String value) {
            addCriterion("pkg >", value, "pkg");
            return this;
        }

        public Criteria andPkgGreaterThanOrEqualTo(String value) {
            addCriterion("pkg >=", value, "pkg");
            return this;
        }

        public Criteria andPkgLessThan(String value) {
            addCriterion("pkg <", value, "pkg");
            return this;
        }

        public Criteria andPkgLessThanOrEqualTo(String value) {
            addCriterion("pkg <=", value, "pkg");
            return this;
        }

        public Criteria andPkgLike(String value) {
            addCriterion("pkg like", value, "pkg");
            return this;
        }

        public Criteria andPkgNotLike(String value) {
            addCriterion("pkg not like", value, "pkg");
            return this;
        }

        public Criteria andPkgIn(List values) {
            addCriterion("pkg in", values, "pkg");
            return this;
        }

        public Criteria andPkgNotIn(List values) {
            addCriterion("pkg not in", values, "pkg");
            return this;
        }

        public Criteria andPkgBetween(String value1, String value2) {
            addCriterion("pkg between", value1, value2, "pkg");
            return this;
        }

        public Criteria andPkgNotBetween(String value1, String value2) {
            addCriterion("pkg not between", value1, value2, "pkg");
            return this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return this;
        }

        public Criteria andAppNameIn(List values) {
            addCriterion("app_name in", values, "appName");
            return this;
        }

        public Criteria andAppNameNotIn(List values) {
            addCriterion("app_name not in", values, "appName");
            return this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return this;
        }

        public Criteria andIdentityIdIsNull() {
            addCriterion("identity_id is null");
            return this;
        }

        public Criteria andIdentityIdIsNotNull() {
            addCriterion("identity_id is not null");
            return this;
        }

        public Criteria andIdentityIdEqualTo(Integer value) {
            addCriterion("identity_id =", value, "identityId");
            return this;
        }

        public Criteria andIdentityIdNotEqualTo(Integer value) {
            addCriterion("identity_id <>", value, "identityId");
            return this;
        }

        public Criteria andIdentityIdGreaterThan(Integer value) {
            addCriterion("identity_id >", value, "identityId");
            return this;
        }

        public Criteria andIdentityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("identity_id >=", value, "identityId");
            return this;
        }

        public Criteria andIdentityIdLessThan(Integer value) {
            addCriterion("identity_id <", value, "identityId");
            return this;
        }

        public Criteria andIdentityIdLessThanOrEqualTo(Integer value) {
            addCriterion("identity_id <=", value, "identityId");
            return this;
        }

        public Criteria andIdentityIdIn(List values) {
            addCriterion("identity_id in", values, "identityId");
            return this;
        }

        public Criteria andIdentityIdNotIn(List values) {
            addCriterion("identity_id not in", values, "identityId");
            return this;
        }

        public Criteria andIdentityIdBetween(Integer value1, Integer value2) {
            addCriterion("identity_id between", value1, value2, "identityId");
            return this;
        }

        public Criteria andIdentityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("identity_id not between", value1, value2, "identityId");
            return this;
        }

        public Criteria andIdentityMarkIsNull() {
            addCriterion("identity_mark is null");
            return this;
        }

        public Criteria andIdentityMarkIsNotNull() {
            addCriterion("identity_mark is not null");
            return this;
        }

        public Criteria andIdentityMarkEqualTo(Byte value) {
            addCriterion("identity_mark =", value, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkNotEqualTo(Byte value) {
            addCriterion("identity_mark <>", value, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkGreaterThan(Byte value) {
            addCriterion("identity_mark >", value, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkGreaterThanOrEqualTo(Byte value) {
            addCriterion("identity_mark >=", value, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkLessThan(Byte value) {
            addCriterion("identity_mark <", value, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkLessThanOrEqualTo(Byte value) {
            addCriterion("identity_mark <=", value, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkIn(List values) {
            addCriterion("identity_mark in", values, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkNotIn(List values) {
            addCriterion("identity_mark not in", values, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkBetween(Byte value1, Byte value2) {
            addCriterion("identity_mark between", value1, value2, "identityMark");
            return this;
        }

        public Criteria andIdentityMarkNotBetween(Byte value1, Byte value2) {
            addCriterion("identity_mark not between", value1, value2, "identityMark");
            return this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return this;
        }

        public Criteria andChannelIdIn(List values) {
            addCriterion("channel_id in", values, "channelId");
            return this;
        }

        public Criteria andChannelIdNotIn(List values) {
            addCriterion("channel_id not in", values, "channelId");
            return this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return this;
        }

        public Criteria andModelIn(List values) {
            addCriterion("model in", values, "model");
            return this;
        }

        public Criteria andModelNotIn(List values) {
            addCriterion("model not in", values, "model");
            return this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return this;
        }

        public Criteria andInstallCountIsNull() {
            addCriterion("install_count is null");
            return this;
        }

        public Criteria andInstallCountIsNotNull() {
            addCriterion("install_count is not null");
            return this;
        }

        public Criteria andInstallCountEqualTo(Integer value) {
            addCriterion("install_count =", value, "installCount");
            return this;
        }

        public Criteria andInstallCountNotEqualTo(Integer value) {
            addCriterion("install_count <>", value, "installCount");
            return this;
        }

        public Criteria andInstallCountGreaterThan(Integer value) {
            addCriterion("install_count >", value, "installCount");
            return this;
        }

        public Criteria andInstallCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("install_count >=", value, "installCount");
            return this;
        }

        public Criteria andInstallCountLessThan(Integer value) {
            addCriterion("install_count <", value, "installCount");
            return this;
        }

        public Criteria andInstallCountLessThanOrEqualTo(Integer value) {
            addCriterion("install_count <=", value, "installCount");
            return this;
        }

        public Criteria andInstallCountIn(List values) {
            addCriterion("install_count in", values, "installCount");
            return this;
        }

        public Criteria andInstallCountNotIn(List values) {
            addCriterion("install_count not in", values, "installCount");
            return this;
        }

        public Criteria andInstallCountBetween(Integer value1, Integer value2) {
            addCriterion("install_count between", value1, value2, "installCount");
            return this;
        }

        public Criteria andInstallCountNotBetween(Integer value1, Integer value2) {
            addCriterion("install_count not between", value1, value2, "installCount");
            return this;
        }

        public Criteria andActiveCountIsNull() {
            addCriterion("active_count is null");
            return this;
        }

        public Criteria andActiveCountIsNotNull() {
            addCriterion("active_count is not null");
            return this;
        }

        public Criteria andActiveCountEqualTo(Integer value) {
            addCriterion("active_count =", value, "activeCount");
            return this;
        }

        public Criteria andActiveCountNotEqualTo(Integer value) {
            addCriterion("active_count <>", value, "activeCount");
            return this;
        }

        public Criteria andActiveCountGreaterThan(Integer value) {
            addCriterion("active_count >", value, "activeCount");
            return this;
        }

        public Criteria andActiveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_count >=", value, "activeCount");
            return this;
        }

        public Criteria andActiveCountLessThan(Integer value) {
            addCriterion("active_count <", value, "activeCount");
            return this;
        }

        public Criteria andActiveCountLessThanOrEqualTo(Integer value) {
            addCriterion("active_count <=", value, "activeCount");
            return this;
        }

        public Criteria andActiveCountIn(List values) {
            addCriterion("active_count in", values, "activeCount");
            return this;
        }

        public Criteria andActiveCountNotIn(List values) {
            addCriterion("active_count not in", values, "activeCount");
            return this;
        }

        public Criteria andActiveCountBetween(Integer value1, Integer value2) {
            addCriterion("active_count between", value1, value2, "activeCount");
            return this;
        }

        public Criteria andActiveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("active_count not between", value1, value2, "activeCount");
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
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return this;
        }

        public Criteria andUserIdIn(List values) {
            addCriterion("user_id in", values, "userId");
            return this;
        }

        public Criteria andUserIdNotIn(List values) {
            addCriterion("user_id not in", values, "userId");
            return this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return this;
        }
    }
}