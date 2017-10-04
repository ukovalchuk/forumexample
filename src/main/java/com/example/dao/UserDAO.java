package com.example.dao;


import com.example.entity.UserEntity;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class UserDAO {
    final static Logger logger = Logger.getLogger(UserEntity.class);

    public List<UserEntity> findAllUsers() {
        logger.debug("Retrieving all user");
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("FROM UserEntity ");
        s.getTransaction().commit();
        List<UserEntity> userEntities = query.list();
        s.close();
        return userEntities;
    }

    public UserEntity findUser(Integer id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM UserEntity WHERE id= " + id + " ");
        UserEntity ue = (UserEntity) q.uniqueResult();
        s.getTransaction().commit();
        s.close();
        logger.info("User with login" + id + " was getted from db");
        return ue;
    }

    public void createUser(UserEntity user) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Integer id = (Integer) s.save(user);
        s.getTransaction().commit();
        s.close();
        logger.info("New user id: " + id);

    }

    public UserEntity editUser(UserEntity user) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        UserEntity ue = (UserEntity) s.get(UserEntity.class, user.getId());
        ue.setEmail(user.getEmail());
        ue.setName(user.getName());
        ue.setId(user.getId());
        ue.setPassword(user.getPassword());
        ue.setUserRole(user.getUserRole());
        s.save(ue);
        s.getTransaction().commit();
        s.close();
        return ue;

    }

}
