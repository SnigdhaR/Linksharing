package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory ourSessionFactory;

    public void addorUpdUser(User user) {

        ourSessionFactory.getCurrentSession().saveOrUpdate(user);
    }


    public User getUser(long userid) {

        return (User) ourSessionFactory.getCurrentSession().get(User.class, userid);
    }

    public User getUserByUsernamePassword(String name, String pwd) {

        final Query query = ourSessionFactory.getCurrentSession().createQuery("from User where username=:userName and password=:passWord");
        query.setParameter("userName",name);
        query.setParameter("passWord",pwd);
        return (User) query.uniqueResult();
    }

    public  int updPwd(String mail, String pwd, User user) {
        final Query query = ourSessionFactory.getCurrentSession().createQuery("update User set password = :passwrd where email =:elmail");
        query.setParameter("passwrd",pwd);
        query.setParameter("elmail",mail);
       int res= query.executeUpdate();
       return  res;
    }

}
