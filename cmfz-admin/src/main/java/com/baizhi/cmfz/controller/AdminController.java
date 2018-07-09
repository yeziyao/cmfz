package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Description 与admin相关的一些操作
 * @Author  dyy
 * @Time    2018-07-04 17:23:30
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin, String enCode, String isRememberUsername, HttpSession session, HttpServletResponse response){
        String code = (String) session.getAttribute("code");
        if(code.equalsIgnoreCase(enCode) && !enCode.isEmpty()){
            //验证码正确进入下一步
            if(adminService.queryByName(admin)!=null){
                //对密码进行验证,验证正确,将用户名存到cookie中
                if( isRememberUsername!=null && isRememberUsername.equals("true")){
                    //勾选复选框按钮传入结果为TRUE,否则为null
                    try {
                        String adminname = URLEncoder.encode(admin.getAdminName(),"utf-8");
                        Cookie c = new Cookie("adminname",adminname);
                        response.addCookie(c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                session.setAttribute("adminname",admin.getAdminName());
                return "showAll";
            }
        }
        return "adminLogin";
    }

    @RequestMapping("/tologin")
    public String toLogin(HttpServletRequest request) throws Exception{
        Cookie cs[] = request.getCookies();
        if(cs!=null){
            for(Cookie c:cs){
                if(c.getName()!=null && c.getName().equals("adminname")){
                    String cval = c.getValue();
                    cval =  URLDecoder.decode(cval,"utf-8");
                    request.setAttribute("adminname",cval);
                }
            }
        }
        return "adminLogin";
    }

    @RequestMapping("modify")
    public String modify(String password,HttpSession session){
        String adminname = (String)session.getAttribute("adminname");
        Admin admin = new Admin();
        //根据姓名进行查询
        admin.setAdminName(adminname);
        admin.setPassword(password);
        Integer i = adminService.modifyAdmin(admin);
        return "success";
    }

}
