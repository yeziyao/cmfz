package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Slideshow;
import com.baizhi.cmfz.service.MasterService;
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
import java.util.UUID;

@Controller
@RequestMapping("master")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @RequestMapping("queryAll")
    @ResponseBody
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Map<String, Object> map = masterService.queryForPage(page, rows);
//        System.out.println(map);
        return map;
    }

    @RequestMapping("add")
    public String add(Master master, MultipartFile file, HttpSession session) throws Exception{
        //生成唯一的UUID文件名
        String uuidName = UUID.randomUUID().toString().replace("-","");
        //源文件名
        String oldName = file.getOriginalFilename();
        //获取后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //添加数据库的操作
        master.setMasterImg(uuidName+suffix);
        Integer i = masterService.addMaster(master);
        if(i==1){
            //添加成功,将图片放进文件中
            String realPath = session.getServletContext().getRealPath("/");
            String[] strings = realPath.split("ROOT");
            String uploadPath = strings[0]+"upload";//文件上传的路径
//            System.out.println(uploadPath+"//"+file.getOriginalFilename());
            file.transferTo(new File(uploadPath+"/"+uuidName+suffix));
        }
        return null;
    }

    @RequestMapping("update")
    public String update(Master master,HttpSession session, MultipartFile file) throws Exception{

        //先判断是否修改了头像
        if(file!=null){
            //生成唯一的UUID文件名
            String uuidName = UUID.randomUUID().toString().replace("-","");
            //源文件名
            String oldName = file.getOriginalFilename();
            //获取后缀
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            //添加数据库的操作
            master.setMasterImg(uuidName+suffix);
            String realPath = session.getServletContext().getRealPath("/");
            String[] strings = realPath.split("ROOT");
            String uploadPath = strings[0]+"upload";//文件上传的路径
//            System.out.println(uploadPath+"//"+file.getOriginalFilename());
            file.transferTo(new File(uploadPath+"/"+uuidName+suffix));
        }
        System.out.println(master);
        masterService.modifyMaster(master);
        return null;
    }

    @RequestMapping("queryBlur")
    @ResponseBody
    public Map<String,Object> query(String value, String sort, Integer page, Integer rows) {
        Map<String, Object> map = masterService.queryBlur(sort, value, page, rows);
        return map;
    }
}
