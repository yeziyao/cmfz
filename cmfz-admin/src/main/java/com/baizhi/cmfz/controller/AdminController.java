package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    public String login(Admin admin, String enCode, boolean isRememberUsername, HttpSession session){
        //在web环境中安全管理器会自动进行初始化
        //创建主体对象
        Subject subject = SecurityUtils.getSubject();
        String code = (String) session.getAttribute("code");
        if(code.equalsIgnoreCase(enCode) && !enCode.isEmpty()){
            //验证码正确,判断用户名密码是否正确
            try {
                subject.login(new UsernamePasswordToken(admin.getAdminName(),admin.getPassword(),isRememberUsername));
                System.out.println(subject.isPermitted("user:add"));
                session.setAttribute("adminname",admin.getAdminName());
                return "showAll";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return "adminLogin";
            }
        }
        return "adminLogin";
    }

    /*@RequestMapping("/tologin")
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
    }*/


}
