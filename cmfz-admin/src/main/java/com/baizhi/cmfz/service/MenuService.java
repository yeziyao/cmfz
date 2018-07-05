package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

public interface MenuService {
    //根据parentid查询所有的菜单
    public List<Menu> queryAll();
}
