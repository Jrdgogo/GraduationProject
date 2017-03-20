package com.mmt.tourism.pojo.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSetmenuidIsNull() {
            addCriterion("setMenuId is null");
            return (Criteria) this;
        }

        public Criteria andSetmenuidIsNotNull() {
            addCriterion("setMenuId is not null");
            return (Criteria) this;
        }

        public Criteria andSetmenuidEqualTo(String value) {
            addCriterion("setMenuId =", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidNotEqualTo(String value) {
            addCriterion("setMenuId <>", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidGreaterThan(String value) {
            addCriterion("setMenuId >", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidGreaterThanOrEqualTo(String value) {
            addCriterion("setMenuId >=", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidLessThan(String value) {
            addCriterion("setMenuId <", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidLessThanOrEqualTo(String value) {
            addCriterion("setMenuId <=", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidLike(String value) {
            addCriterion("setMenuId like", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidNotLike(String value) {
            addCriterion("setMenuId not like", value, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidIn(List<String> values) {
            addCriterion("setMenuId in", values, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidNotIn(List<String> values) {
            addCriterion("setMenuId not in", values, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidBetween(String value1, String value2) {
            addCriterion("setMenuId between", value1, value2, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andSetmenuidNotBetween(String value1, String value2) {
            addCriterion("setMenuId not between", value1, value2, "setmenuid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOutdateIsNull() {
            addCriterion("outDate is null");
            return (Criteria) this;
        }

        public Criteria andOutdateIsNotNull() {
            addCriterion("outDate is not null");
            return (Criteria) this;
        }

        public Criteria andOutdateEqualTo(Date value) {
            addCriterion("outDate =", value, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateNotEqualTo(Date value) {
            addCriterion("outDate <>", value, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateGreaterThan(Date value) {
            addCriterion("outDate >", value, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateGreaterThanOrEqualTo(Date value) {
            addCriterion("outDate >=", value, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateLessThan(Date value) {
            addCriterion("outDate <", value, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateLessThanOrEqualTo(Date value) {
            addCriterion("outDate <=", value, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateIn(List<Date> values) {
            addCriterion("outDate in", values, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateNotIn(List<Date> values) {
            addCriterion("outDate not in", values, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateBetween(Date value1, Date value2) {
            addCriterion("outDate between", value1, value2, "outdate");
            return (Criteria) this;
        }

        public Criteria andOutdateNotBetween(Date value1, Date value2) {
            addCriterion("outDate not between", value1, value2, "outdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateIsNull() {
            addCriterion("bespeakDate is null");
            return (Criteria) this;
        }

        public Criteria andBespeakdateIsNotNull() {
            addCriterion("bespeakDate is not null");
            return (Criteria) this;
        }

        public Criteria andBespeakdateEqualTo(Date value) {
            addCriterion("bespeakDate =", value, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateNotEqualTo(Date value) {
            addCriterion("bespeakDate <>", value, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateGreaterThan(Date value) {
            addCriterion("bespeakDate >", value, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateGreaterThanOrEqualTo(Date value) {
            addCriterion("bespeakDate >=", value, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateLessThan(Date value) {
            addCriterion("bespeakDate <", value, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateLessThanOrEqualTo(Date value) {
            addCriterion("bespeakDate <=", value, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateIn(List<Date> values) {
            addCriterion("bespeakDate in", values, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateNotIn(List<Date> values) {
            addCriterion("bespeakDate not in", values, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateBetween(Date value1, Date value2) {
            addCriterion("bespeakDate between", value1, value2, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andBespeakdateNotBetween(Date value1, Date value2) {
            addCriterion("bespeakDate not between", value1, value2, "bespeakdate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andChangeStatusIsNull() {
            addCriterion("change_status is null");
            return (Criteria) this;
        }

        public Criteria andChangeStatusIsNotNull() {
            addCriterion("change_status is not null");
            return (Criteria) this;
        }

        public Criteria andChangeStatusEqualTo(Boolean value) {
            addCriterion("change_status =", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotEqualTo(Boolean value) {
            addCriterion("change_status <>", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusGreaterThan(Boolean value) {
            addCriterion("change_status >", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("change_status >=", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusLessThan(Boolean value) {
            addCriterion("change_status <", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("change_status <=", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusIn(List<Boolean> values) {
            addCriterion("change_status in", values, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotIn(List<Boolean> values) {
            addCriterion("change_status not in", values, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("change_status between", value1, value2, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("change_status not between", value1, value2, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
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