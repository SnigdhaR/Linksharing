package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.DocumentResource;
import com.ttn.linksharing.model.LinkResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceDaoImpl {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public  boolean addLinkResourceDao (LinkResource linkResource)
    {
        try {
            Session session1 = sessionFactory.openSession();
            session1.beginTransaction();

            session1.save(linkResource);
            session1.getTransaction().commit();
            session1.close();
            return true;
        }catch (Exception e)
        {
            System.out.println("problem in adduserdao " + e);
        }
        return false;


    }

    public  boolean addDocResourceDao (DocumentResource documentResource)
    {
        try {
            Session session1 = sessionFactory.openSession();
            session1.beginTransaction();

            session1.save(documentResource);
            session1.getTransaction().commit();
            session1.close();
            return true;
        }catch (Exception e)
        {
            System.out.println("problem in adduserdao " + e);
        }
        return false;


    }
}
