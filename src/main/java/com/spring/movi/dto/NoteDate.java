package com.spring.movi.dto;

public class NoteDate {
    private  int status;
    private String createDate;
    private String createBy;
    private String modifyDate;
    private String modifyBy;

    public NoteDate(int status, String createDate, String createBy, String modifyDate, String modifyBy) {
        this.status = status;
        this.createDate = createDate;
        this.createBy = createBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
    }

    public NoteDate() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public String toString() {
        return "NoteDate{" +
                "status=" + status +
                ", createDate='" + createDate + '\'' +
                ", createBy='" + createBy + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                '}';
    }
}
