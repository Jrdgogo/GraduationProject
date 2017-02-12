package com.mmt.tourism.pojo;

import java.util.Date;

public class Hotel {
    private String id;

    private String hotelname;

    private String hotelphone;

    private String code;

    private String viewid;

    private String hotelcategory;

    private Date createdate;

    private Date updatedate;

    private String hoteldesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public String getHotelphone() {
        return hotelphone;
    }

    public void setHotelphone(String hotelphone) {
        this.hotelphone = hotelphone == null ? null : hotelphone.trim();
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

    public String getHotelcategory() {
        return hotelcategory;
    }

    public void setHotelcategory(String hotelcategory) {
        this.hotelcategory = hotelcategory == null ? null : hotelcategory.trim();
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

    public String getHoteldesc() {
        return hoteldesc;
    }

    public void setHoteldesc(String hoteldesc) {
        this.hoteldesc = hoteldesc == null ? null : hoteldesc.trim();
    }
}