package com.mmt.tourism.pojo.po;

public class TicketType {
    private String id;

    private String code;

    private String typedesc;

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

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc == null ? null : typedesc.trim();
    }
}