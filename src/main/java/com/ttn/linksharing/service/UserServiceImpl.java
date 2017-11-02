package com.ttn.linksharing.service;

import com.ttn.linksharing.dao.UserDaoImpl;
import com.ttn.linksharing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@Service("userService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addorUpdUser(User user) {
        userDao.addorUpdUser(user);
    }

    public User getUser(long userid) {
        return userDao.getUser(userid);
    }

    public User getUserByUsernamePassword(String name, String pwd) {
        return userDao.getUserByUsernamePassword(name, pwd);
    }

    public void setPicture( MultipartFile[] fileUpload, User user) throws IOException{

        if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile file : fileUpload) {
                System.out.println("Saving file: " + file.getOriginalFilename());
                user.setPhoto(file.getBytes());
            }
//            System.out.println("length " + fileUpload.length);
        }
        else {
            File file = new File("C:\\Users\\MAHE\\Desktop\\TTN\\LinkSharing\\src\\main\\webapp\\resources\\images\\default-img.jpg");
            FileInputStream fis = new FileInputStream(file);
            byte ph[] = new byte[(int) file.length()];
            fis.read(ph);
            user.setPhoto(ph);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int resetPwd(String mail, String pwd, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("UserDetails");
//        user.setPassword(pwd);
        return userDao.updPwd(mail, pwd, user);
    }
}
