package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogDAO logDAO;

    public Integer writeLog(Log log) {
        return logDAO.insert(log);
    }


    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryForPage(Integer page, Integer rows) {
        Integer count = logDAO.count();
        List<Log> logs = logDAO.selectForPage((page - 1) * rows,rows);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }
}
