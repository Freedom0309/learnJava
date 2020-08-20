package com.freedom.zebra;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description:
 *
 * @author liufeng
 * @version 2020/8/18 17:18
 * @since v1.0.0
 */
public class LabelMessage {
    /**
     * 公司名称
     */
    private String company;
    /**
     * 资产编号
     */
    private String number;
    /**
     * 资产名称
     */
    private String name;
    /**
     * 规格型号
     */
    private String type;
    /**
     * 启用时间
     */
    private Date startTime;
    /**
     * 使用部门
     */
    private String department;

    /**
     * 所属人
     */
    private String ownerName;

    /**
     * 存放地点
     */
    private String address;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LabelMessage{" +
                "company='" + company + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", startTime=" + startTime +
                ", department='" + department + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
