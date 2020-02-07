package com.anTools.entity;

import java.io.Serializable;
import java.util.Date;

public class AnToken implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String openId;
    private String role;
    private Date lastLoginDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "AnToken{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", role='" + role + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }

}
