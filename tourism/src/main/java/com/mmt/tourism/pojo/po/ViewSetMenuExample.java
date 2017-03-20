package com.mmt.tourism.pojo.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewSetMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewSetMenuExample() {
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

        public Criteria andMenunameIsNull() {
            addCriterion("menuName is null");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNotNull() {
            addCriterion("menuName is not null");
            return (Criteria) this;
        }

        public Criteria andMenunameEqualTo(String value) {
            addCriterion("menuName =", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotEqualTo(String value) {
            addCriterion("menuName <>", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThan(String value) {
            addCriterion("menuName >", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThanOrEqualTo(String value) {
            addCriterion("menuName >=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThan(String value) {
            addCriterion("menuName <", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThanOrEqualTo(String value) {
            addCriterion("menuName <=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLike(String value) {
            addCriterion("menuName like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotLike(String value) {
            addCriterion("menuName not like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameIn(List<String> values) {
            addCriterion("menuName in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotIn(List<String> values) {
            addCriterion("menuName not in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameBetween(String value1, String value2) {
            addCriterion("menuName between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotBetween(String value1, String value2) {
            addCriterion("menuName not between", value1, value2, "menuname");
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

        public Criteria andOrdernumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(Integer value) {
            addCriterion("orderNum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(Integer value) {
            addCriterion("orderNum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(Integer value) {
            addCriterion("orderNum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(Integer value) {
            addCriterion("orderNum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("orderNum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<Integer> values) {
            addCriterion("orderNum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<Integer> values) {
            addCriterion("orderNum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("orderNum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNull() {
            addCriterion("orderPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNotNull() {
            addCriterion("orderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceEqualTo(BigDecimal value) {
            addCriterion("orderPrice =", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotEqualTo(BigDecimal value) {
            addCriterion("orderPrice <>", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThan(BigDecimal value) {
            addCriterion("orderPrice >", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orderPrice >=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThan(BigDecimal value) {
            addCriterion("orderPrice <", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orderPrice <=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIn(List<BigDecimal> values) {
            addCriterion("orderPrice in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotIn(List<BigDecimal> values) {
            addCriterion("orderPrice not in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderPrice between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderPrice not between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andRebateIsNull() {
            addCriterion("rebate is null");
            return (Criteria) this;
        }

        public Criteria andRebateIsNotNull() {
            addCriterion("rebate is not null");
            return (Criteria) this;
        }

        public Criteria andRebateEqualTo(BigDecimal value) {
            addCriterion("rebate =", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotEqualTo(BigDecimal value) {
            addCriterion("rebate <>", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThan(BigDecimal value) {
            addCriterion("rebate >", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate >=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThan(BigDecimal value) {
            addCriterion("rebate <", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate <=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateIn(List<BigDecimal> values) {
            addCriterion("rebate in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotIn(List<BigDecimal> values) {
            addCriterion("rebate not in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate between", value1, value2, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate not between", value1, value2, "rebate");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("`days` is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("`days` is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("`days` =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("`days` <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("`days` >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("`days` >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("`days` <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("`days` <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("`days` in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("`days` not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("`days` between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("`days` not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andVisitorsIsNull() {
            addCriterion("visitors is null");
            return (Criteria) this;
        }

        public Criteria andVisitorsIsNotNull() {
            addCriterion("visitors is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorsEqualTo(Integer value) {
            addCriterion("visitors =", value, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsNotEqualTo(Integer value) {
            addCriterion("visitors <>", value, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsGreaterThan(Integer value) {
            addCriterion("visitors >", value, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsGreaterThanOrEqualTo(Integer value) {
            addCriterion("visitors >=", value, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsLessThan(Integer value) {
            addCriterion("visitors <", value, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsLessThanOrEqualTo(Integer value) {
            addCriterion("visitors <=", value, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsIn(List<Integer> values) {
            addCriterion("visitors in", values, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsNotIn(List<Integer> values) {
            addCriterion("visitors not in", values, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsBetween(Integer value1, Integer value2) {
            addCriterion("visitors between", value1, value2, "visitors");
            return (Criteria) this;
        }

        public Criteria andVisitorsNotBetween(Integer value1, Integer value2) {
            addCriterion("visitors not between", value1, value2, "visitors");
            return (Criteria) this;
        }

        public Criteria andTickettypeidIsNull() {
            addCriterion("ticketTypeId is null");
            return (Criteria) this;
        }

        public Criteria andTickettypeidIsNotNull() {
            addCriterion("ticketTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andTickettypeidEqualTo(String value) {
            addCriterion("ticketTypeId =", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidNotEqualTo(String value) {
            addCriterion("ticketTypeId <>", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidGreaterThan(String value) {
            addCriterion("ticketTypeId >", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidGreaterThanOrEqualTo(String value) {
            addCriterion("ticketTypeId >=", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidLessThan(String value) {
            addCriterion("ticketTypeId <", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidLessThanOrEqualTo(String value) {
            addCriterion("ticketTypeId <=", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidLike(String value) {
            addCriterion("ticketTypeId like", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidNotLike(String value) {
            addCriterion("ticketTypeId not like", value, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidIn(List<String> values) {
            addCriterion("ticketTypeId in", values, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidNotIn(List<String> values) {
            addCriterion("ticketTypeId not in", values, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidBetween(String value1, String value2) {
            addCriterion("ticketTypeId between", value1, value2, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andTickettypeidNotBetween(String value1, String value2) {
            addCriterion("ticketTypeId not between", value1, value2, "tickettypeid");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesIsNull() {
            addCriterion("expenseInvoices is null");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesIsNotNull() {
            addCriterion("expenseInvoices is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesEqualTo(String value) {
            addCriterion("expenseInvoices =", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesNotEqualTo(String value) {
            addCriterion("expenseInvoices <>", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesGreaterThan(String value) {
            addCriterion("expenseInvoices >", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesGreaterThanOrEqualTo(String value) {
            addCriterion("expenseInvoices >=", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesLessThan(String value) {
            addCriterion("expenseInvoices <", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesLessThanOrEqualTo(String value) {
            addCriterion("expenseInvoices <=", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesLike(String value) {
            addCriterion("expenseInvoices like", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesNotLike(String value) {
            addCriterion("expenseInvoices not like", value, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesIn(List<String> values) {
            addCriterion("expenseInvoices in", values, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesNotIn(List<String> values) {
            addCriterion("expenseInvoices not in", values, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesBetween(String value1, String value2) {
            addCriterion("expenseInvoices between", value1, value2, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andExpenseinvoicesNotBetween(String value1, String value2) {
            addCriterion("expenseInvoices not between", value1, value2, "expenseinvoices");
            return (Criteria) this;
        }

        public Criteria andActivedateIsNull() {
            addCriterion("activeDate is null");
            return (Criteria) this;
        }

        public Criteria andActivedateIsNotNull() {
            addCriterion("activeDate is not null");
            return (Criteria) this;
        }

        public Criteria andActivedateEqualTo(String value) {
            addCriterion("activeDate =", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotEqualTo(String value) {
            addCriterion("activeDate <>", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateGreaterThan(String value) {
            addCriterion("activeDate >", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateGreaterThanOrEqualTo(String value) {
            addCriterion("activeDate >=", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateLessThan(String value) {
            addCriterion("activeDate <", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateLessThanOrEqualTo(String value) {
            addCriterion("activeDate <=", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateLike(String value) {
            addCriterion("activeDate like", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotLike(String value) {
            addCriterion("activeDate not like", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateIn(List<String> values) {
            addCriterion("activeDate in", values, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotIn(List<String> values) {
            addCriterion("activeDate not in", values, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateBetween(String value1, String value2) {
            addCriterion("activeDate between", value1, value2, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotBetween(String value1, String value2) {
            addCriterion("activeDate not between", value1, value2, "activedate");
            return (Criteria) this;
        }

        public Criteria andBackruleIsNull() {
            addCriterion("backRule is null");
            return (Criteria) this;
        }

        public Criteria andBackruleIsNotNull() {
            addCriterion("backRule is not null");
            return (Criteria) this;
        }

        public Criteria andBackruleEqualTo(String value) {
            addCriterion("backRule =", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleNotEqualTo(String value) {
            addCriterion("backRule <>", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleGreaterThan(String value) {
            addCriterion("backRule >", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleGreaterThanOrEqualTo(String value) {
            addCriterion("backRule >=", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleLessThan(String value) {
            addCriterion("backRule <", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleLessThanOrEqualTo(String value) {
            addCriterion("backRule <=", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleLike(String value) {
            addCriterion("backRule like", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleNotLike(String value) {
            addCriterion("backRule not like", value, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleIn(List<String> values) {
            addCriterion("backRule in", values, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleNotIn(List<String> values) {
            addCriterion("backRule not in", values, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleBetween(String value1, String value2) {
            addCriterion("backRule between", value1, value2, "backrule");
            return (Criteria) this;
        }

        public Criteria andBackruleNotBetween(String value1, String value2) {
            addCriterion("backRule not between", value1, value2, "backrule");
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