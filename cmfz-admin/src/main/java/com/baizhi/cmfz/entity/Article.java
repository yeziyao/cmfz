package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Article implements Serializable{
    private Integer articleId;
    private String articleName;
    private String articleContent;
    private Date publishTime;
    private String status;
    private Master master;//由哪位上师所写

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", publishTime=" + publishTime +
                ", status='" + status + '\'' +
                ", master=" + master +
                '}';
    }

    public Article() {
    }

    public Article(Integer articleId, String articleName, String articleContent, Date publishTime, String status, Master master) {

        this.articleId = articleId;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.publishTime = publishTime;
        this.status = status;
        this.master = master;
    }
}
