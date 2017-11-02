package com.ttn.linksharing.controller;

import com.ttn.linksharing.model.User;
import com.ttn.linksharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	private User user;

	@ModelAttribute
	void addingObject(Model model)
	{
		model.addAttribute("user", new User());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView hello() {

		ModelAndView model = new ModelAndView();
		model.setViewName("homepg");

		return model;

	}

	@RequestMapping(value = "/forgotpwd", method = RequestMethod.GET)
	public ModelAndView forgotpwd() {

		ModelAndView modelf = new ModelAndView();
		modelf.setViewName("forgotpassword");

		return modelf;
	}

	@RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
	public ModelAndView resetpwd(@ModelAttribute User user, @RequestParam("email") String mail, @RequestParam("password") String pwd, HttpServletRequest request) {

		ModelAndView modelf = new ModelAndView();

		int result= userService.resetPwd(mail, pwd, request);
		modelf.setViewName("homepg");
		if(result>0)
		{
			modelf.addObject("msg","*Your password has been reset successfully!");
		}
		return modelf;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String pwd, HttpServletRequest request)  {

		HttpSession session = request.getSession();

		ModelAndView modelAndView = new ModelAndView();

		user = userService.getUserByUsernamePassword(name, pwd);
		if (user != null) {
			if (name.equals(user.getUsername())) {
				session.setAttribute("UserDetails", user);
				modelAndView.setViewName("dashboard");
			}
		}
		else {
			modelAndView.setViewName("homepg");
			modelAndView.addObject("msg","*Wrong Username/Password");
		}
		return modelAndView;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	ModelAndView register(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
					   @RequestParam("file") MultipartFile[] fileUpload, HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (bindingResult.hasErrors()) {
			ModelAndView modelrep = new ModelAndView("homepg");
			return modelrep;
		}

		try {
			userService.setPicture(fileUpload,user);
		} catch (Exception e) {
			System.out.println("Exception occurred while uploading Photo- "+e);
		}

		ModelAndView modelAndView = new ModelAndView();
		userService.addorUpdUser(user);

		session.setAttribute("UserDetails", user);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

}