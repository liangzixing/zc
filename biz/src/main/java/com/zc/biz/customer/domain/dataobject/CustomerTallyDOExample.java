package com.zc.biz.customer.domain.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerTallyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerTallyDOExample() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeIsNull() {
            addCriterion("from_account_type is null");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeIsNotNull() {
            addCriterion("from_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeEqualTo(String value) {
            addCriterion("from_account_type =", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeNotEqualTo(String value) {
            addCriterion("from_account_type <>", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeGreaterThan(String value) {
            addCriterion("from_account_type >", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("from_account_type >=", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeLessThan(String value) {
            addCriterion("from_account_type <", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("from_account_type <=", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeLike(String value) {
            addCriterion("from_account_type like", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeNotLike(String value) {
            addCriterion("from_account_type not like", value, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeIn(List<String> values) {
            addCriterion("from_account_type in", values, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeNotIn(List<String> values) {
            addCriterion("from_account_type not in", values, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeBetween(String value1, String value2) {
            addCriterion("from_account_type between", value1, value2, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountTypeNotBetween(String value1, String value2) {
            addCriterion("from_account_type not between", value1, value2, "fromAccountType");
            return (Criteria) this;
        }

        public Criteria andFromAccountIsNull() {
            addCriterion("from_account is null");
            return (Criteria) this;
        }

        public Criteria andFromAccountIsNotNull() {
            addCriterion("from_account is not null");
            return (Criteria) this;
        }

        public Criteria andFromAccountEqualTo(String value) {
            addCriterion("from_account =", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountNotEqualTo(String value) {
            addCriterion("from_account <>", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountGreaterThan(String value) {
            addCriterion("from_account >", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountGreaterThanOrEqualTo(String value) {
            addCriterion("from_account >=", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountLessThan(String value) {
            addCriterion("from_account <", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountLessThanOrEqualTo(String value) {
            addCriterion("from_account <=", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountLike(String value) {
            addCriterion("from_account like", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountNotLike(String value) {
            addCriterion("from_account not like", value, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountIn(List<String> values) {
            addCriterion("from_account in", values, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountNotIn(List<String> values) {
            addCriterion("from_account not in", values, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountBetween(String value1, String value2) {
            addCriterion("from_account between", value1, value2, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andFromAccountNotBetween(String value1, String value2) {
            addCriterion("from_account not between", value1, value2, "fromAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeIsNull() {
            addCriterion("to_account_type is null");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeIsNotNull() {
            addCriterion("to_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeEqualTo(String value) {
            addCriterion("to_account_type =", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeNotEqualTo(String value) {
            addCriterion("to_account_type <>", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeGreaterThan(String value) {
            addCriterion("to_account_type >", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("to_account_type >=", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeLessThan(String value) {
            addCriterion("to_account_type <", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("to_account_type <=", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeLike(String value) {
            addCriterion("to_account_type like", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeNotLike(String value) {
            addCriterion("to_account_type not like", value, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeIn(List<String> values) {
            addCriterion("to_account_type in", values, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeNotIn(List<String> values) {
            addCriterion("to_account_type not in", values, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeBetween(String value1, String value2) {
            addCriterion("to_account_type between", value1, value2, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountTypeNotBetween(String value1, String value2) {
            addCriterion("to_account_type not between", value1, value2, "toAccountType");
            return (Criteria) this;
        }

        public Criteria andToAccountIsNull() {
            addCriterion("to_account is null");
            return (Criteria) this;
        }

        public Criteria andToAccountIsNotNull() {
            addCriterion("to_account is not null");
            return (Criteria) this;
        }

        public Criteria andToAccountEqualTo(String value) {
            addCriterion("to_account =", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountNotEqualTo(String value) {
            addCriterion("to_account <>", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountGreaterThan(String value) {
            addCriterion("to_account >", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountGreaterThanOrEqualTo(String value) {
            addCriterion("to_account >=", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountLessThan(String value) {
            addCriterion("to_account <", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountLessThanOrEqualTo(String value) {
            addCriterion("to_account <=", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountLike(String value) {
            addCriterion("to_account like", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountNotLike(String value) {
            addCriterion("to_account not like", value, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountIn(List<String> values) {
            addCriterion("to_account in", values, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountNotIn(List<String> values) {
            addCriterion("to_account not in", values, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountBetween(String value1, String value2) {
            addCriterion("to_account between", value1, value2, "toAccount");
            return (Criteria) this;
        }

        public Criteria andToAccountNotBetween(String value1, String value2) {
            addCriterion("to_account not between", value1, value2, "toAccount");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceIsNull() {
            addCriterion("customer_last_balance is null");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceIsNotNull() {
            addCriterion("customer_last_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceEqualTo(Long value) {
            addCriterion("customer_last_balance =", value, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceNotEqualTo(Long value) {
            addCriterion("customer_last_balance <>", value, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceGreaterThan(Long value) {
            addCriterion("customer_last_balance >", value, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_last_balance >=", value, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceLessThan(Long value) {
            addCriterion("customer_last_balance <", value, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceLessThanOrEqualTo(Long value) {
            addCriterion("customer_last_balance <=", value, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceIn(List<Long> values) {
            addCriterion("customer_last_balance in", values, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceNotIn(List<Long> values) {
            addCriterion("customer_last_balance not in", values, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceBetween(Long value1, Long value2) {
            addCriterion("customer_last_balance between", value1, value2, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerLastBalanceNotBetween(Long value1, Long value2) {
            addCriterion("customer_last_balance not between", value1, value2, "customerLastBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceIsNull() {
            addCriterion("customer_balance is null");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceIsNotNull() {
            addCriterion("customer_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceEqualTo(Long value) {
            addCriterion("customer_balance =", value, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceNotEqualTo(Long value) {
            addCriterion("customer_balance <>", value, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceGreaterThan(Long value) {
            addCriterion("customer_balance >", value, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_balance >=", value, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceLessThan(Long value) {
            addCriterion("customer_balance <", value, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceLessThanOrEqualTo(Long value) {
            addCriterion("customer_balance <=", value, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceIn(List<Long> values) {
            addCriterion("customer_balance in", values, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceNotIn(List<Long> values) {
            addCriterion("customer_balance not in", values, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceBetween(Long value1, Long value2) {
            addCriterion("customer_balance between", value1, value2, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andCustomerBalanceNotBetween(Long value1, Long value2) {
            addCriterion("customer_balance not between", value1, value2, "customerBalance");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlIsNull() {
            addCriterion("credentials_img_url is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlIsNotNull() {
            addCriterion("credentials_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlEqualTo(String value) {
            addCriterion("credentials_img_url =", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlNotEqualTo(String value) {
            addCriterion("credentials_img_url <>", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlGreaterThan(String value) {
            addCriterion("credentials_img_url >", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("credentials_img_url >=", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlLessThan(String value) {
            addCriterion("credentials_img_url <", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlLessThanOrEqualTo(String value) {
            addCriterion("credentials_img_url <=", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlLike(String value) {
            addCriterion("credentials_img_url like", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlNotLike(String value) {
            addCriterion("credentials_img_url not like", value, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlIn(List<String> values) {
            addCriterion("credentials_img_url in", values, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlNotIn(List<String> values) {
            addCriterion("credentials_img_url not in", values, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlBetween(String value1, String value2) {
            addCriterion("credentials_img_url between", value1, value2, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andCredentialsImgUrlNotBetween(String value1, String value2) {
            addCriterion("credentials_img_url not between", value1, value2, "credentialsImgUrl");
            return (Criteria) this;
        }

        public Criteria andReporterIdIsNull() {
            addCriterion("reporter_id is null");
            return (Criteria) this;
        }

        public Criteria andReporterIdIsNotNull() {
            addCriterion("reporter_id is not null");
            return (Criteria) this;
        }

        public Criteria andReporterIdEqualTo(Long value) {
            addCriterion("reporter_id =", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdNotEqualTo(Long value) {
            addCriterion("reporter_id <>", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdGreaterThan(Long value) {
            addCriterion("reporter_id >", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reporter_id >=", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdLessThan(Long value) {
            addCriterion("reporter_id <", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdLessThanOrEqualTo(Long value) {
            addCriterion("reporter_id <=", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdIn(List<Long> values) {
            addCriterion("reporter_id in", values, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdNotIn(List<Long> values) {
            addCriterion("reporter_id not in", values, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdBetween(Long value1, Long value2) {
            addCriterion("reporter_id between", value1, value2, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdNotBetween(Long value1, Long value2) {
            addCriterion("reporter_id not between", value1, value2, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterNameIsNull() {
            addCriterion("reporter_name is null");
            return (Criteria) this;
        }

        public Criteria andReporterNameIsNotNull() {
            addCriterion("reporter_name is not null");
            return (Criteria) this;
        }

        public Criteria andReporterNameEqualTo(String value) {
            addCriterion("reporter_name =", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameNotEqualTo(String value) {
            addCriterion("reporter_name <>", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameGreaterThan(String value) {
            addCriterion("reporter_name >", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameGreaterThanOrEqualTo(String value) {
            addCriterion("reporter_name >=", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameLessThan(String value) {
            addCriterion("reporter_name <", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameLessThanOrEqualTo(String value) {
            addCriterion("reporter_name <=", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameLike(String value) {
            addCriterion("reporter_name like", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameNotLike(String value) {
            addCriterion("reporter_name not like", value, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameIn(List<String> values) {
            addCriterion("reporter_name in", values, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameNotIn(List<String> values) {
            addCriterion("reporter_name not in", values, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameBetween(String value1, String value2) {
            addCriterion("reporter_name between", value1, value2, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReporterNameNotBetween(String value1, String value2) {
            addCriterion("reporter_name not between", value1, value2, "reporterName");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNull() {
            addCriterion("report_date is null");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNotNull() {
            addCriterion("report_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportDateEqualTo(Date value) {
            addCriterion("report_date =", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotEqualTo(Date value) {
            addCriterion("report_date <>", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThan(Date value) {
            addCriterion("report_date >", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThanOrEqualTo(Date value) {
            addCriterion("report_date >=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThan(Date value) {
            addCriterion("report_date <", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThanOrEqualTo(Date value) {
            addCriterion("report_date <=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIn(List<Date> values) {
            addCriterion("report_date in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotIn(List<Date> values) {
            addCriterion("report_date not in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateBetween(Date value1, Date value2) {
            addCriterion("report_date between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotBetween(Date value1, Date value2) {
            addCriterion("report_date not between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNull() {
            addCriterion("display is null");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNotNull() {
            addCriterion("display is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEqualTo(String value) {
            addCriterion("display =", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotEqualTo(String value) {
            addCriterion("display <>", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThan(String value) {
            addCriterion("display >", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("display >=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThan(String value) {
            addCriterion("display <", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThanOrEqualTo(String value) {
            addCriterion("display <=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLike(String value) {
            addCriterion("display like", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotLike(String value) {
            addCriterion("display not like", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayIn(List<String> values) {
            addCriterion("display in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotIn(List<String> values) {
            addCriterion("display not in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayBetween(String value1, String value2) {
            addCriterion("display between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotBetween(String value1, String value2) {
            addCriterion("display not between", value1, value2, "display");
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