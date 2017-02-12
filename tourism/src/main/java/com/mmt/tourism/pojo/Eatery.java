package com.mmt.tourism.pojo;

import java.util.Date;

public class Eatery {
    private String id;

    private String eateryname;

    private String code;

    private String viewid;

    private String eaterycategory;

    private Byte consume;

    private Date createdate;

    private Date updatedate;

    private String eaterydesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEateryname() {
        return eateryname;
    }

    public void setEateryname(String eateryname) {
        this.eateryname = eateryname == null ? null : eateryname.trim();
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

    public String getEaterycategory() {
        return eaterycategory;
    }

    public void setEaterycategory(String eaterycategory) {
        this.eaterycategory = eaterycategory == null ? null : eaterycategory.trim();
    }

    public Byte getConsume() {
        return consume;
    }

    public void setConsume(Byte consume) {
        this.consume = consume;
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

    public String getEaterydesc() {
        return eaterydesc;
    }

    public void setEaterydesc(String eaterydesc) {
        this.eaterydesc = eaterydesc == null ? null : eaterydesc.trim();
    }
}