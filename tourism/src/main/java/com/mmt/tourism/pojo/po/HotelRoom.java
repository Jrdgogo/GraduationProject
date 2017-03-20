package com.mmt.tourism.pojo.po;

import java.util.Date;

public class HotelRoom {
    private String id;

    private String roomname;

    private String roomno;

    private Byte roomprice;

    private String hotelid;

    private Date createdate;

    private Date updatedate;

    private String roomdesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno == null ? null : roomno.trim();
    }

    public Byte getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(Byte roomprice) {
        this.roomprice = roomprice;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid == null ? null : hotelid.trim();
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

    public String getRoomdesc() {
        return roomdesc;
    }

    public void setRoomdesc(String roomdesc) {
        this.roomdesc = roomdesc == null ? null : roomdesc.trim();
    }
}