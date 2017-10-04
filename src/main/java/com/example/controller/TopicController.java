package com.example.controller;

import com.example.dao.TopicDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class TopicController {
    private TopicDAO topicDAO;
    @RequestMapping(value= "/topic", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mov = new ModelAndView("topic");


        return mov;
    }


    @RequestMapping(value= "/topic", method = RequestMethod.POST)
    public ModelAndView loginTopic() {
        ModelAndView mov = new ModelAndView("topic");


        return mov;
    }

    public TopicDAO getTopicDAO() {
        return topicDAO;
    }

    public void setTopicDAO(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }
}
