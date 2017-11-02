package com.ttn.linksharing.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class User {

    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long userid;

    @NotEmpty(message = "Required field")
    @Email(message = "Please enter a valid email")
    private String email;
    @NotEmpty(message = "Required field")
    private String username;
    @NotEmpty(message = "Required field")
    @Size(min = 6, max = 15, message = "Password must be of 6 - 15 characters")
    private String password;
    @NotEmpty(message = "Required field")
    private String firstName;
    @NotEmpty(message = "Required field")
    private String lastName;

    @Transient @Lob  @Column(columnDefinition = "LONGBLOB")
    private byte[] photo;
    private Boolean isAdmin=false;
    private Boolean isActive=true;
    private Date dateCreated=new Date();
    private Date lastUpdated=new Date();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
     List<Subscription> subscriptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy", fetch = FetchType.EAGER)
    public List<Topic> topicList;

//    ArrayList<ReadingItem> readingItemList;
//   Resource, ResourceRating


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
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

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(ArrayList<Topic> topicList) {
        this.topicList = topicList;
    }

}
