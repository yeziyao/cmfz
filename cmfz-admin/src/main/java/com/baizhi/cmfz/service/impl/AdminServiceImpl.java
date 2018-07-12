package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryByName(String adminName) {
        Admin ad = adminDAO.selectByAdminName(adminName);
        return ad;
    }

    @Override
    public List<Role> queryRolesByName(String amdinName) {
        return adminDAO.selectRolesByName(amdinName);
    }

    @Override
    public List<Permission> queryPermsByName(String amdinName) {
        return adminDAO.selectPermsByName(amdinName);
    }
}
