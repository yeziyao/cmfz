package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Admin implements Serializable{
    private Integer adminId;
    private String adminName;
    private String password;
    private String salt;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Admin() {

    }

    public Admin(Integer adminId, String adminName, String password, String salt) {

        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
        this.salt = salt;
    }
}
