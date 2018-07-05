package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 计数器
 */
@Component
public class Counter {
    private Integer counterId;
    private String counterName;
    //计数器中记录次数
    private Integer counters;
    private Date createTime;
    //所属分类
    private Category category;
    //所属用户
    private User user;

    @Override
    public String toString() {
        return "Counter{" +
                "counterId=" + counterId +
                ", counterName='" + counterName + '\'' +
                ", counters=" + counters +
                ", createTime=" + createTime +
                ", category=" + category +
                ", user=" + user +
                '}';
    }

    public Integer getCounterId() {
        return counterId;
    }

    public void setCounterId(Integer counterId) {
        this.counterId = counterId;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public Integer getCounters() {
        return counters;
    }

    public void setCounters(Integer counters) {
        this.counters = counters;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Counter() {

    }

    public Counter(Integer counterId, String counterName, Integer counters, Date createTime, Category category, User user) {

        this.counterId = counterId;
        this.counterName = counterName;
        this.counters = counters;
        this.createTime = createTime;
        this.category = category;
        this.user = user;
    }
}
