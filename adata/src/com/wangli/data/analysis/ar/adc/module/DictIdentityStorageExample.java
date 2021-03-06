package com.wangli.data.analysis.ar.adc.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictIdentityStorageExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    public DictIdentityStorageExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    protected DictIdentityStorageExample(DictIdentityStorageExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
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
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table dict_identity_storage
     *
     * @ibatorgenerated Tue Nov 11 19:45:22 CST 2014
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

        public Criteria andStorageIdIsNull() {
            addCriterion("storage_id is null");
            return this;
        }

        public Criteria andStorageIdIsNotNull() {
            addCriterion("storage_id is not null");
            return this;
        }

        public Criteria andStorageIdEqualTo(Integer value) {
            addCriterion("storage_id =", value, "storageId");
            return this;
        }

        public Criteria andStorageIdNotEqualTo(Integer value) {
            addCriterion("storage_id <>", value, "storageId");
            return this;
        }

        public Criteria andStorageIdGreaterThan(Integer value) {
            addCriterion("storage_id >", value, "storageId");
            return this;
        }

        public Criteria andStorageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_id >=", value, "storageId");
            return this;
        }

        public Criteria andStorageIdLessThan(Integer value) {
            addCriterion("storage_id <", value, "storageId");
            return this;
        }

        public Criteria andStorageIdLessThanOrEqualTo(Integer value) {
            addCriterion("storage_id <=", value, "storageId");
            return this;
        }

        public Criteria andStorageIdIn(List values) {
            addCriterion("storage_id in", values, "storageId");
            return this;
        }

        public Criteria andStorageIdNotIn(List values) {
            addCriterion("storage_id not in", values, "storageId");
            return this;
        }

        public Criteria andStorageIdBetween(Integer value1, Integer value2) {
            addCriterion("storage_id between", value1, value2, "storageId");
            return this;
        }

        public Criteria andStorageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_id not between", value1, value2, "storageId");
            return this;
        }
    }
}