package com.anTools.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class AnBookkeeping implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer userId;
    private String incomeOrExpend;
    private String bkType;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="Asia/Shanghai")
    private Date bkDate;
    private Float bkMoney;
    private String bkRemark;
    private String bkDateDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIncomeOrExpend() {
        return incomeOrExpend;
    }

    public void setIncomeOrExpend(String incomeOrExpend) {
        this.incomeOrExpend = incomeOrExpend;
    }

    public String getBkType() {
        return bkType;
    }

    public void setBkType(String bkType) {
        this.bkType = bkType;
    }

    public Date getBkDate() {
        return bkDate;
    }

    public void setBkDate(Date bkDate) {
        this.bkDate = bkDate;
    }

    public Float getBkMoney() {
        return bkMoney;
    }

    public void setBkMoney(Float bkMoney) {
        this.bkMoney = bkMoney;
    }

    public String getBkRemark() {
        return bkRemark;
    }

    public void setBkRemark(String bkRemark) {
        this.bkRemark = bkRemark;
    }

    public String getBkDateDay() {
        return bkDateDay;
    }

    public void setBkDateDay(String bkDateDay) {
        this.bkDateDay = bkDateDay;
    }

    @Override
    public String toString() {
        return "AnBookkeeping{" +
                "id=" + id +
                ", userId=" + userId +
                ", incomeOrExpend='" + incomeOrExpend + '\'' +
                ", bkType='" + bkType + '\'' +
                ", bkDate=" + bkDate +
                ", bkMoney=" + bkMoney +
                ", bkRemark='" + bkRemark + '\'' +
                ", bkDateDay='" + bkDateDay + '\'' +
                '}';
    }

}
