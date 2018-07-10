package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

public interface LogService {
    //将日志添加到数据库中
    public Integer writeLog(Log log);

    //分页查询
    public Map<String,Object> queryForPage(Integer page, Integer rows);
}
