package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.Subscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDaoImpl {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public boolean addSubscriberDao(Subscription subscribe)
    {
        try {
            Session session1 = sessionFactory.openSession();
            session1.beginTransaction();

            session1.save(subscribe);
            session1.getTransaction().commit();
            session1.close();
            return true;
        }catch (Exception e)
        {
            System.out.println("problem in adduserdao " + e);
        }
        return false;


    }

    public Long getSubscriptionCount(String username)
    {
        Long count;
        Session session = sessionFactory.openSession();



        Query query = session.createQuery("select count(*) from Subscription as s left join User as u on s.id = u.userid where u.username = :user");
        query.setParameter("user", username);

        count = Long.valueOf(( (Long) query.iterate().next() ).intValue());

        System.out.println(count);
        return count;

    }
}
