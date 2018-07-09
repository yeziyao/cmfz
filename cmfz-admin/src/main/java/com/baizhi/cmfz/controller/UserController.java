package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Data;
import com.baizhi.cmfz.entity.Man;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    @ResponseBody
    public Data query(){
        //根据性别进行查询数量
        Integer c1 = userService.countBySex("男");
        Integer c2 = userService.countBySex("女");
        List<String> sexes = new ArrayList<String>();
        sexes.add("男");
        sexes.add("女");
        List<Integer> counts= new ArrayList<Integer>();
        counts.add(c1);
        counts.add(c2);
        return new Data(sexes,counts);
    }

    @RequestMapping("queryMale")
    @ResponseBody
    public List<Man> queryMale(){
        List<Man> mans = new ArrayList<Man>();
        mans.add(new Man("河南",1000));
        mans.add(new Man("北京",1000));
        mans.add(new Man("上海",2000));
        mans.add(new Man("哈尔滨",1500));
        mans.add(new Man("河北",1000));
        mans.add(new Man("重庆",1000));
        mans.add(new Man("新疆",2500));
        mans.add(new Man("西藏",2000));
        return mans;
    }
}
