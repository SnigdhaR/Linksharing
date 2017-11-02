package com.ttn.linksharing.model;

import javax.persistence.Entity;

@Entity
public class LinkResource extends Resource{

    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LinkResource{" +
                "description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                ", dateCreated=" + dateCreated +
                ", lastUpdate=" + lastUpdate +

                ", url='" + url + '\'' +
                '}';
    }
}
