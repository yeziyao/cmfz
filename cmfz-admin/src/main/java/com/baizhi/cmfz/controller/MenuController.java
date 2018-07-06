package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.apache.taglibs.standard.tag.el.core.ForEachTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @Description 展示菜单(一级二级)
 * @Author  dyy
 * @Time    2018-07-05 14:14:00
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /*查询所有的一级菜单*/
    @RequestMapping(value = "/showMenu")
    @ResponseBody
    public List<Menu> show(HttpSession session){
        List<Menu> ms = menuService.queryAll();
//        String menus = JSON.toJSONString(ms);
        return ms;
    }

}
