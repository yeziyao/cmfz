package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * 三种权限校验方式:
 * 1.编程式
 * 2.标签式(控制页面的一些元素)
 * 3.注解式(控制方法)
 */

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("aaaaaaaaaaaa");
        //获取主身份信息
        String adminname= (String) principalCollection.getPrimaryPrincipal();
        List<Role> roles = adminService.queryRolesByName(adminname);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            info.addRole(role.getRoleTag());
        }
        List<Permission> permissions = adminService.queryPermsByName(adminname);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String adminName= usernamePasswordToken.getUsername();
        //根据名字从数据中进行查询
        Admin admin = adminService.queryByName(adminName);
        if(admin!=null){
            return new SimpleAuthenticationInfo(admin.getAdminName(),admin.getPassword(), ByteSource.Util.bytes(admin.getSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
