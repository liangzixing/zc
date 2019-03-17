package com.zc.biz.logistics.domain.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbnormalLocOrderDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbnormalLocOrderDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andReporterIsNull() {
            addCriterion("reporter is null");
            return (Criteria) this;
        }

        public Criteria andReporterIsNotNull() {
            addCriterion("reporter is not null");
            return (Criteria) this;
        }

        public Criteria andReporterEqualTo(String value) {
            addCriterion("reporter =", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotEqualTo(String value) {
            addCriterion("reporter <>", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterGreaterThan(String value) {
            addCriterion("reporter >", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterGreaterThanOrEqualTo(String value) {
            addCriterion("reporter >=", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLessThan(String value) {
            addCriterion("reporter <", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLessThanOrEqualTo(String value) {
            addCriterion("reporter <=", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLike(String value) {
            addCriterion("reporter like", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotLike(String value) {
            addCriterion("reporter not like", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterIn(List<String> values) {
            addCriterion("reporter in", values, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotIn(List<String> values) {
            addCriterion("reporter not in", values, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterBetween(String value1, String value2) {
            addCriterion("reporter between", value1, value2, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotBetween(String value1, String value2) {
            addCriterion("reporter not between", value1, value2, "reporter");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeIsNull() {
            addCriterion("out_biz_type is null");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeIsNotNull() {
            addCriterion("out_biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeEqualTo(String value) {
            addCriterion("out_biz_type =", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeNotEqualTo(String value) {
            addCriterion("out_biz_type <>", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeGreaterThan(String value) {
            addCriterion("out_biz_type >", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("out_biz_type >=", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeLessThan(String value) {
            addCriterion("out_biz_type <", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeLessThanOrEqualTo(String value) {
            addCriterion("out_biz_type <=", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeLike(String value) {
            addCriterion("out_biz_type like", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeNotLike(String value) {
            addCriterion("out_biz_type not like", value, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeIn(List<String> values) {
            addCriterion("out_biz_type in", values, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeNotIn(List<String> values) {
            addCriterion("out_biz_type not in", values, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeBetween(String value1, String value2) {
            addCriterion("out_biz_type between", value1, value2, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizTypeNotBetween(String value1, String value2) {
            addCriterion("out_biz_type not between", value1, value2, "outBizType");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoIsNull() {
            addCriterion("out_biz_order_no is null");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoIsNotNull() {
            addCriterion("out_biz_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoEqualTo(String value) {
            addCriterion("out_biz_order_no =", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoNotEqualTo(String value) {
            addCriterion("out_biz_order_no <>", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoGreaterThan(String value) {
            addCriterion("out_biz_order_no >", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_biz_order_no >=", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoLessThan(String value) {
            addCriterion("out_biz_order_no <", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoLessThanOrEqualTo(String value) {
            addCriterion("out_biz_order_no <=", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoLike(String value) {
            addCriterion("out_biz_order_no like", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoNotLike(String value) {
            addCriterion("out_biz_order_no not like", value, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoIn(List<String> values) {
            addCriterion("out_biz_order_no in", values, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoNotIn(List<String> values) {
            addCriterion("out_biz_order_no not in", values, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoBetween(String value1, String value2) {
            addCriterion("out_biz_order_no between", value1, value2, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutBizOrderNoNotBetween(String value1, String value2) {
            addCriterion("out_biz_order_no not between", value1, value2, "outBizOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyIsNull() {
            addCriterion("out_loc_company is null");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyIsNotNull() {
            addCriterion("out_loc_company is not null");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyEqualTo(String value) {
            addCriterion("out_loc_company =", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyNotEqualTo(String value) {
            addCriterion("out_loc_company <>", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyGreaterThan(String value) {
            addCriterion("out_loc_company >", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("out_loc_company >=", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyLessThan(String value) {
            addCriterion("out_loc_company <", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyLessThanOrEqualTo(String value) {
            addCriterion("out_loc_company <=", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyLike(String value) {
            addCriterion("out_loc_company like", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyNotLike(String value) {
            addCriterion("out_loc_company not like", value, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyIn(List<String> values) {
            addCriterion("out_loc_company in", values, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyNotIn(List<String> values) {
            addCriterion("out_loc_company not in", values, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyBetween(String value1, String value2) {
            addCriterion("out_loc_company between", value1, value2, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocCompanyNotBetween(String value1, String value2) {
            addCriterion("out_loc_company not between", value1, value2, "outLocCompany");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoIsNull() {
            addCriterion("out_loc_order_no is null");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoIsNotNull() {
            addCriterion("out_loc_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoEqualTo(String value) {
            addCriterion("out_loc_order_no =", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoNotEqualTo(String value) {
            addCriterion("out_loc_order_no <>", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoGreaterThan(String value) {
            addCriterion("out_loc_order_no >", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_loc_order_no >=", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoLessThan(String value) {
            addCriterion("out_loc_order_no <", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoLessThanOrEqualTo(String value) {
            addCriterion("out_loc_order_no <=", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoLike(String value) {
            addCriterion("out_loc_order_no like", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoNotLike(String value) {
            addCriterion("out_loc_order_no not like", value, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoIn(List<String> values) {
            addCriterion("out_loc_order_no in", values, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoNotIn(List<String> values) {
            addCriterion("out_loc_order_no not in", values, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoBetween(String value1, String value2) {
            addCriterion("out_loc_order_no between", value1, value2, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andOutLocOrderNoNotBetween(String value1, String value2) {
            addCriterion("out_loc_order_no not between", value1, value2, "outLocOrderNo");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelIsNull() {
            addCriterion("urgency_level is null");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelIsNotNull() {
            addCriterion("urgency_level is not null");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelEqualTo(String value) {
            addCriterion("urgency_level =", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotEqualTo(String value) {
            addCriterion("urgency_level <>", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelGreaterThan(String value) {
            addCriterion("urgency_level >", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("urgency_level >=", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelLessThan(String value) {
            addCriterion("urgency_level <", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelLessThanOrEqualTo(String value) {
            addCriterion("urgency_level <=", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelLike(String value) {
            addCriterion("urgency_level like", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotLike(String value) {
            addCriterion("urgency_level not like", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelIn(List<String> values) {
            addCriterion("urgency_level in", values, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotIn(List<String> values) {
            addCriterion("urgency_level not in", values, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelBetween(String value1, String value2) {
            addCriterion("urgency_level between", value1, value2, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotBetween(String value1, String value2) {
            addCriterion("urgency_level not between", value1, value2, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeIsNull() {
            addCriterion("abnormal_type is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeIsNotNull() {
            addCriterion("abnormal_type is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeEqualTo(String value) {
            addCriterion("abnormal_type =", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotEqualTo(String value) {
            addCriterion("abnormal_type <>", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeGreaterThan(String value) {
            addCriterion("abnormal_type >", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_type >=", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeLessThan(String value) {
            addCriterion("abnormal_type <", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeLessThanOrEqualTo(String value) {
            addCriterion("abnormal_type <=", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeLike(String value) {
            addCriterion("abnormal_type like", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotLike(String value) {
            addCriterion("abnormal_type not like", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeIn(List<String> values) {
            addCriterion("abnormal_type in", values, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotIn(List<String> values) {
            addCriterion("abnormal_type not in", values, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeBetween(String value1, String value2) {
            addCriterion("abnormal_type between", value1, value2, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotBetween(String value1, String value2) {
            addCriterion("abnormal_type not between", value1, value2, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoIsNull() {
            addCriterion("abnormal_info is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoIsNotNull() {
            addCriterion("abnormal_info is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoEqualTo(String value) {
            addCriterion("abnormal_info =", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoNotEqualTo(String value) {
            addCriterion("abnormal_info <>", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoGreaterThan(String value) {
            addCriterion("abnormal_info >", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_info >=", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoLessThan(String value) {
            addCriterion("abnormal_info <", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoLessThanOrEqualTo(String value) {
            addCriterion("abnormal_info <=", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoLike(String value) {
            addCriterion("abnormal_info like", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoNotLike(String value) {
            addCriterion("abnormal_info not like", value, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoIn(List<String> values) {
            addCriterion("abnormal_info in", values, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoNotIn(List<String> values) {
            addCriterion("abnormal_info not in", values, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoBetween(String value1, String value2) {
            addCriterion("abnormal_info between", value1, value2, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoNotBetween(String value1, String value2) {
            addCriterion("abnormal_info not between", value1, value2, "abnormalInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoIsNull() {
            addCriterion("consumer_receive_info is null");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoIsNotNull() {
            addCriterion("consumer_receive_info is not null");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoEqualTo(String value) {
            addCriterion("consumer_receive_info =", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoNotEqualTo(String value) {
            addCriterion("consumer_receive_info <>", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoGreaterThan(String value) {
            addCriterion("consumer_receive_info >", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoGreaterThanOrEqualTo(String value) {
            addCriterion("consumer_receive_info >=", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoLessThan(String value) {
            addCriterion("consumer_receive_info <", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoLessThanOrEqualTo(String value) {
            addCriterion("consumer_receive_info <=", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoLike(String value) {
            addCriterion("consumer_receive_info like", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoNotLike(String value) {
            addCriterion("consumer_receive_info not like", value, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoIn(List<String> values) {
            addCriterion("consumer_receive_info in", values, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoNotIn(List<String> values) {
            addCriterion("consumer_receive_info not in", values, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoBetween(String value1, String value2) {
            addCriterion("consumer_receive_info between", value1, value2, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andConsumerReceiveInfoNotBetween(String value1, String value2) {
            addCriterion("consumer_receive_info not between", value1, value2, "consumerReceiveInfo");
            return (Criteria) this;
        }

        public Criteria andProcessorIsNull() {
            addCriterion("processor is null");
            return (Criteria) this;
        }

        public Criteria andProcessorIsNotNull() {
            addCriterion("processor is not null");
            return (Criteria) this;
        }

        public Criteria andProcessorEqualTo(String value) {
            addCriterion("processor =", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotEqualTo(String value) {
            addCriterion("processor <>", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorGreaterThan(String value) {
            addCriterion("processor >", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorGreaterThanOrEqualTo(String value) {
            addCriterion("processor >=", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorLessThan(String value) {
            addCriterion("processor <", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorLessThanOrEqualTo(String value) {
            addCriterion("processor <=", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorLike(String value) {
            addCriterion("processor like", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotLike(String value) {
            addCriterion("processor not like", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorIn(List<String> values) {
            addCriterion("processor in", values, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotIn(List<String> values) {
            addCriterion("processor not in", values, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorBetween(String value1, String value2) {
            addCriterion("processor between", value1, value2, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotBetween(String value1, String value2) {
            addCriterion("processor not between", value1, value2, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessResultIsNull() {
            addCriterion("process_result is null");
            return (Criteria) this;
        }

        public Criteria andProcessResultIsNotNull() {
            addCriterion("process_result is not null");
            return (Criteria) this;
        }

        public Criteria andProcessResultEqualTo(String value) {
            addCriterion("process_result =", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotEqualTo(String value) {
            addCriterion("process_result <>", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultGreaterThan(String value) {
            addCriterion("process_result >", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultGreaterThanOrEqualTo(String value) {
            addCriterion("process_result >=", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultLessThan(String value) {
            addCriterion("process_result <", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultLessThanOrEqualTo(String value) {
            addCriterion("process_result <=", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultLike(String value) {
            addCriterion("process_result like", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotLike(String value) {
            addCriterion("process_result not like", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultIn(List<String> values) {
            addCriterion("process_result in", values, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotIn(List<String> values) {
            addCriterion("process_result not in", values, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultBetween(String value1, String value2) {
            addCriterion("process_result between", value1, value2, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotBetween(String value1, String value2) {
            addCriterion("process_result not between", value1, value2, "processResult");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsIsNull() {
            addCriterion("attach_file_urls is null");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsIsNotNull() {
            addCriterion("attach_file_urls is not null");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsEqualTo(String value) {
            addCriterion("attach_file_urls =", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsNotEqualTo(String value) {
            addCriterion("attach_file_urls <>", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsGreaterThan(String value) {
            addCriterion("attach_file_urls >", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("attach_file_urls >=", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsLessThan(String value) {
            addCriterion("attach_file_urls <", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsLessThanOrEqualTo(String value) {
            addCriterion("attach_file_urls <=", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsLike(String value) {
            addCriterion("attach_file_urls like", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsNotLike(String value) {
            addCriterion("attach_file_urls not like", value, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsIn(List<String> values) {
            addCriterion("attach_file_urls in", values, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsNotIn(List<String> values) {
            addCriterion("attach_file_urls not in", values, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsBetween(String value1, String value2) {
            addCriterion("attach_file_urls between", value1, value2, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andAttachFileUrlsNotBetween(String value1, String value2) {
            addCriterion("attach_file_urls not between", value1, value2, "attachFileUrls");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}