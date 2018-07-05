package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.utils.NewValidateCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("validate")
public class GetValidateCode{

    @RequestMapping("validatecode")
    public void getValidateCode(HttpSession session,HttpServletResponse response) throws Exception{
        NewValidateCodeUtils utils = new NewValidateCodeUtils(100,30,2);
        session.setAttribute("code", utils.getCode());
        utils.write(response.getOutputStream());
    }
}
