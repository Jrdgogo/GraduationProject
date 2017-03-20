package com.mmt.tourism.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelRoomExample() {
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

        public Criteria andRoomnameIsNull() {
            addCriterion("roomName is null");
            return (Criteria) this;
        }

        public Criteria andRoomnameIsNotNull() {
            addCriterion("roomName is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnameEqualTo(String value) {
            addCriterion("roomName =", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotEqualTo(String value) {
            addCriterion("roomName <>", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThan(String value) {
            addCriterion("roomName >", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThanOrEqualTo(String value) {
            addCriterion("roomName >=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThan(String value) {
            addCriterion("roomName <", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThanOrEqualTo(String value) {
            addCriterion("roomName <=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLike(String value) {
            addCriterion("roomName like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotLike(String value) {
            addCriterion("roomName not like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameIn(List<String> values) {
            addCriterion("roomName in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotIn(List<String> values) {
            addCriterion("roomName not in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameBetween(String value1, String value2) {
            addCriterion("roomName between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotBetween(String value1, String value2) {
            addCriterion("roomName not between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnoIsNull() {
            addCriterion("roomNo is null");
            return (Criteria) this;
        }

        public Criteria andRoomnoIsNotNull() {
            addCriterion("roomNo is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnoEqualTo(String value) {
            addCriterion("roomNo =", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotEqualTo(String value) {
            addCriterion("roomNo <>", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoGreaterThan(String value) {
            addCriterion("roomNo >", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoGreaterThanOrEqualTo(String value) {
            addCriterion("roomNo >=", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoLessThan(String value) {
            addCriterion("roomNo <", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoLessThanOrEqualTo(String value) {
            addCriterion("roomNo <=", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoLike(String value) {
            addCriterion("roomNo like", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotLike(String value) {
            addCriterion("roomNo not like", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoIn(List<String> values) {
            addCriterion("roomNo in", values, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotIn(List<String> values) {
            addCriterion("roomNo not in", values, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoBetween(String value1, String value2) {
            addCriterion("roomNo between", value1, value2, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotBetween(String value1, String value2) {
            addCriterion("roomNo not between", value1, value2, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoompriceIsNull() {
            addCriterion("roomPrice is null");
            return (Criteria) this;
        }

        public Criteria andRoompriceIsNotNull() {
            addCriterion("roomPrice is not null");
            return (Criteria) this;
        }

        public Criteria andRoompriceEqualTo(Byte value) {
            addCriterion("roomPrice =", value, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceNotEqualTo(Byte value) {
            addCriterion("roomPrice <>", value, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceGreaterThan(Byte value) {
            addCriterion("roomPrice >", value, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceGreaterThanOrEqualTo(Byte value) {
            addCriterion("roomPrice >=", value, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceLessThan(Byte value) {
            addCriterion("roomPrice <", value, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceLessThanOrEqualTo(Byte value) {
            addCriterion("roomPrice <=", value, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceIn(List<Byte> values) {
            addCriterion("roomPrice in", values, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceNotIn(List<Byte> values) {
            addCriterion("roomPrice not in", values, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceBetween(Byte value1, Byte value2) {
            addCriterion("roomPrice between", value1, value2, "roomprice");
            return (Criteria) this;
        }

        public Criteria andRoompriceNotBetween(Byte value1, Byte value2) {
            addCriterion("roomPrice not between", value1, value2, "roomprice");
            return (Criteria) this;
        }

        public Criteria andHotelidIsNull() {
            addCriterion("hotelId is null");
            return (Criteria) this;
        }

        public Criteria andHotelidIsNotNull() {
            addCriterion("hotelId is not null");
            return (Criteria) this;
        }

        public Criteria andHotelidEqualTo(String value) {
            addCriterion("hotelId =", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotEqualTo(String value) {
            addCriterion("hotelId <>", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidGreaterThan(String value) {
            addCriterion("hotelId >", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidGreaterThanOrEqualTo(String value) {
            addCriterion("hotelId >=", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLessThan(String value) {
            addCriterion("hotelId <", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLessThanOrEqualTo(String value) {
            addCriterion("hotelId <=", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLike(String value) {
            addCriterion("hotelId like", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotLike(String value) {
            addCriterion("hotelId not like", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidIn(List<String> values) {
            addCriterion("hotelId in", values, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotIn(List<String> values) {
            addCriterion("hotelId not in", values, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidBetween(String value1, String value2) {
            addCriterion("hotelId between", value1, value2, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotBetween(String value1, String value2) {
            addCriterion("hotelId not between", value1, value2, "hotelid");
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