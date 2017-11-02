package com.ttn.linksharing.model;

import javax.persistence.Entity;

@Entity
public class DocumentResource extends Resource{

    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "DocumentResource{" +
                "description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                ", dateCreated=" + dateCreated +
                ", lastUpdate=" + lastUpdate +

                ", filePath='" + filePath + '\'' +
                '}';
    }
}
