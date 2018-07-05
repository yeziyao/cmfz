package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Slideshow implements Serializable{
    private Integer slideshowId;
    private String slideshowDec;//轮播描述
    private Date publishTime;//发布时间
    private String slideshowImg;
    private Integer status;//是否显示的状态

    @Override
    public String toString() {
        return "Slideshow{" +
                "slideshowId=" + slideshowId +
                ", slideshowDec='" + slideshowDec + '\'' +
                ", publishTime=" + publishTime +
                ", slideshowImg='" + slideshowImg + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getSlideshowId() {
        return slideshowId;
    }

    public void setSlideshowId(Integer slideshowId) {
        this.slideshowId = slideshowId;
    }

    public String getSlideshowDec() {
        return slideshowDec;
    }

    public void setSlideshowDec(String slideshowDec) {
        this.slideshowDec = slideshowDec;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getSlideshowImg() {
        return slideshowImg;
    }

    public void setSlideshowImg(String slideshowImg) {
        this.slideshowImg = slideshowImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Slideshow() {

    }

    public Slideshow(Integer slideshowId, String slideshowDec, Date publishTime, String slideshowImg, Integer status) {

        this.slideshowId = slideshowId;
        this.slideshowDec = slideshowDec;
        this.publishTime = publishTime;
        this.slideshowImg = slideshowImg;
        this.status = status;
    }
}
