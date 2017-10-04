package com.example.dao;

import com.example.entity.UserRoleEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Query;




public class UserRoleDAO {

    final static Logger logger = Logger.getLogger(UserRoleEntity.class);

    public UserRoleEntity findById(Integer id){
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM UserRoleEntity WHERE id= "+id+" ");
        UserRoleEntity ure =(UserRoleEntity) q.uniqueResult();
        s.getTransaction().commit();
        s.close();
        logger.info("User with login"+id+" was getted from db");
        return ure;

    }

}


