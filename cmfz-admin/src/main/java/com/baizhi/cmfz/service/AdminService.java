package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface AdminService {
    //根据姓名查询管理员信息
    public Admin queryByName(String adminName);

    //根据姓名查询所属的角色
    public List<Role> queryRolesByName(String amdinName);

    //根据姓名查询所属的权限
    public List<Permission> queryPermsByName(String amdinName);

}
