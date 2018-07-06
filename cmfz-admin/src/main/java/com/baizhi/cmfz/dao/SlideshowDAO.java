package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Slideshow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideshowDAO {
    //分页查询所有的轮播图
    public List<Slideshow> selectForPage(@Param("start") int start, @Param("pagesize") int pagesize);

    //查询总数
    public Integer count();

    //添加轮播图
    public Integer insertSlideshow(Slideshow slideshow);
}
