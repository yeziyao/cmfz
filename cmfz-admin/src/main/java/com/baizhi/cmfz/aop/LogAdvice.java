package com.baizhi.cmfz.aop;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 此类作为一个额外功能类,存储日志信息
 */
@Component
@Aspect
public class LogAdvice {
    private static HttpSession session;

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Autowired
    private LogService logService;

    //声明切入点
    @Pointcut("execution(* com.baizhi.cmfz.service.impl..*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl..*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl..*.add*(..)) ")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{//操作的对象
        String result="";
        Log log = new Log();
        String adminName = "";
        //当前时间new Date()
        Date currTime = new Date();//创建时间
        String resource = "";
        String action = "";
        String message="";
        List<Object> args = null;
        try {
            //adminName存放在session中
            adminName = (String) session.getAttribute("adminname");//哪个管理员产生的日志
            //resource实体名,从类名中截取获取类签名,就是方法的所有信息
            String classType = pjp.getTarget().getClass().getName();
            Class<?> clazz = Class.forName(classType);
            String clazzName = clazz.getName();
            resource = clazzName.split("Service")[0];//操作的实体
            resource = resource.substring(resource.lastIndexOf(".")+1);
            //进行的操作(获取方法名,然后查看里面包含的字段)
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();//获取签名
            String methodName = methodSignature.getMethod().getName();
            action = methodName.indexOf("add")!=-1?"添加":(methodName.indexOf("modify")!=-1?"修改":"删除");//操作
            System.out.println(action);
            //获取方法的参数的信息
            args = Arrays.asList(pjp.getArgs());
            result="success";
        } catch (Exception e) {
            result="false";
            e.printStackTrace();
        }
        log.setAdminName(adminName);
        log.setAction(action);
        log.setMessage(args.toString());
        log.setResource(resource);
        log.setCurrTime(currTime);
        log.setResult(result);
        logService.writeLog(log);
        Object obj = pjp.proceed();
        return obj;
    }
}
