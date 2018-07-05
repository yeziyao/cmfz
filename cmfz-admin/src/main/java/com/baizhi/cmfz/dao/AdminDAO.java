package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;
import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
    //添加用户
    public Integer insertAdmin(Admin admin);
    //验证用户名密码是否相同
    public Admin selectByAdminName(@Param("adminName") String adminName);
}
