package com.mmt.tourism.pojo.po;

import java.util.Date;

public class Province {
    private String namecode;

    private String name;

    private Date createdate;

    private Date updatedate;

    public String getNamecode() {
        return namecode;
    }

    public void setNamecode(String namecode) {
        this.namecode = namecode == null ? null : namecode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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