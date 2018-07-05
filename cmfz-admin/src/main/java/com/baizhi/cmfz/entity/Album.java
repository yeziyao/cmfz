package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Album {
    private Integer albumId;
    private String albumName;
    private String author;
    private String beam;//播音
    private Integer count;
    private Integer grade;
    private String albumImg;
    private String content;
    private Date publishTime;
    //一个专辑里面有多个音频
    private List<Audio> audios = new ArrayList<Audio>();

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", author='" + author + '\'' +
                ", beam='" + beam + '\'' +
                ", count=" + count +
                ", grade=" + grade +
                ", albumImg='" + albumImg + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", audios=" + audios +
                '}';
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBeam() {
        return beam;
    }

    public void setBeam(String beam) {
        this.beam = beam;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAlbumImg() {
        return albumImg;
    }

    public void setAlbumImg(String albumImg) {
        this.albumImg = albumImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }

    public Album() {

    }

    public Album(Integer albumId, String albumName, String author, String beam, Integer count, Integer grade, String albumImg, String content, Date publishTime, List<Audio> audios) {

        this.albumId = albumId;
        this.albumName = albumName;
        this.author = author;
        this.beam = beam;
        this.count = count;
        this.grade = grade;
        this.albumImg = albumImg;
        this.content = content;
        this.publishTime = publishTime;
        this.audios = audios;
    }
}
