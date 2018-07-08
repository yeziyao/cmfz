package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

public interface MasterService {
    //分页查询
    public Map<String,Object> queryForPage(Integer page, Integer rows);

    //插入上师信息
    public Integer addMaster(Master master);

    //更新上师信息
    public Integer modifyMaster(Master master);

    //根据上师法名模糊查询
    public Map<String,Object> queryBlur(String sort, String value, Integer page, Integer rows);

    //批量插入上师信息
    public Integer batchAdd(List<Master> masters);
}
