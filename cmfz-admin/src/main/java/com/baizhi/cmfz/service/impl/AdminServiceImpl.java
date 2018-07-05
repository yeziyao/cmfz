package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    public Integer addAdmin(Admin admin) {
        String salt = EncryptionUtil.getRandomSalt(4);
        String pwd = EncryptionUtil.encryptionCode(admin.getPassword() + salt);
        admin.setPassword(pwd);
        admin.setSalt(salt);
        return adminDAO.insertAdmin(admin);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin queryByName(Admin admin) {
        Admin ad = adminDAO.selectByAdminName(admin.getAdminName());
        String pwd = EncryptionUtil.encryptionCode(admin.getPassword() + ad.getSalt());
        if (pwd.equals(ad.getPassword())){
            return ad;
        }
        return null;
    }
}