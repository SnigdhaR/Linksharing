package com.ttn.linksharing.service;

import com.ttn.linksharing.model.Topic;
import com.ttn.linksharing.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResourceService {

    boolean addLinkResource(User user, Topic topic, String url, String description);

    boolean addDocResource(User user, Topic topic, String filepath, String description);

    String singleFileUpload(MultipartFile multipartFile) throws IOException;
}
