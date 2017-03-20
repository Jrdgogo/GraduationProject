package com.mmt.tourism.pojo.po;

import java.util.Date;

public class Comment {
    private String id;

    private String code;

    private String viewdesc;

    private String userid;

    private Boolean status;

    private Integer arguenum;

    private Date createdate;

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

    public String getViewdesc() {
        return viewdesc;
    }

    public void setViewdesc(String viewdesc) {
        this.viewdesc = viewdesc == null ? null : viewdesc.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getArguenum() {
        return arguenum;
    }

    public void setArguenum(Integer arguenum) {
        this.arguenum = arguenum;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}