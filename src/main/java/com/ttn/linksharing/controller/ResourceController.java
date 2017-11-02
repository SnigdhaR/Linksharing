package com.ttn.linksharing.controller;

import com.ttn.linksharing.model.Topic;
import com.ttn.linksharing.model.User;

import com.ttn.linksharing.service.ResourceServiceImpl;
import com.ttn.linksharing.service.TopicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class ResourceController {

    @Autowired
    ResourceServiceImpl resourceService;

    @Autowired
    TopicServiceImpl topicService;

@RequestMapping(value = "/shareLink", method = RequestMethod.GET)
    public ModelAndView sharelink(@RequestParam("url") String url,
                                  @RequestParam("description") String description,
                                  @RequestParam("topic") String topicname, HttpSession session){

    User user=null;
    boolean check;
    Topic topic = null;
    List list = null;

    user = (User) session.getAttribute("session");
    ModelAndView modelAndView = new ModelAndView("redirect:/dashboard");

    list = (List) session.getAttribute("topiclist");

    Iterator iterator = list.iterator();
    while (iterator.hasNext())
    {
        Object o = (Object) iterator.next();
        Topic topic1 = (Topic) o;

        if(topic1.getName().compareTo(topicname) == 0)
        {
            topic = topic1;
        }
    }

//    List<Topic> topics = user.getTopicList();
//
//    session.setAttribute("topiclist", topics);
//
//    request.getRequestDispatcher("jsp/ShowReport.jsp").forward(request,
//            response);

    check = resourceService.addLinkResource(user,topic,url,description);
    if (check == true)
    {
        System.out.println("link resource controller get true");
        }
    else
    {
        System.out.println("link resource controller get false");
       }
    return modelAndView;
    }



    @RequestMapping(value = "/shareDoc", method = RequestMethod.POST)
    public ModelAndView shareDoc(@RequestParam("file")MultipartFile file,
                                 @RequestParam("description") String description,
                                 @RequestParam("topic") String topicname, HttpSession session) throws IOException {

        User user=null;
        boolean check;
        Topic topic = null;
        List list = null;
        String filepath = null;

        user = (User) session.getAttribute("session");
        ModelAndView modelAndView = new ModelAndView("redirect:/dashboard");

        list = (List) session.getAttribute("topiclist");

        Iterator iterator = list.iterator();
        while (iterator.hasNext())
        {
            Object o = (Object) iterator.next();
            Topic topic1 = (Topic) o;

            if(topic1.getName().compareTo(topicname) == 0)
            {
                topic = topic1;
            }
        }
        System.out.println(file.getName());
        filepath = resourceService.singleFileUpload(file);
        check = resourceService.addDocResource(user,topic,filepath,description);
        if (check == true)
        {
            System.out.println("doc resource controller get true");
        }
        else
        {
            System.out.println("doc resource controller get false");
        }
        return modelAndView;
    }

}
