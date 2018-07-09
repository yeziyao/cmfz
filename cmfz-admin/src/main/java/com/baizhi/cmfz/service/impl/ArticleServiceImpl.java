package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public Integer addArticle(Article article) {
        System.out.println(article);
        return articleDAO.insertArticle(article);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryForPage(Integer page, Integer rows) {
        Integer count = articleDAO.count();
        List<Article> articles = articleDAO.selectForPage((page - 1) * rows,rows);
        for (Article article : articles) {
            article.setMasterName(article.getMaster().getMasterName());
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",articles);
        return map;
    }
}
