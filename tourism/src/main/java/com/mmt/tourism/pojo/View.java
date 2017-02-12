package com.mmt.tourism.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class View {
    private String id;

    private String viewname;

    private String code;

    private String citycode;

    private String viewkewwords;

    private String viewsummary;

    private Byte viewseason;

    private BigDecimal rebate;

    private Integer visitnum;

    private Date createdate;

    private Date updatedate;

    private String viewdesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getViewname() {
        return viewname;
    }

    public void setViewname(String viewname) {
        this.viewname = viewname == null ? null : viewname.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getViewkewwords() {
        return viewkewwords;
    }

    public void setViewkewwords(String viewkewwords) {
        this.viewkewwords = viewkewwords == null ? null : viewkewwords.trim();
    }

    public String getViewsummary() {
        return viewsummary;
    }

    public void setViewsummary(String viewsummary) {
        this.viewsummary = viewsummary == null ? null : viewsummary.trim();
    }

    public Byte getViewseason() {
        return viewseason;
    }

    public void setViewseason(Byte viewseason) {
        this.viewseason = viewseason;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public Integer getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(Integer visitnum) {
        this.visitnum = visitnum;
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

    public String getViewdesc() {
        return viewdesc;
    }

    public void setViewdesc(String viewdesc) {
        this.viewdesc = viewdesc == null ? null : viewdesc.trim();
    }
}