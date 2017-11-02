package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.Subscription;

public interface SubscriptionDao {

    boolean addSubscriberDao(Subscription subscribe);

    Long getSubscriptionCount(String username);
}
