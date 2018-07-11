package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 三种权限校验方式:
 * 1.编程式
 * 2.标签式(控制页面的一些元素)
 * 3.注解式(控制方法)
 */

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminDAO adminDAO;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       //获取主身份信息
        String adminname= (String) principalCollection.getPrimaryPrincipal();
        Admin admin = adminDAO.selectByAdminName(adminname);
        if(admin!=null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");
            info.addRole("user");
            info.addStringPermission("user:add");
            info.addStringPermission("user:delete");
            info.addStringPermission("user:query");
            return info;
        }
        return null;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        //根据名字从数据中进行查询
        Admin admin = adminDAO.selectByAdminName(username);
        if(admin!=null){
            return new SimpleAuthenticationInfo(admin.getAdminName(),admin.getPassword(), ByteSource.Util.bytes(admin.getSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
