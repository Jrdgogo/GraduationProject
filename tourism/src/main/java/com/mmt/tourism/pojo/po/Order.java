package com.mmt.tourism.pojo.po;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String id;

    private String setmenuid;

    private String userid;

    private Byte status;

    private Date outdate;

    private Date bespeakdate;

    private BigDecimal price;

    private Boolean changeStatus;

    private Date createdate;

    private Date updatedate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSetmenuid() {
        return setmenuid;
    }

    public void setSetmenuid(String setmenuid) {
        this.setmenuid = setmenuid == null ? null : setmenuid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public Date getBespeakdate() {
        return bespeakdate;
    }

    public void setBespeakdate(Date bespeakdate) {
        this.bespeakdate = bespeakdate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Boolean changeStatus) {
        this.changeStatus = changeStatus;
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