package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

public interface ArticleService {
    //添加文章
    public Integer addArticle(Article article);

    //分页查询
    public Map<String,Object> queryForPage(Integer page, Integer rows);
}
