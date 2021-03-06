package com.wangli.data.analysis.ar.adc.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceAppInfoExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public DeviceAppInfoExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected DeviceAppInfoExample(DeviceAppInfoExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
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
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device_app_info
     *
     * @ibatorgenerated Mon Nov 17 10:52:28 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table device_app_info
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

        public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
            return this;
        }

        public Criteria andImeiIn(List values) {
            addCriterion("imei in", values, "imei");
            return this;
        }

        public Criteria andImeiNotIn(List values) {
            addCriterion("imei not in", values, "imei");
            return this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
            return this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return this;
        }

        public Criteria andMacIn(List values) {
            addCriterion("mac in", values, "mac");
            return this;
        }

        public Criteria andMacNotIn(List values) {
            addCriterion("mac not in", values, "mac");
            return this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
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

        public Criteria andInstallDateIsNull() {
            addCriterion("install_date is null");
            return this;
        }

        public Criteria andInstallDateIsNotNull() {
            addCriterion("install_date is not null");
            return this;
        }

        public Criteria andInstallDateEqualTo(String value) {
            addCriterion("install_date =", value, "installDate");
            return this;
        }

        public Criteria andInstallDateNotEqualTo(String value) {
            addCriterion("install_date <>", value, "installDate");
            return this;
        }

        public Criteria andInstallDateGreaterThan(String value) {
            addCriterion("install_date >", value, "installDate");
            return this;
        }

        public Criteria andInstallDateGreaterThanOrEqualTo(String value) {
            addCriterion("install_date >=", value, "installDate");
            return this;
        }

        public Criteria andInstallDateLessThan(String value) {
            addCriterion("install_date <", value, "installDate");
            return this;
        }

        public Criteria andInstallDateLessThanOrEqualTo(String value) {
            addCriterion("install_date <=", value, "installDate");
            return this;
        }

        public Criteria andInstallDateLike(String value) {
            addCriterion("install_date like", value, "installDate");
            return this;
        }

        public Criteria andInstallDateNotLike(String value) {
            addCriterion("install_date not like", value, "installDate");
            return this;
        }

        public Criteria andInstallDateIn(List values) {
            addCriterion("install_date in", values, "installDate");
            return this;
        }

        public Criteria andInstallDateNotIn(List values) {
            addCriterion("install_date not in", values, "installDate");
            return this;
        }

        public Criteria andInstallDateBetween(String value1, String value2) {
            addCriterion("install_date between", value1, value2, "installDate");
            return this;
        }

        public Criteria andInstallDateNotBetween(String value1, String value2) {
            addCriterion("install_date not between", value1, value2, "installDate");
            return this;
        }

        public Criteria andInstallTimeIsNull() {
            addCriterion("install_time is null");
            return this;
        }

        public Criteria andInstallTimeIsNotNull() {
            addCriterion("install_time is not null");
            return this;
        }

        public Criteria andInstallTimeEqualTo(Date value) {
            addCriterion("install_time =", value, "installTime");
            return this;
        }

        public Criteria andInstallTimeNotEqualTo(Date value) {
            addCriterion("install_time <>", value, "installTime");
            return this;
        }

        public Criteria andInstallTimeGreaterThan(Date value) {
            addCriterion("install_time >", value, "installTime");
            return this;
        }

        public Criteria andInstallTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("install_time >=", value, "installTime");
            return this;
        }

        public Criteria andInstallTimeLessThan(Date value) {
            addCriterion("install_time <", value, "installTime");
            return this;
        }

        public Criteria andInstallTimeLessThanOrEqualTo(Date value) {
            addCriterion("install_time <=", value, "installTime");
            return this;
        }

        public Criteria andInstallTimeIn(List values) {
            addCriterion("install_time in", values, "installTime");
            return this;
        }

        public Criteria andInstallTimeNotIn(List values) {
            addCriterion("install_time not in", values, "installTime");
            return this;
        }

        public Criteria andInstallTimeBetween(Date value1, Date value2) {
            addCriterion("install_time between", value1, value2, "installTime");
            return this;
        }

        public Criteria andInstallTimeNotBetween(Date value1, Date value2) {
            addCriterion("install_time not between", value1, value2, "installTime");
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

        public Criteria andReceiveDateIsNull() {
            addCriterion("receive_date is null");
            return this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("receive_date is not null");
            return this;
        }

        public Criteria andReceiveDateEqualTo(String value) {
            addCriterion("receive_date =", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotEqualTo(String value) {
            addCriterion("receive_date <>", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateGreaterThan(String value) {
            addCriterion("receive_date >", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("receive_date >=", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateLessThan(String value) {
            addCriterion("receive_date <", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(String value) {
            addCriterion("receive_date <=", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateLike(String value) {
            addCriterion("receive_date like", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotLike(String value) {
            addCriterion("receive_date not like", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateIn(List values) {
            addCriterion("receive_date in", values, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotIn(List values) {
            addCriterion("receive_date not in", values, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateBetween(String value1, String value2) {
            addCriterion("receive_date between", value1, value2, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotBetween(String value1, String value2) {
            addCriterion("receive_date not between", value1, value2, "receiveDate");
            return this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return this;
        }

        public Criteria andStatusIn(List values) {
            addCriterion("status in", values, "status");
            return this;
        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("status not in", values, "status");
            return this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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
    }
}