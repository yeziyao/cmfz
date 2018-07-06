package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Slideshow;

import java.util.Map;

public interface SlideshowService {
    //分页查询
    public Map<String,Object> queryForPage(Integer page, Integer rows);

    //插入轮播图
    public Integer addSlideshow(Slideshow slideshow);

    //更新轮播图信息
    public Integer modifySlideshow(Slideshow slideshow);

}
