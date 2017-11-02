package com.ttn.linksharing.service;

import com.ttn.linksharing.model.Topic;
import com.ttn.linksharing.model.User;

public interface SubscriptionService {

    boolean addSubscriber(User user, Topic topic, String seriousness);

    Long getSubscriptionCount(String username);
}
