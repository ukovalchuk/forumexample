package com.example.controller;

import com.example.dao.UserDAO;
import com.example.entity.UserEntity;
import com.example.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    private UserDAO userDAO;
    private RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userForm", new UserEntity());
        return "register";

    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm") UserEntity userForm ,Model model) {

        registerService.createUser(userForm);

        return "redirect:/main";
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
