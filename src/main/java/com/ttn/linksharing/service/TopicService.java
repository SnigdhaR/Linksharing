package com.ttn.linksharing.service;

import com.ttn.linksharing.model.Topic;

import javax.servlet.http.HttpServletRequest;

public interface TopicService {

    void addorUpdTopic(Topic topic, HttpServletRequest request);

    Topic getTopic(long id);

    void deleteTopic(Topic topic);
}
