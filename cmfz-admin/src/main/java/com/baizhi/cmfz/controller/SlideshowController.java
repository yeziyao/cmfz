package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Slideshow;
import com.baizhi.cmfz.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("slideshow")
public class SlideshowController {
    @Autowired
    private SlideshowService slideshowService;

    @RequestMapping("queryAll")
    @ResponseBody
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Map<String, Object> map = slideshowService.queryForPage(page, rows);
//        System.out.println(map);
        return map;
    }

    @RequestMapping("add")
    public String add(Slideshow slideshow, MultipartFile file, HttpSession session){
        System.out.println(slideshow);
        System.out.println(file.getOriginalFilename());
        String realPath = session.getServletContext().getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("/");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";
        System.out.println(uploadPath);
        return null;
    }
}
