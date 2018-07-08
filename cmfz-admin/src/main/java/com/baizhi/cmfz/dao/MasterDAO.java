package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterDAO {
    //分页查询所有的上师信息
    public List<Master> selectForPage(@Param("start") int start, @Param("pagesize") int pagesize);

    //查询总数
    public Integer count();

    //添加轮播图
    public Integer insertMaster(Master master);

    //修改轮播图信息
    public Integer updateMaster(Master master);

    //根据法名进行模糊查询,并进行分页展示
    public List<Master> selectForBlur(@Param("sort") String sort, @Param("value") String value, @Param("start") Integer start, @Param("pagesize") Integer pagesize);
    //模糊查询的总数
    public Integer countBlur(@Param("sort") String sort, @Param("value") String value, @Param("start") Integer start, @Param("pagesize") Integer pagesize);

    //批量插入
    public Integer insertBatch(@Param("masters") List<Master> masters);
}
