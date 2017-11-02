package com.ttn.linksharing.service;

import com.ttn.linksharing.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public interface UserService {

    void addorUpdUser(User user);

    User getUser(long userid);

    User getUserByUsernamePassword(String name, String pwd);

    void setPicture( MultipartFile[] fileUpload, User user) throws IOException;

    int resetPwd(String mail, String pwd, HttpServletRequest request);
}
