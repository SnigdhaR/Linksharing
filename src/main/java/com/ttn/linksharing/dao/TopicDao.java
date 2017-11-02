package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.Topic;
import org.springframework.stereotype.Repository;

public interface TopicDao {

    void addorUpdTopic(Topic topic);

    Topic getTopic(long id);

    void deleteTopic(Topic topic);
}
