package com.mmt.tourism.pojo;

import java.util.Date;

public class ViewRoute {
    private String id;

    private String viewid;

    private String routes;

    private Integer routeprice;

    private Integer ordernum;

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

    public String getRoutes() {
        return routes;
    }

    public void setRoutes(String routes) {
        this.routes = routes == null ? null : routes.trim();
    }

    public Integer getRouteprice() {
        return routeprice;
    }

    public void setRouteprice(Integer routeprice) {
        this.routeprice = routeprice;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
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