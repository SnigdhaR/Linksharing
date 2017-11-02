package com.ttn.linksharing.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
abstract class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int resource_id;
    String description;

    @OneToOne
    User createdBy;

    @OneToOne
    Topic topic;
    Date dateCreated;
    Date lastUpdate;

    @Override
    public String toString() {
        return "Resource{" +
                "resource_id=" + resource_id +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                ", dateCreated=" + dateCreated +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
