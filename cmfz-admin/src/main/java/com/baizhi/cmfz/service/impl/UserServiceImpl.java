package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDAO;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;


    public Integer countBySex(String sex) {
        return userDAO.countBySex(sex);
    }
}
