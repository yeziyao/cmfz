package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("queryAll")
    @ResponseBody
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Map<String, Object> map = logService.queryForPage(page, rows);
        return map;
    }

}
