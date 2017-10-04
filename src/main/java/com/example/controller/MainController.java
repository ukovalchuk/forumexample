package com.example.controller;

import com.example.dao.TopicDAO;
import com.example.entity.TopicEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String main(Model model) {

//        TopicDAO topicDAO= new TopicDAO();
//        List<TopicEntity> topic=topicDAO.findAll();
//        topic.size();
        return "main";
    }


}
