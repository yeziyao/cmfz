package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Log {
    //日志编号
    private Integer id;
    //日志创建者
    private String adminName;
    //日志创建时间
    private Date currTime;
    //操作实体
    private String resource;
    //具体操作
    private String action;
    //日志信息
    private String message;
    //结果
    private String result;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", currTime=" + currTime +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getCurrTime() {
        return currTime;
    }

    public void setCurrTime(Date currTime) {
        this.currTime = currTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Log() {

    }

    public Log(Integer id, String adminName, Date currTime, String resource, String action, String message, String result) {
        this.id = id;
        this.adminName = adminName;
        this.currTime = currTime;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }
}
