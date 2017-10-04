package com.example.service;

import com.example.dao.UserDAO;
import com.example.entity.UserEntity;

import java.util.List;

public class RegisterService {
    public UserDAO userDAO;

    public RegisterService(UserDAO userDAO){
        this.userDAO=userDAO;
    }
    public List<UserEntity> findAllUsers(){
        return userDAO.findAllUsers();
    }
    public UserEntity findUser(Integer id){
        return userDAO.findUser(id);
    }
    public void createUser(UserEntity user){
        userDAO.createUser(user);
    }
    public void editUser(UserEntity user){
        userDAO.editUser(user);
    }


}
