package com.mmt.tourism.pojo;

import java.util.Date;

public class ViewSetMenu {
    private String id;

    private String viewid;

    private String setmenus;

    private Integer ordernum;

    private Integer orderprice;

    private Integer days;

    private Integer visitors;

    private Date createdate;

    private Date updatedate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getViewid() {
        return viewid;
    }

    public void setViewid(String viewid) {
        this.viewid = viewid == null ? null : viewid.trim();
    }

    public String getSetmenus() {
        return setmenus;
    }

    public void setSetmenus(String setmenus) {
        this.setmenus = setmenus == null ? null : setmenus.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Integer orderprice) {
        this.orderprice = orderprice;
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
}