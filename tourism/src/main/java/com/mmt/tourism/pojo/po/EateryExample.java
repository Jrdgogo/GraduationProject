package com.mmt.tourism.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EateryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EateryExample() {
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

        public Criteria andEaterynameIsNull() {
            addCriterion("eateryName is null");
            return (Criteria) this;
        }

        public Criteria andEaterynameIsNotNull() {
            addCriterion("eateryName is not null");
            return (Criteria) this;
        }

        public Criteria andEaterynameEqualTo(String value) {
            addCriterion("eateryName =", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameNotEqualTo(String value) {
            addCriterion("eateryName <>", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameGreaterThan(String value) {
            addCriterion("eateryName >", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameGreaterThanOrEqualTo(String value) {
            addCriterion("eateryName >=", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameLessThan(String value) {
            addCriterion("eateryName <", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameLessThanOrEqualTo(String value) {
            addCriterion("eateryName <=", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameLike(String value) {
            addCriterion("eateryName like", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameNotLike(String value) {
            addCriterion("eateryName not like", value, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameIn(List<String> values) {
            addCriterion("eateryName in", values, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameNotIn(List<String> values) {
            addCriterion("eateryName not in", values, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameBetween(String value1, String value2) {
            addCriterion("eateryName between", value1, value2, "eateryname");
            return (Criteria) this;
        }

        public Criteria andEaterynameNotBetween(String value1, String value2) {
            addCriterion("eateryName not between", value1, value2, "eateryname");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andViewidIsNull() {
            addCriterion("viewId is null");
            return (Criteria) this;
        }

        public Criteria andViewidIsNotNull() {
            addCriterion("viewId is not null");
            return (Criteria) this;
        }

        public Criteria andViewidEqualTo(String value) {
            addCriterion("viewId =", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidNotEqualTo(String value) {
            addCriterion("viewId <>", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidGreaterThan(String value) {
            addCriterion("viewId >", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidGreaterThanOrEqualTo(String value) {
            addCriterion("viewId >=", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidLessThan(String value) {
            addCriterion("viewId <", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidLessThanOrEqualTo(String value) {
            addCriterion("viewId <=", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidLike(String value) {
            addCriterion("viewId like", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidNotLike(String value) {
            addCriterion("viewId not like", value, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidIn(List<String> values) {
            addCriterion("viewId in", values, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidNotIn(List<String> values) {
            addCriterion("viewId not in", values, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidBetween(String value1, String value2) {
            addCriterion("viewId between", value1, value2, "viewid");
            return (Criteria) this;
        }

        public Criteria andViewidNotBetween(String value1, String value2) {
            addCriterion("viewId not between", value1, value2, "viewid");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryIsNull() {
            addCriterion("eateryCategory is null");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryIsNotNull() {
            addCriterion("eateryCategory is not null");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryEqualTo(String value) {
            addCriterion("eateryCategory =", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryNotEqualTo(String value) {
            addCriterion("eateryCategory <>", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryGreaterThan(String value) {
            addCriterion("eateryCategory >", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryGreaterThanOrEqualTo(String value) {
            addCriterion("eateryCategory >=", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryLessThan(String value) {
            addCriterion("eateryCategory <", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryLessThanOrEqualTo(String value) {
            addCriterion("eateryCategory <=", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryLike(String value) {
            addCriterion("eateryCategory like", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryNotLike(String value) {
            addCriterion("eateryCategory not like", value, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryIn(List<String> values) {
            addCriterion("eateryCategory in", values, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryNotIn(List<String> values) {
            addCriterion("eateryCategory not in", values, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryBetween(String value1, String value2) {
            addCriterion("eateryCategory between", value1, value2, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andEaterycategoryNotBetween(String value1, String value2) {
            addCriterion("eateryCategory not between", value1, value2, "eaterycategory");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNull() {
            addCriterion("consume is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNotNull() {
            addCriterion("consume is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeEqualTo(Byte value) {
            addCriterion("consume =", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotEqualTo(Byte value) {
            addCriterion("consume <>", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThan(Byte value) {
            addCriterion("consume >", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThanOrEqualTo(Byte value) {
            addCriterion("consume >=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThan(Byte value) {
            addCriterion("consume <", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThanOrEqualTo(Byte value) {
            addCriterion("consume <=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeIn(List<Byte> values) {
            addCriterion("consume in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotIn(List<Byte> values) {
            addCriterion("consume not in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeBetween(Byte value1, Byte value2) {
            addCriterion("consume between", value1, value2, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotBetween(Byte value1, Byte value2) {
            addCriterion("consume not between", value1, value2, "consume");
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