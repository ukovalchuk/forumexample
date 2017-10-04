package com.example.service;

import com.example.dao.UserRoleDAO;
import com.example.entity.UserRoleEntity;

public class LoginService {
    public UserRoleDAO userRoleDAO;

    LoginService(UserRoleDAO userRoleDAO){
        this.userRoleDAO=userRoleDAO;
    }

    public UserRoleEntity findById(Integer id){
        return userRoleDAO.findById(id);
    }
}
