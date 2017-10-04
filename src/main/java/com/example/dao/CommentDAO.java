package com.example.dao;

import com.example.entity.CommentEntity;
import com.example.entity.TopicEntity;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class CommentDAO {
    final static Logger logger = Logger.getLogger(CommentEntity.class);

    public CommentEntity createComment(TopicEntity topicEntity) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        CommentEntity ce = (CommentEntity) s.get(CommentEntity.class, topicEntity.getId());
        ce.setText(ce.getText());
        s.save(topicEntity);
        s.getTransaction().commit();
        s.close();
        return ce;
    }


    public List<TopicEntity> findCommentsByTopicId(Integer topicId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("FROM CommentEntity "); //where topic_id = ?");
        s.getTransaction().commit();
        List<TopicEntity> topicEntity = query.list();
        s.close();
        return topicEntity;
    }

    public CommentEntity findCommentById(Integer id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("FROM TopicEntity  " + id);
        CommentEntity commentEntity = (CommentEntity) query.uniqueResult();
        s.getTransaction().commit();
        s.close();
        logger.debug("user login " + id + " was getted from db");
        return commentEntity;

    }
}
