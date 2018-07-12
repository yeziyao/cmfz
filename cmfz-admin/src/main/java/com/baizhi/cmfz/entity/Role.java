package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Role implements Serializable{
    private Integer id;
    private String roleName;
    private String roleTag;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    public Role() {

    }

    public Role(Integer id, String roleName, String roleTag) {

        this.id = id;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }
}
