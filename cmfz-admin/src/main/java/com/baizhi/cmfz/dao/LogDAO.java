package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDAO {
    //添加到数据库中
    public Integer insert(Log log);

    //分页查询所有日志信息
    public List<Log> selectForPage(@Param("start") int start, @Param("pagesize") int pagesize);

    //查询总数
    public Integer count();
}
