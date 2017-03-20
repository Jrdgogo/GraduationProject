package com.mmt.tourism.pojo.po;

import java.math.BigDecimal;
import java.util.Date;

public class ViewSetMenu {
    private String id;

    private String menuname;

    private String viewid;

    private Integer ordernum;

    private BigDecimal orderprice;

    private BigDecimal rebate;

    private Integer days;

    private Integer visitors;

    private String tickettypeid;

    private String expenseinvoices;

    private String activedate;

    private String backrule;

    private Date createdate;

    private Date updatedate;

    private String menudesc;

    private String usagemethod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getViewid() {
        return viewid;
    }

    public void setViewid(String viewid) {
        this.viewid = viewid == null ? null : viewid.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public BigDecimal getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(BigDecimal orderprice) {
        this.orderprice = orderprice;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getVisitors() {
        return visitors;
    }

    public void setVisitors(Integer visitors) {
        this.visitors = visitors;
    }

    public String getTickettypeid() {
        return tickettypeid;
    }

    public void setTickettypeid(String tickettypeid) {
        this.tickettypeid = tickettypeid == null ? null : tickettypeid.trim();
    }

    public String getExpenseinvoices() {
        return expenseinvoices;
    }

    public void setExpenseinvoices(String expenseinvoices) {
        this.expenseinvoices = expenseinvoices == null ? null : expenseinvoices.trim();
    }

    public String getActivedate() {
        return activedate;
    }

    public void setActivedate(String activedate) {
        this.activedate = activedate == null ? null : activedate.trim();
    }

    public String getBackrule() {
        return backrule;
    }

    public void setBackrule(String backrule) {
        this.backrule = backrule == null ? null : backrule.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getMenudesc() {
        return menudesc;
    }

    public void setMenudesc(String menudesc) {
        this.menudesc = menudesc == null ? null : menudesc.trim();
    }

    public String getUsagemethod() {
        return usagemethod;
    }

    public void setUsagemethod(String usagemethod) {
        this.usagemethod = usagemethod == null ? null : usagemethod.trim();
    }
}