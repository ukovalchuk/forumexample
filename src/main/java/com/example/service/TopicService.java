package com.example.service;

import com.example.dao.TopicDAO;
import com.example.entity.TopicEntity;

import java.util.List;

public class TopicService {
    public TopicDAO topicDAO;

    public List<TopicEntity> findAll(){
        return topicDAO.findAll();
    }
    public TopicEntity findTopic(Integer id){
        return topicDAO.findTopic(id);
    }
    public void editTopic(TopicEntity topic){
        topicDAO.editTopic(topic);
    }
    public void createTopic(TopicEntity topic){
        topicDAO.createTopic(topic);
    }

}
