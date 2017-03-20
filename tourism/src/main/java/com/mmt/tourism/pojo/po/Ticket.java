package com.mmt.tourism.pojo.po;

import java.util.Date;

public class Ticket {
    private String id;

    private String setmenuid;

    private Byte number;

    private Boolean status;

    private Date createdate;

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

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}