package com.example.dao;

import com.example.entity.TopicEntity;
import com.example.entity.UserEntity;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class TopicDAO {
    final static Logger logger = Logger.getLogger(TopicEntity.class);

    public List<TopicEntity> findAll() {
        logger.debug("Retrieving all topic");
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("FROM TopicEntity ");
        s.getTransaction().commit();
        List<TopicEntity> topicEntities = query.list();
        s.close();
        return topicEntities;

    }

    /**
     * find topic by id
     * @param id topic id
     * @return TopicEntity
     */
    public TopicEntity findTopic(Integer id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("FROM TopicEntity  " + id);
        TopicEntity te = (TopicEntity) query.uniqueResult();
        s.getTransaction().commit();
        s.close();
        logger.debug("user login " + id + " was getted from db");
        return te;
    }

    public TopicEntity editTopic(TopicEntity topic) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        TopicEntity te = (TopicEntity) s.get(TopicEntity.class, topic.getId());
        te.setUserEntity(topic.getUserEntity());  //setUserId(topic.getUserId());
        te.setText(topic.getText());
        s.save(te);
        s.getTransaction().commit();
        s.close();
        return  te;

    }

    public void createTopic(TopicEntity topic) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(topic);
        s.getTransaction().commit();
        s.close();


    }
}
