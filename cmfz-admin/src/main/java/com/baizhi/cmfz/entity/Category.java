package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Category {
    private Integer categoryId;
    private String categoryName;
    //分类所属的id
    private User user;
    //分类所处的状态(0或者1表示是内置分类还是自定义分类)
    private Integer status;
    //所包含的计数器
    private List<Counter> counters = new ArrayList<Counter>();

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", counters=" + counters +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public Category() {

    }

    public Category(Integer categoryId, String categoryName, User user, Integer status, List<Counter> counters) {

        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.user = user;
        this.status = status;
        this.counters = counters;
    }
}
