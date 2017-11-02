package com.ttn.linksharing.service;

import com.ttn.linksharing.model.Subscription;
import com.ttn.linksharing.model.Topic;
import com.ttn.linksharing.model.User;
import com.ttn.linksharing.dao.SubscriptionDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SubscriptionServiceImpl {

    @Autowired
    private SubscriptionDaoImpl subscriptionDao;

    public boolean addSubscriber(User user, Topic topic, String seriousness)
    {
        boolean check;

        try {
            Subscription subscription = new Subscription();
            subscription.setDateCreated(new Date());
            subscription.setTopic(topic);
            subscription.setUser(user);
            subscription.setSeriousness(Subscription.Seriousness.valueOf(seriousness));

            check = subscriptionDao.addSubscriberDao(subscription);
            return check;
        }
        catch (Exception e)
        {
            System.out.println("problem in addsubscriber " + e);
        }
        return false;


    }

    public Long getSubscriptionCount(String username)
    {

        return subscriptionDao.getSubscriptionCount(username);
    }
}
