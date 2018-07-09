package com.baizhi.cmfz.dao;

public interface UserDAO {
    //根据性别查询用户数量
    public Integer countBySex(String sex);
}
