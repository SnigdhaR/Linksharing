package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.Topic;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TopicDaoImpl implements TopicDao {

    @Autowired
    private SessionFactory ourSessionFactory;
  /*  static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }*/

    public void addorUpdTopic(Topic topic) {

        ourSessionFactory.getCurrentSession().saveOrUpdate(topic);
    }

    public Topic getTopic(long id) {

        return (Topic) ourSessionFactory.getCurrentSession().get(Topic.class, id);
    }

    public void deleteTopic(Topic topic) {

        ourSessionFactory.getCurrentSession().delete(topic);

    }
}
