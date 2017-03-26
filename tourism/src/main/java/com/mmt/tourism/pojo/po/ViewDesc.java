package com.mmt.tourism.pojo.po;

import java.util.Date;

public class ViewDesc {
    private String id;

    private String opentime;

    private String palytime;

    private Date createdate;

    private Date updatedate;

    private String viewdesc;

    private String viewhistory;

    private String positionmsg;

    private String ticketmsg;

    private String weather;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime == null ? null : opentime.trim();
    }

    public String getPalytime() {
        return palytime;
    }

    public void setPalytime(String palytime) {
        this.palytime = palytime == null ? null : palytime.trim();
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

    public String getViewhistory() {
        return viewhistory;
    }

    public void setViewhistory(String viewhistory) {
        this.viewhistory = viewhistory == null ? null : viewhistory.trim();
    }

    public String getPositionmsg() {
        return positionmsg;
    }

    public void setPositionmsg(String positionmsg) {
        this.positionmsg = positionmsg == null ? null : positionmsg.trim();
    }

    public String getTicketmsg() {
        return ticketmsg;
    }

    public void setTicketmsg(String ticketmsg) {
        this.ticketmsg = ticketmsg == null ? null : ticketmsg.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }
}