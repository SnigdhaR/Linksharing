package com.ttn.linksharing.model;

import com.ttnd.linksharing.Visibility;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Topic {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    Visibility visibility;

    @ManyToOne
    User createdBy;

    Date dateCreated=new Date();
    Date lastUpdated=new Date();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic", fetch = FetchType.LAZY)
    List<Subscription> subscriptionList;

//    ArrayList<Resource> resourceList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(ArrayList<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

//    public ArrayList<Resource> getResourceList() {
//        return resourceList;
//    }
//
//    public void setResourceList(ArrayList<Resource> resourceList) {
//        this.resourceList = resourceList;
//    }


    @Override
    public String toString() {
        return  name +
                " (visibility: " + visibility +
                ")\n";
    }
}



