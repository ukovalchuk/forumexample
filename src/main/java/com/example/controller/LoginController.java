package com.example.controller;

import com.example.dao.UserRoleDAO;
import com.example.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    private UserRoleDAO userRoleDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userlogin", new UserEntity());
        return "login";

    }

//    public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
//        this.userRoleDAO = userRoleDAO;
//    }

    @RequestMapping(value= "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "login", required=true) String login,
            @RequestParam(value = "password", required=true) String password
    ) {
        // todo authorisation
        return null;
    }

    public UserRoleDAO getUserRoleDAO() {
        return userRoleDAO;
    }

    public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }
}

