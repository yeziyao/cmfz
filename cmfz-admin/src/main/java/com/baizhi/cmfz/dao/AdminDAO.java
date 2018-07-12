package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDAO {
    //验证用户名密码是否相同
    public Admin selectByAdminName(@Param("adminName") String adminName);
    //根据姓名查询角色信息
    public List<Role> selectRolesByName(@Param("adminName") String adminName);

    //根据姓名查询权限信息
    public List<Permission> selectPermsByName(@Param("adminName") String adminName);
}
