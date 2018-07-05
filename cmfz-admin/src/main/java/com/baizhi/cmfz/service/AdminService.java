package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;

public interface AdminService {
    //注册功能
    public Integer addAdmin(Admin admin);
    //登录功能
    public Admin queryByName(Admin admin);
}
