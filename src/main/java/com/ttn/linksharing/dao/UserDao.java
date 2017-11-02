package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.User;

import java.util.List;


public interface UserDao {

 void addorUpdUser(User user);

 User getUser(long userid);

 User getUserByUsernamePassword(String name, String pwd);

 int updPwd(String mail, String pwd, User user);

}
