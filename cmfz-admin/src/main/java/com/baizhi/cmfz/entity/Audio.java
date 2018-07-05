package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class Audio implements Serializable{
    private Integer audioId;
    private String audioName;
    private String reader;
    private String audioSize;
    private String audioAddr;
    //该音频所属的专辑
    private Album album;

    @Override
    public String toString() {
        return "Audio{" +
                "audioId=" + audioId +
                ", audioName='" + audioName + '\'' +
                ", reader='" + reader + '\'' +
                ", audioSize='" + audioSize + '\'' +
                ", audioAddr='" + audioAddr + '\'' +
                ", album=" + album +
                '}';
    }

    public Integer getAudioId() {
        return audioId;
    }

    public void setAudioId(Integer audioId) {
        this.audioId = audioId;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getAudioSize() {
        return audioSize;
    }

    public void setAudioSize(String audioSize) {
        this.audioSize = audioSize;
    }

    public String getAudioAddr() {
        return audioAddr;
    }

    public void setAudioAddr(String audioAddr) {
        this.audioAddr = audioAddr;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Audio() {

    }

    public Audio(Integer audioId, String audioName, String reader, String audioSize, String audioAddr, Album album) {

        this.audioId = audioId;
        this.audioName = audioName;
        this.reader = reader;
        this.audioSize = audioSize;
        this.audioAddr = audioAddr;
        this.album = album;
    }
}
