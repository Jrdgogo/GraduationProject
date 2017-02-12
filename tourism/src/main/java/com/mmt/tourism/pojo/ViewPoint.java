package com.mmt.tourism.pojo;

import java.util.Date;

public class ViewPoint {
    private String id;

    private String viewpointname;

    private String code;

    private String viewpointsummary;

    private Byte viewticket;

    private Integer visitnum;

    private String viewid;

    private Date createdate;

    private Date updatedate;

    private String viewpointdesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getViewpointname() {
        return viewpointname;
    }

    public void setViewpointname(String viewpointname) {
        this.viewpointname = viewpointname == null ? null : viewpointname.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getViewpointsummary() {
        return viewpointsummary;
    }

    public void setViewpointsummary(String viewpointsummary) {
        this.viewpointsummary = viewpointsummary == null ? null : viewpointsummary.trim();
    }

    public Byte getViewticket() {
        return viewticket;
    }

    public void setViewticket(Byte viewticket) {
        this.viewticket = viewticket;
    }

    public Integer getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(Integer visitnum) {
        this.visitnum = visitnum;
    }

    public String getViewid() {
        return viewid;
    }

    public void setViewid(String viewid) {
        this.viewid = viewid == null ? null : viewid.trim();
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

    public String getViewpointdesc() {
        return viewpointdesc;
    }

    public void setViewpointdesc(String viewpointdesc) {
        this.viewpointdesc = viewpointdesc == null ? null : viewpointdesc.trim();
    }
}