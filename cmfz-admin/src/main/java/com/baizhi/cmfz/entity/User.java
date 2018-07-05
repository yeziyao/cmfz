package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class User implements Serializable{
    //id
    private Integer userId;
    //用户名
    private String userName;
    //法名
    private String religName;
    //密码
    private String password;
    private String salt;
    private String sex;
    private String img;
    private String address;
    private String phone;
    //签名
    private String sign;
    private Integer status;
    //跟随的上师
    private Master master;
    //该用户所有的分类
    private List<Category> categories = new ArrayList<Category>();
    //该用户所拥有的计数器
    private List<Counter> counters = new ArrayList<Counter>();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", religName='" + religName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", master=" + master +
                ", categories=" + categories +
                ", counters=" + counters +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReligName() {
        return religName;
    }

    public void setReligName(String religName) {
        this.religName = religName;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public User() {

    }

    public User(Integer userId, String userName, String religName, String password, String salt, String sex, String img, String address, String phone, String sign, Integer status, Master master, List<Category> categories, List<Counter> counters) {

        this.userId = userId;
        this.userName = userName;
        this.religName = religName;
        this.password = password;
        this.salt = salt;
        this.sex = sex;
        this.img = img;
        this.address = address;
        this.phone = phone;
        this.sign = sign;
        this.status = status;
        this.master = master;
        this.categories = categories;
        this.counters = counters;
    }
}
