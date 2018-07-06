package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.SlideshowDAO;
import com.baizhi.cmfz.entity.Slideshow;
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
public class SlideshowServiceImpl implements SlideshowService{
    @Autowired
    private SlideshowDAO slideshowDAO;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryForPage(Integer page, Integer rows) {
        Integer count = slideshowDAO.count();
        List<Slideshow> slideshows = slideshowDAO.selectForPage((page - 1) * rows,rows);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",slideshows);
        return map;
    }


    public Integer addSlideshow(Slideshow slideshow) {
        return slideshowDAO.insertSlideshow(slideshow);
    }

    public Integer modifySlideshow(Slideshow slideshow) {
        return slideshowDAO.updateSlideshow(slideshow);
    }
}
