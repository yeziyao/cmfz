package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Slideshow;
import com.baizhi.cmfz.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
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
    public String add(Slideshow slideshow, MultipartFile file, HttpSession session) throws Exception{
        //添加数据库的操作
        slideshow.setPublishTime(new Date());
        slideshow.setSlideshowImg(file.getOriginalFilename());
        Integer i = slideshowService.addSlideshow(slideshow);
        if(i==1){
            //添加成功,将图片放进文件中
            String realPath = session.getServletContext().getRealPath("/");
            String[] strings = realPath.split("ROOT");
            String uploadPath = strings[0]+"upload";//文件上传的路径
//        System.out.println(uploadPath+"//"+file.getOriginalFilename());
            file.transferTo(new File(uploadPath+"/"+file.getOriginalFilename()));
        }
        return null;
    }

    @RequestMapping("update")
    public String update(Slideshow slideshow){
        slideshowService.modifySlideshow(slideshow);
        return null;
    }


}
