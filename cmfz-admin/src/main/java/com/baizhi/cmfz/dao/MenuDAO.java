package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDAO {
    //根据parentid查询所有的二级菜单
    public List<Menu> selectByParId(@Param("parId") Integer parId);

    public List<Menu> selectAll();

}
