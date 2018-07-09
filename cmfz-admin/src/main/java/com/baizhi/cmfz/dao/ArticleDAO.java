package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDAO {
    //添加文章
    public Integer insertArticle(Article article);

    //分页查询所有的文章
    public List<Article> selectForPage(@Param("start") int start, @Param("pagesize") int pagesize);

    //查询总数
    public Integer count();
}
