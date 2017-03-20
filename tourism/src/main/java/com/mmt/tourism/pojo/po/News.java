package com.mmt.tourism.pojo.po;

import java.util.Date;

public class News {
    private String id;

    private String title;

    private String viewid;

    private String newsurl;

    private Date createdate;

    private Date updatedate;

    private String newscontext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getViewid() {
        return viewid;
    }

    public void setViewid(String viewid) {
        this.viewid = viewid == null ? null : viewid.trim();
    }

    public String getNewsurl() {
        return newsurl;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl == null ? null : newsurl.trim();
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

    public String getNewscontext() {
        return newscontext;
    }

    public void setNewscontext(String newscontext) {
        this.newscontext = newscontext == null ? null : newscontext.trim();
    }
}