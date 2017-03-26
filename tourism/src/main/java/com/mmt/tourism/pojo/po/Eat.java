package com.mmt.tourism.pojo.po;

import java.util.Date;

public class Eat {
    private String id;

    private String eatname;

    private String code;

    private String viewid;

    private Date createdate;

    private Date updatedate;

    private String eatdesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEatname() {
        return eatname;
    }

    public void setEatname(String eatname) {
        this.eatname = eatname == null ? null : eatname.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getEatdesc() {
        return eatdesc;
    }

    public void setEatdesc(String eatdesc) {
        this.eatdesc = eatdesc == null ? null : eatdesc.trim();
    }
}