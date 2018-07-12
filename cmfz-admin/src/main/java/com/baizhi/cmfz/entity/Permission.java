package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Permission implements Serializable{
    private Integer id;
    private String resourceName;
    private String resourceTag;
    private String resourceUrl;
    private String permissionTag;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public Permission() {

    }

    public Permission(Integer id, String resourceName, String resourceTag, String resourceUrl, String permissionTag) {

        this.id = id;
        this.resourceName = resourceName;
        this.resourceTag = resourceTag;
        this.resourceUrl = resourceUrl;
        this.permissionTag = permissionTag;
    }
}
