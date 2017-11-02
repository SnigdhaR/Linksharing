package com.ttn.linksharing.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Subscription {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Topic topic;

    @ManyToOne
    User user;

    public enum Seriousness{
        CASUAL,
        SERIOUS,
        VERY_SERIOUS;
    }

    Seriousness seriousness;
    Date dateCreated;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

//    static Seriousness convert(String str) {
//        for (Seriousness seriousness : Seriousness.values()) {
//            if (seriousness.toString().equalsIgnoreCase(str)) {
//                return seriousness;
//            }
//        }
//        return null;
//    }

}
