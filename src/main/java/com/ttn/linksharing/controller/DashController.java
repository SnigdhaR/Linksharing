package com.ttn.linksharing.controller;

import com.ttn.linksharing.model.Topic;
import com.ttn.linksharing.model.User;
import com.ttn.linksharing.service.SubscriptionServiceImpl;
import com.ttn.linksharing.service.TopicService;
import com.ttn.linksharing.service.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class DashController {

    @Autowired
    private TopicServiceImpl topicService;
    private User user;

    @Autowired
    private SubscriptionServiceImpl subscriptionService;

    @ModelAttribute
    void addingObject(Model model)
    {
        model.addAttribute("user", new User());
    }

    @RequestMapping(value = "/getPhoto")
    public void getPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("UserDetails");
//        System.out.println("Photo of user: " + user.getFirstName());
        byte[] arr = user.getPhoto();
        response.getOutputStream().write(arr);
    }

    @RequestMapping(value = "/createtopic", method = RequestMethod.POST)
    ModelAndView createtopic(@ModelAttribute Topic topic, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        topicService.addorUpdTopic(topic, request);
        subscriptionService.addSubscriber(user, topic, "VERY_SERIOUS");
        model.setViewName("dashboard");
        return model;
    }

        @RequestMapping(value = "/displaytopics", method = RequestMethod.GET)
        @ResponseBody
        String displaytopics(HttpServletRequest request) {
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("UserDetails");
        String result = "<b>TOPICS: </b><br><br><p>"+user.getTopicList()+"</p>";

        return result;
    }


    @RequestMapping(value = "/logout", method=RequestMethod.GET)
        public String logout(HttpSession session) {
            session.invalidate();
            return "homepg";
    }
    
}
