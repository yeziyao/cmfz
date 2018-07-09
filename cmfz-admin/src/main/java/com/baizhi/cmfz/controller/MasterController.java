package com.baizhi.cmfz.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
    public String add(Master master, MultipartFile file, HttpSession session) throws Exception {
        //生成唯一的UUID文件名
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        //源文件名
        String oldName = file.getOriginalFilename();
        //获取后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //添加数据库的操作
        master.setMasterImg(uuidName + suffix);
        Integer i = masterService.addMaster(master);
        if (i == 1) {
            //添加成功,将图片放进文件中
            String realPath = session.getServletContext().getRealPath("/");
            String[] strings = realPath.split("ROOT");
            String uploadPath = strings[0] + "upload";//文件上传的路径
//            System.out.println(uploadPath+"//"+file.getOriginalFilename());
            file.transferTo(new File(uploadPath + "/" + uuidName + suffix));
        }
        return null;
    }

    @RequestMapping("update")
    public String update(Master master, HttpSession session, MultipartFile file) throws Exception {

        //先判断是否修改了头像
        if (file != null) {
            //生成唯一的UUID文件名
            String uuidName = UUID.randomUUID().toString().replace("-", "");
            //源文件名
            String oldName = file.getOriginalFilename();
            //获取后缀
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            //添加数据库的操作
            master.setMasterImg(uuidName + suffix);
            String realPath = session.getServletContext().getRealPath("/");
            String[] strings = realPath.split("ROOT");
            String uploadPath = strings[0] + "upload";//文件上传的路径
//            System.out.println(uploadPath+"//"+file.getOriginalFilename());
            file.transferTo(new File(uploadPath + "/" + uuidName + suffix));
        }
        System.out.println(master);
        masterService.modifyMaster(master);
        return null;
    }

    @RequestMapping("queryBlur")
    @ResponseBody
    public Map<String, Object> query(String value, String sort, Integer page, Integer rows) {
        Map<String, Object> map = masterService.queryBlur(sort, value, page, rows);
        return map;
    }

    //其中经历文件上传,上传但是没有保存在服务器中,然后就导入
    @RequestMapping("batchAdd")
    public void batchAdd(MultipartFile file) {
        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader(file.getInputStream());
            List<Master> list = reader.readAll(Master.class);
            System.out.println(list);
            masterService.batchAdd(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*文件导出不能使用异步方式,因为异步都是支持的json和xml,
    * 不支持流*/
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse resp) throws IOException {
        List<Master> masters= masterService.queryAll();
        // Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("c118", "上师信息表"), Master.class, masters);
        ServletOutputStream out = resp.getOutputStream();
        // 文件下载 设置响应头
        // 注意：响应头 默认使用的编码格式iso-8859-1

        String fileName = new String("上师信息.xls".getBytes(), "iso-8859-1");

        resp.setContentType("application/vnd.ms-excel"); //响应类型  text/html  application/json
        resp.setHeader("content-disposition","attachment;fileName="+fileName);
        // 导出 文件下载的方式
        workbook.write(out);
        out.close();
    }

    //查询所有上师信息
    @RequestMapping("queryAllName")
    @ResponseBody
    public List<Master> queryAll(){
        List<Master> masters = masterService.queryAll();
        return masters;
    }
}
