package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class Master implements Serializable{
    private Integer masterId;
    private String masterName;
    private String masterImg;
    private String intro;
    private List<Article> articles = new ArrayList<Article>();
    private List<User> users = new ArrayList<User>();

    @Override
    public String toString() {
        return "Master{" +
                "masterId=" + masterId +
                ", masterName='" + masterName + '\'' +
                ", masterImg='" + masterImg + '\'' +
                ", intro='" + intro + '\'' +
                ", articles=" + articles +
                ", users=" + users +
                '}';
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterImg() {
        return masterImg;
    }

    public void setMasterImg(String masterImg) {
        this.masterImg = masterImg;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Master() {

    }

    public Master(Integer masterId, String masterName, String masterImg, String intro, List<Article> articles, List<User> users) {

        this.masterId = masterId;
        this.masterName = masterName;
        this.masterImg = masterImg;
        this.intro = intro;
        this.articles = articles;
        this.users = users;
    }
}
