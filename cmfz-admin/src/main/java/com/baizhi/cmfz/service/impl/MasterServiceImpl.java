package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDAO;
import com.baizhi.cmfz.dao.SlideshowDAO;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Slideshow;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MasterServiceImpl implements MasterService{
    @Autowired
    private MasterDAO masterDAO;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryForPage(Integer page, Integer rows) {
        Integer count = masterDAO.count();
        List<Master> masters = masterDAO.selectForPage((page - 1) * rows,rows);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",masters);
        return map;
    }


    public Integer addMaster(Master master) {
        return masterDAO.insertMaster(master);
    }

    public Integer modifyMaster(Master master) {
        return masterDAO.updateMaster(master);
    }

    public Map<String, Object> queryBlur(String sort, String value, Integer page, Integer rows) {
        List<Master> masters= masterDAO.selectForBlur(sort, value, (page - 1) * rows, rows);
        Integer count = masterDAO.countBlur(sort, value, (page - 1) * rows, rows);
//        System.out.println("查询到的总数:"+count);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",masters);
        return map;
    }


    public Integer batchAdd(List<Master> masters) {
        return masterDAO.insertBatch(masters);
    }

    @Override
    public List<Master> queryAll() {
        return masterDAO.selectAll();
    }
}
