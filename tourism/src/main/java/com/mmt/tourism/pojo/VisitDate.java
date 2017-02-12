package com.mmt.tourism.pojo;

import java.util.Date;

public class VisitDate {
    private String id;

    private String code;

    private Date visitdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }
}