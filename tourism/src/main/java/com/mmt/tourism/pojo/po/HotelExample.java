package com.mmt.tourism.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
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

        public Criteria andHotelnameIsNull() {
            addCriterion("hotelName is null");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNotNull() {
            addCriterion("hotelName is not null");
            return (Criteria) this;
        }

        public Criteria andHotelnameEqualTo(String value) {
            addCriterion("hotelName =", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotEqualTo(String value) {
            addCriterion("hotelName <>", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThan(String value) {
            addCriterion("hotelName >", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelName >=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThan(String value) {
            addCriterion("hotelName <", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThanOrEqualTo(String value) {
            addCriterion("hotelName <=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLike(String value) {
            addCriterion("hotelName like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotLike(String value) {
            addCriterion("hotelName not like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameIn(List<String> values) {
            addCriterion("hotelName in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotIn(List<String> values) {
            addCriterion("hotelName not in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameBetween(String value1, String value2) {
            addCriterion("hotelName between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotBetween(String value1, String value2) {
            addCriterion("hotelName not between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelphoneIsNull() {
            addCriterion("hotelPhone is null");
            return (Criteria) this;
        }

        public Criteria andHotelphoneIsNotNull() {
            addCriterion("hotelPhone is not null");
            return (Criteria) this;
        }

        public Criteria andHotelphoneEqualTo(String value) {
            addCriterion("hotelPhone =", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotEqualTo(String value) {
            addCriterion("hotelPhone <>", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneGreaterThan(String value) {
            addCriterion("hotelPhone >", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("hotelPhone >=", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneLessThan(String value) {
            addCriterion("hotelPhone <", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneLessThanOrEqualTo(String value) {
            addCriterion("hotelPhone <=", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneLike(String value) {
            addCriterion("hotelPhone like", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotLike(String value) {
            addCriterion("hotelPhone not like", value, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneIn(List<String> values) {
            addCriterion("hotelPhone in", values, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotIn(List<String> values) {
            addCriterion("hotelPhone not in", values, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneBetween(String value1, String value2) {
            addCriterion("hotelPhone between", value1, value2, "hotelphone");
            return (Criteria) this;
        }

        public Criteria andHotelphoneNotBetween(String value1, String value2) {
            addCriterion("hotelPhone not between", value1, value2, "hotelphone");
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

        public Criteria andHotelcategoryIsNull() {
            addCriterion("hotelCategory is null");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryIsNotNull() {
            addCriterion("hotelCategory is not null");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryEqualTo(String value) {
            addCriterion("hotelCategory =", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryNotEqualTo(String value) {
            addCriterion("hotelCategory <>", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryGreaterThan(String value) {
            addCriterion("hotelCategory >", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("hotelCategory >=", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryLessThan(String value) {
            addCriterion("hotelCategory <", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryLessThanOrEqualTo(String value) {
            addCriterion("hotelCategory <=", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryLike(String value) {
            addCriterion("hotelCategory like", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryNotLike(String value) {
            addCriterion("hotelCategory not like", value, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryIn(List<String> values) {
            addCriterion("hotelCategory in", values, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryNotIn(List<String> values) {
            addCriterion("hotelCategory not in", values, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryBetween(String value1, String value2) {
            addCriterion("hotelCategory between", value1, value2, "hotelcategory");
            return (Criteria) this;
        }

        public Criteria andHotelcategoryNotBetween(String value1, String value2) {
            addCriterion("hotelCategory not between", value1, value2, "hotelcategory");
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